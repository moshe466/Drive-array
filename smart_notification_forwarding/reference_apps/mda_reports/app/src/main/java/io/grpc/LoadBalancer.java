package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.NameResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
@NotThreadSafe
/* loaded from: classes2.dex */
public abstract class LoadBalancer {
    public static final Attributes.Key<Map<String, ?>> ATTR_LOAD_BALANCING_CONFIG = Attributes.Key.create("io.grpc.LoadBalancer.loadBalancingConfig");

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    @ThreadSafe
    /* loaded from: classes2.dex */
    public static abstract class Factory {
        public abstract LoadBalancer newLoadBalancer(Helper helper);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    @ThreadSafe
    /* loaded from: classes.dex */
    public static abstract class Helper {
        public abstract ManagedChannel createOobChannel(EquivalentAddressGroup equivalentAddressGroup, String str);

        public ManagedChannel createResolvingOobChannel(String str) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public final Subchannel createSubchannel(EquivalentAddressGroup equivalentAddressGroup, Attributes attributes) {
            Preconditions.checkNotNull(equivalentAddressGroup, "addrs");
            return createSubchannel(Collections.singletonList(equivalentAddressGroup), attributes);
        }

        public Subchannel createSubchannel(List<EquivalentAddressGroup> list, Attributes attributes) {
            throw new UnsupportedOperationException();
        }

        public abstract String getAuthority();

        public ChannelLogger getChannelLogger() {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public abstract NameResolver.Factory getNameResolverFactory();

        public ScheduledExecutorService getScheduledExecutorService() {
            throw new UnsupportedOperationException();
        }

        public SynchronizationContext getSynchronizationContext() {
            throw new UnsupportedOperationException();
        }

        public void refreshNameResolution() {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public void runSerialized(Runnable runnable) {
            getSynchronizationContext().execute(runnable);
        }

        public abstract void updateBalancingState(@Nonnull ConnectivityState connectivityState, @Nonnull SubchannelPicker subchannelPicker);

        public void updateOobChannelAddresses(ManagedChannel managedChannel, EquivalentAddressGroup equivalentAddressGroup) {
            throw new UnsupportedOperationException();
        }

        public final void updateSubchannelAddresses(Subchannel subchannel, EquivalentAddressGroup equivalentAddressGroup) {
            Preconditions.checkNotNull(equivalentAddressGroup, "addrs");
            updateSubchannelAddresses(subchannel, Collections.singletonList(equivalentAddressGroup));
        }

        public void updateSubchannelAddresses(Subchannel subchannel, List<EquivalentAddressGroup> list) {
            throw new UnsupportedOperationException();
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    @Immutable
    /* loaded from: classes2.dex */
    public static final class PickResult {
        private static final PickResult NO_RESULT = new PickResult(null, null, Status.OK, false);
        private final boolean drop;
        private final Status status;

        @Nullable
        private final ClientStreamTracer.Factory streamTracerFactory;

        @Nullable
        private final Subchannel subchannel;

        private PickResult(@Nullable Subchannel subchannel, @Nullable ClientStreamTracer.Factory factory, Status status, boolean z) {
            this.subchannel = subchannel;
            this.streamTracerFactory = factory;
            this.status = (Status) Preconditions.checkNotNull(status, "status");
            this.drop = z;
        }

        public static PickResult withDrop(Status status) {
            Preconditions.checkArgument(!status.isOk(), "drop status shouldn't be OK");
            return new PickResult(null, null, status, true);
        }

        public static PickResult withError(Status status) {
            Preconditions.checkArgument(!status.isOk(), "error status shouldn't be OK");
            return new PickResult(null, null, status, false);
        }

        public static PickResult withNoResult() {
            return NO_RESULT;
        }

        public static PickResult withSubchannel(Subchannel subchannel) {
            return withSubchannel(subchannel, null);
        }

        public static PickResult withSubchannel(Subchannel subchannel, @Nullable ClientStreamTracer.Factory factory) {
            return new PickResult((Subchannel) Preconditions.checkNotNull(subchannel, "subchannel"), factory, Status.OK, false);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PickResult)) {
                return false;
            }
            PickResult pickResult = (PickResult) obj;
            return Objects.equal(this.subchannel, pickResult.subchannel) && Objects.equal(this.status, pickResult.status) && Objects.equal(this.streamTracerFactory, pickResult.streamTracerFactory) && this.drop == pickResult.drop;
        }

        public Status getStatus() {
            return this.status;
        }

        @Nullable
        public ClientStreamTracer.Factory getStreamTracerFactory() {
            return this.streamTracerFactory;
        }

        @Nullable
        public Subchannel getSubchannel() {
            return this.subchannel;
        }

        public int hashCode() {
            return Objects.hashCode(this.subchannel, this.status, this.streamTracerFactory, Boolean.valueOf(this.drop));
        }

        public boolean isDrop() {
            return this.drop;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("subchannel", this.subchannel).add("streamTracerFactory", this.streamTracerFactory).add("status", this.status).add("drop", this.drop).toString();
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: classes2.dex */
    public static abstract class PickSubchannelArgs {
        public abstract CallOptions getCallOptions();

        public abstract Metadata getHeaders();

        public abstract MethodDescriptor<?, ?> getMethodDescriptor();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: classes2.dex */
    public static final class ResolvedAddresses {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;

        @Nullable
        private final Object loadBalancingPolicyConfig;

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
        /* loaded from: classes2.dex */
        public static final class Builder {
            private List<EquivalentAddressGroup> addresses;
            private Attributes attributes = Attributes.EMPTY;

            @Nullable
            private Object loadBalancingPolicyConfig;

            Builder() {
            }

            public ResolvedAddresses build() {
                return new ResolvedAddresses(this.addresses, this.attributes, this.loadBalancingPolicyConfig);
            }

            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                this.addresses = list;
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attributes = attributes;
                return this;
            }

            public Builder setLoadBalancingPolicyConfig(@Nullable Object obj) {
                this.loadBalancingPolicyConfig = obj;
                return this;
            }
        }

        private ResolvedAddresses(List<EquivalentAddressGroup> list, Attributes attributes, Object obj) {
            this.addresses = Collections.unmodifiableList(new ArrayList((Collection) Preconditions.checkNotNull(list, "addresses")));
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes, "attributes");
            this.loadBalancingPolicyConfig = obj;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResolvedAddresses)) {
                return false;
            }
            ResolvedAddresses resolvedAddresses = (ResolvedAddresses) obj;
            return Objects.equal(this.addresses, resolvedAddresses.addresses) && Objects.equal(this.attributes, resolvedAddresses.attributes) && Objects.equal(this.loadBalancingPolicyConfig, resolvedAddresses.loadBalancingPolicyConfig);
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        @Nullable
        public Object getLoadBalancingPolicyConfig() {
            return this.loadBalancingPolicyConfig;
        }

        public int hashCode() {
            return Objects.hashCode(this.addresses, this.attributes, this.loadBalancingPolicyConfig);
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setLoadBalancingPolicyConfig(this.loadBalancingPolicyConfig);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addresses", this.addresses).add("attributes", this.attributes).add("loadBalancingPolicyConfig", this.loadBalancingPolicyConfig).toString();
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    /* loaded from: classes2.dex */
    public static abstract class Subchannel {
        @Internal
        public Channel asChannel() {
            throw new UnsupportedOperationException();
        }

        public final EquivalentAddressGroup getAddresses() {
            List<EquivalentAddressGroup> allAddresses = getAllAddresses();
            Preconditions.checkState(allAddresses.size() == 1, "Does not have exactly one group");
            return allAddresses.get(0);
        }

        public List<EquivalentAddressGroup> getAllAddresses() {
            throw new UnsupportedOperationException();
        }

        public abstract Attributes getAttributes();

        public ChannelLogger getChannelLogger() {
            throw new UnsupportedOperationException();
        }

        public abstract void requestConnection();

        public abstract void shutdown();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
    @ThreadSafe
    /* loaded from: classes.dex */
    public static abstract class SubchannelPicker {
        public abstract PickResult pickSubchannel(PickSubchannelArgs pickSubchannelArgs);

        public void requestConnection() {
        }
    }

    public boolean canHandleEmptyAddressListFromNameResolution() {
        return false;
    }

    public abstract void handleNameResolutionError(Status status);

    @Deprecated
    public void handleResolvedAddressGroups(List<EquivalentAddressGroup> list, Attributes attributes) {
        handleResolvedAddresses(ResolvedAddresses.newBuilder().setAddresses(list).setAttributes(attributes).build());
    }

    public void handleResolvedAddresses(ResolvedAddresses resolvedAddresses) {
        handleResolvedAddressGroups(resolvedAddresses.getAddresses(), resolvedAddresses.getAttributes());
    }

    public abstract void handleSubchannelState(Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo);

    public abstract void shutdown();
}
