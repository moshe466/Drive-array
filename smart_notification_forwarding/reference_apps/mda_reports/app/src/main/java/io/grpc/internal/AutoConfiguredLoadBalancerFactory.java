package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.LoadBalancerRegistry;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.ServiceConfigUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class AutoConfiguredLoadBalancerFactory extends LoadBalancer.Factory {
    private static final String GRPCLB_POLICY_NAME = "grpclb";
    private static final Logger logger = Logger.getLogger(AutoConfiguredLoadBalancerFactory.class.getName());
    private final String defaultPolicy;
    private final LoadBalancerRegistry registry;

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public final class AutoConfiguredLoadBalancer extends LoadBalancer {
        private LoadBalancer delegate;
        private LoadBalancerProvider delegateProvider;
        private final LoadBalancer.Helper helper;
        private boolean roundRobinDueToGrpclbDepMissing;

        AutoConfiguredLoadBalancer(LoadBalancer.Helper helper) {
            this.helper = helper;
            this.delegateProvider = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(AutoConfiguredLoadBalancerFactory.this.defaultPolicy);
            LoadBalancerProvider loadBalancerProvider = this.delegateProvider;
            if (loadBalancerProvider != null) {
                this.delegate = loadBalancerProvider.newLoadBalancer(helper);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + AutoConfiguredLoadBalancerFactory.this.defaultPolicy + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        @VisibleForTesting
        PolicySelection a(List<EquivalentAddressGroup> list, @Nullable Map<String, ?> map) {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (EquivalentAddressGroup equivalentAddressGroup : list) {
                if (equivalentAddressGroup.getAttributes().get(GrpcAttributes.ATTR_LB_ADDR_AUTHORITY) != null) {
                    z = true;
                } else {
                    arrayList.add(equivalentAddressGroup);
                }
            }
            List<ServiceConfigUtil.LbConfig> unwrapLoadBalancingConfigList = map != null ? ServiceConfigUtil.unwrapLoadBalancingConfigList(ServiceConfigUtil.getLoadBalancingConfigsFromServiceConfig(map)) : null;
            if (unwrapLoadBalancingConfigList != null && !unwrapLoadBalancingConfigList.isEmpty()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (ServiceConfigUtil.LbConfig lbConfig : unwrapLoadBalancingConfigList) {
                    String policyName = lbConfig.getPolicyName();
                    LoadBalancerProvider provider = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(policyName);
                    if (provider != null) {
                        if (!linkedHashSet.isEmpty()) {
                            this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.DEBUG, "{0} specified by Service Config are not available", linkedHashSet);
                        }
                        if (!policyName.equals(AutoConfiguredLoadBalancerFactory.GRPCLB_POLICY_NAME)) {
                            list = arrayList;
                        }
                        return new PolicySelection(provider, list, lbConfig.getRawConfigValue());
                    }
                    linkedHashSet.add(policyName);
                }
                if (!z) {
                    throw new PolicyException("None of " + linkedHashSet + " specified by Service Config are available.");
                }
            }
            if (!z) {
                this.roundRobinDueToGrpclbDepMissing = false;
                AutoConfiguredLoadBalancerFactory autoConfiguredLoadBalancerFactory = AutoConfiguredLoadBalancerFactory.this;
                return new PolicySelection(autoConfiguredLoadBalancerFactory.getProviderOrThrow(autoConfiguredLoadBalancerFactory.defaultPolicy, "using default policy"), list, null);
            }
            LoadBalancerProvider provider2 = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(AutoConfiguredLoadBalancerFactory.GRPCLB_POLICY_NAME);
            if (provider2 != null) {
                return new PolicySelection(provider2, list, null);
            }
            if (arrayList.isEmpty()) {
                throw new PolicyException("Received ONLY balancer addresses but grpclb runtime is missing");
            }
            if (!this.roundRobinDueToGrpclbDepMissing) {
                this.roundRobinDueToGrpclbDepMissing = true;
                this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.ERROR, "Found balancer addresses but grpclb runtime is missing. Will use round_robin. Please include grpc-grpclb in your runtime depedencies.");
                AutoConfiguredLoadBalancerFactory.logger.warning("Found balancer addresses but grpclb runtime is missing. Will use round_robin. Please include grpc-grpclb in your runtime depedencies.");
            }
            return new PolicySelection(AutoConfiguredLoadBalancerFactory.this.getProviderOrThrow("round_robin", "received balancer addresses but grpclb runtime is missing"), arrayList, null);
        }

        @Override // io.grpc.LoadBalancer
        public boolean canHandleEmptyAddressListFromNameResolution() {
            return true;
        }

        @VisibleForTesting
        public LoadBalancer getDelegate() {
            return this.delegate;
        }

        @Override // io.grpc.LoadBalancer
        public void handleNameResolutionError(Status status) {
            getDelegate().handleNameResolutionError(status);
        }

        @Override // io.grpc.LoadBalancer
        public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
            List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
            Attributes attributes = resolvedAddresses.getAttributes();
            if (attributes.get(LoadBalancer.ATTR_LOAD_BALANCING_CONFIG) != null) {
                throw new IllegalArgumentException("Unexpected ATTR_LOAD_BALANCING_CONFIG from upstream: " + attributes.get(LoadBalancer.ATTR_LOAD_BALANCING_CONFIG));
            }
            try {
                PolicySelection a = a(addresses, (Map) attributes.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG));
                if (this.delegateProvider == null || !a.a.getPolicyName().equals(this.delegateProvider.getPolicyName())) {
                    this.helper.updateBalancingState(ConnectivityState.CONNECTING, new EmptyPicker());
                    this.delegate.shutdown();
                    this.delegateProvider = a.a;
                    LoadBalancer loadBalancer = this.delegate;
                    this.delegate = this.delegateProvider.newLoadBalancer(this.helper);
                    this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.INFO, "Load balancer changed from {0} to {1}", loadBalancer.getClass().getSimpleName(), this.delegate.getClass().getSimpleName());
                }
                if (a.c != null) {
                    this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.DEBUG, "Load-balancing config: {0}", a.c);
                    attributes = attributes.toBuilder().set(LoadBalancer.ATTR_LOAD_BALANCING_CONFIG, a.c).build();
                }
                LoadBalancer delegate = getDelegate();
                if (!a.b.isEmpty() || delegate.canHandleEmptyAddressListFromNameResolution()) {
                    delegate.handleResolvedAddresses(LoadBalancer.ResolvedAddresses.newBuilder().setAddresses(a.b).setAttributes(attributes).build());
                    return;
                }
                delegate.handleNameResolutionError(Status.UNAVAILABLE.withDescription("Name resolver returned no usable address. addrs=" + addresses + ", attrs=" + attributes));
            } catch (PolicyException e) {
                this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new FailingPicker(Status.INTERNAL.withDescription(e.getMessage())));
                this.delegate.shutdown();
                this.delegateProvider = null;
                this.delegate = new NoopLoadBalancer();
            }
        }

        @Override // io.grpc.LoadBalancer
        public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
            getDelegate().handleSubchannelState(subchannel, connectivityStateInfo);
        }

        @Override // io.grpc.LoadBalancer
        public void shutdown() {
            this.delegate.shutdown();
            this.delegate = null;
        }
    }

    /* loaded from: classes2.dex */
    private static final class EmptyPicker extends LoadBalancer.SubchannelPicker {
        private EmptyPicker() {
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return LoadBalancer.PickResult.withNoResult();
        }
    }

    /* loaded from: classes2.dex */
    private static final class FailingPicker extends LoadBalancer.SubchannelPicker {
        private final Status failure;

        FailingPicker(Status status) {
            this.failure = status;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return LoadBalancer.PickResult.withError(this.failure);
        }
    }

    /* loaded from: classes2.dex */
    private static final class NoopLoadBalancer extends LoadBalancer {
        private NoopLoadBalancer() {
        }

        @Override // io.grpc.LoadBalancer
        public void handleNameResolutionError(Status status) {
        }

        @Override // io.grpc.LoadBalancer
        @Deprecated
        public void handleResolvedAddressGroups(List<EquivalentAddressGroup> list, Attributes attributes) {
        }

        @Override // io.grpc.LoadBalancer
        public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        }

        @Override // io.grpc.LoadBalancer
        public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        }

        @Override // io.grpc.LoadBalancer
        public void shutdown() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class PolicyException extends Exception {
        private static final long serialVersionUID = 1;

        private PolicyException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class PolicySelection {
        final LoadBalancerProvider a;

        @Nullable
        final List<EquivalentAddressGroup> b;

        @Nullable
        final Map<String, ?> c;

        PolicySelection(LoadBalancerProvider loadBalancerProvider, List<EquivalentAddressGroup> list, @Nullable Map<String, ?> map) {
            this.a = (LoadBalancerProvider) Preconditions.checkNotNull(loadBalancerProvider, "provider");
            this.b = Collections.unmodifiableList((List) Preconditions.checkNotNull(list, "serverList"));
            this.c = map;
        }
    }

    @VisibleForTesting
    AutoConfiguredLoadBalancerFactory(LoadBalancerRegistry loadBalancerRegistry, String str) {
        this.registry = (LoadBalancerRegistry) Preconditions.checkNotNull(loadBalancerRegistry, "registry");
        this.defaultPolicy = (String) Preconditions.checkNotNull(str, "defaultPolicy");
    }

    public AutoConfiguredLoadBalancerFactory(String str) {
        this(LoadBalancerRegistry.getDefaultRegistry(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LoadBalancerProvider getProviderOrThrow(String str, String str2) {
        LoadBalancerProvider provider = this.registry.getProvider(str);
        if (provider != null) {
            return provider;
        }
        throw new PolicyException("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public NameResolver.ConfigOrError a(Map<String, ?> map) {
        List<ServiceConfigUtil.LbConfig> unwrapLoadBalancingConfigList;
        if (map != null) {
            try {
                unwrapLoadBalancingConfigList = ServiceConfigUtil.unwrapLoadBalancingConfigList(ServiceConfigUtil.getLoadBalancingConfigsFromServiceConfig(map));
            } catch (RuntimeException e) {
                return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("can't parse load balancer configuration").withCause(e));
            }
        } else {
            unwrapLoadBalancingConfigList = null;
        }
        if (unwrapLoadBalancingConfigList == null || unwrapLoadBalancingConfigList.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ServiceConfigUtil.LbConfig lbConfig : unwrapLoadBalancingConfigList) {
            String policyName = lbConfig.getPolicyName();
            LoadBalancerProvider provider = this.registry.getProvider(policyName);
            if (provider != null) {
                return NameResolver.ConfigOrError.fromConfig(new PolicySelection(provider, null, lbConfig.getRawConfigValue()));
            }
            arrayList.add(policyName);
        }
        return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("None of " + arrayList + " specified by Service Config are available."));
    }

    @Override // io.grpc.LoadBalancer.Factory
    public LoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new AutoConfiguredLoadBalancer(helper);
    }
}
