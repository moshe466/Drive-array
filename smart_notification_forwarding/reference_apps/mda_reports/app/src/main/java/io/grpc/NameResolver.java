package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
/* loaded from: classes2.dex */
public abstract class NameResolver {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: classes2.dex */
    public static final class Args {
        private final int defaultPort;
        private final ProxyDetector proxyDetector;
        private final ServiceConfigParser serviceConfigParser;
        private final SynchronizationContext syncContext;

        /* loaded from: classes2.dex */
        public static final class Builder {
            private Integer defaultPort;
            private ProxyDetector proxyDetector;
            private ServiceConfigParser serviceConfigParser;
            private SynchronizationContext syncContext;

            Builder() {
            }

            public Args build() {
                return new Args(this.defaultPort, this.proxyDetector, this.syncContext, this.serviceConfigParser);
            }

            public Builder setDefaultPort(int i) {
                this.defaultPort = Integer.valueOf(i);
                return this;
            }

            public Builder setProxyDetector(ProxyDetector proxyDetector) {
                this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector);
                return this;
            }

            public Builder setServiceConfigParser(ServiceConfigParser serviceConfigParser) {
                this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser);
                return this;
            }

            public Builder setSynchronizationContext(SynchronizationContext synchronizationContext) {
                this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(synchronizationContext);
                return this;
            }
        }

        Args(Integer num, ProxyDetector proxyDetector, SynchronizationContext synchronizationContext, ServiceConfigParser serviceConfigParser) {
            this.defaultPort = ((Integer) Preconditions.checkNotNull(num, "defaultPort not set")).intValue();
            this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector, "proxyDetector not set");
            this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(synchronizationContext, "syncContext not set");
            this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser, "serviceConfigParser not set");
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public int getDefaultPort() {
            return this.defaultPort;
        }

        public ProxyDetector getProxyDetector() {
            return this.proxyDetector;
        }

        public ServiceConfigParser getServiceConfigParser() {
            return this.serviceConfigParser;
        }

        public SynchronizationContext getSynchronizationContext() {
            return this.syncContext;
        }

        public Builder toBuilder() {
            Builder builder = new Builder();
            builder.setDefaultPort(this.defaultPort);
            builder.setProxyDetector(this.proxyDetector);
            builder.setSynchronizationContext(this.syncContext);
            builder.setServiceConfigParser(this.serviceConfigParser);
            return builder;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("defaultPort", this.defaultPort).add("proxyDetector", this.proxyDetector).add("syncContext", this.syncContext).add("serviceConfigParser", this.serviceConfigParser).toString();
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: classes2.dex */
    public static final class ConfigOrError {
        private final Object config;
        private final Status status;

        private ConfigOrError(Status status) {
            this.config = null;
            this.status = (Status) Preconditions.checkNotNull(status, "status");
            Preconditions.checkArgument(!status.isOk(), "cannot use OK status: %s", status);
        }

        private ConfigOrError(Object obj) {
            this.config = Preconditions.checkNotNull(obj, "config");
            this.status = null;
        }

        public static ConfigOrError fromConfig(Object obj) {
            return new ConfigOrError(obj);
        }

        public static ConfigOrError fromError(Status status) {
            return new ConfigOrError(status);
        }

        @Nullable
        public Object getConfig() {
            return this.config;
        }

        @Nullable
        public Status getError() {
            return this.status;
        }

        public String toString() {
            MoreObjects.ToStringHelper stringHelper;
            Object obj;
            String str;
            if (this.config != null) {
                stringHelper = MoreObjects.toStringHelper(this);
                obj = this.config;
                str = "config";
            } else {
                stringHelper = MoreObjects.toStringHelper(this);
                obj = this.status;
                str = "error";
            }
            return stringHelper.add(str, obj).toString();
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: classes2.dex */
    public static abstract class Factory {

        @Deprecated
        public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = Attributes.Key.create("params-default-port");

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5113")
        @Deprecated
        public static final Attributes.Key<ProxyDetector> PARAMS_PROXY_DETECTOR = Attributes.Key.create("params-proxy-detector");

        @Deprecated
        private static final Attributes.Key<SynchronizationContext> PARAMS_SYNC_CONTEXT = Attributes.Key.create("params-sync-context");

        @Deprecated
        private static final Attributes.Key<ServiceConfigParser> PARAMS_PARSER = Attributes.Key.create("params-parser");

        public abstract String getDefaultScheme();

        @Nullable
        @Deprecated
        public NameResolver newNameResolver(URI uri, Attributes attributes) {
            return newNameResolver(uri, Args.newBuilder().setDefaultPort(((Integer) attributes.get(PARAMS_DEFAULT_PORT)).intValue()).setProxyDetector((ProxyDetector) attributes.get(PARAMS_PROXY_DETECTOR)).setSynchronizationContext((SynchronizationContext) attributes.get(PARAMS_SYNC_CONTEXT)).setServiceConfigParser((ServiceConfigParser) attributes.get(PARAMS_PARSER)).build());
        }

        public NameResolver newNameResolver(URI uri, final Args args) {
            return newNameResolver(uri, new Helper(this) { // from class: io.grpc.NameResolver.Factory.2
                @Override // io.grpc.NameResolver.Helper
                public int getDefaultPort() {
                    return args.getDefaultPort();
                }

                @Override // io.grpc.NameResolver.Helper
                public ProxyDetector getProxyDetector() {
                    return args.getProxyDetector();
                }

                @Override // io.grpc.NameResolver.Helper
                public SynchronizationContext getSynchronizationContext() {
                    return args.getSynchronizationContext();
                }

                @Override // io.grpc.NameResolver.Helper
                public ConfigOrError parseServiceConfig(Map<String, ?> map) {
                    return args.getServiceConfigParser().parseServiceConfig(map);
                }
            });
        }

        @Nullable
        @Deprecated
        public NameResolver newNameResolver(URI uri, final Helper helper) {
            return newNameResolver(uri, Attributes.newBuilder().set(PARAMS_DEFAULT_PORT, Integer.valueOf(helper.getDefaultPort())).set(PARAMS_PROXY_DETECTOR, helper.getProxyDetector()).set(PARAMS_SYNC_CONTEXT, helper.getSynchronizationContext()).set(PARAMS_PARSER, new ServiceConfigParser(this) { // from class: io.grpc.NameResolver.Factory.1
                @Override // io.grpc.NameResolver.ServiceConfigParser
                public ConfigOrError parseServiceConfig(Map<String, ?> map) {
                    return helper.parseServiceConfig(map);
                }
            }).build());
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    @Deprecated
    /* loaded from: classes2.dex */
    public static abstract class Helper {
        public abstract int getDefaultPort();

        public abstract ProxyDetector getProxyDetector();

        public SynchronizationContext getSynchronizationContext() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public ConfigOrError parseServiceConfig(Map<String, ?> map) {
            throw new UnsupportedOperationException("should have been implemented");
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    @ThreadSafe
    /* loaded from: classes2.dex */
    public interface Listener {
        void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes);

        void onError(Status status);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: classes2.dex */
    public static abstract class Listener2 implements Listener {
        @Override // io.grpc.NameResolver.Listener
        @Deprecated
        public final void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes) {
            onResult(ResolutionResult.newBuilder().setAddresses(list).setAttributes(attributes).build());
        }

        @Override // io.grpc.NameResolver.Listener
        public abstract void onError(Status status);

        public abstract void onResult(ResolutionResult resolutionResult);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: classes2.dex */
    public static final class ResolutionResult {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;

        @Nullable
        private final ConfigOrError serviceConfig;

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
        /* loaded from: classes2.dex */
        public static final class Builder {
            private List<EquivalentAddressGroup> addresses = Collections.emptyList();
            private Attributes attributes = Attributes.EMPTY;

            @Nullable
            private ConfigOrError serviceConfig;

            Builder() {
            }

            public ResolutionResult build() {
                return new ResolutionResult(this.addresses, this.attributes, this.serviceConfig);
            }

            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                this.addresses = list;
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attributes = attributes;
                return this;
            }

            public Builder setServiceConfig(@Nullable ConfigOrError configOrError) {
                this.serviceConfig = configOrError;
                return this;
            }
        }

        ResolutionResult(List<EquivalentAddressGroup> list, Attributes attributes, ConfigOrError configOrError) {
            this.addresses = Collections.unmodifiableList(new ArrayList(list));
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes, "attributes");
            this.serviceConfig = configOrError;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResolutionResult)) {
                return false;
            }
            ResolutionResult resolutionResult = (ResolutionResult) obj;
            return Objects.equal(this.addresses, resolutionResult.addresses) && Objects.equal(this.attributes, resolutionResult.attributes) && Objects.equal(this.serviceConfig, resolutionResult.serviceConfig);
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        @Nullable
        public ConfigOrError getServiceConfig() {
            return this.serviceConfig;
        }

        public int hashCode() {
            return Objects.hashCode(this.addresses, this.attributes, this.serviceConfig);
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setServiceConfig(this.serviceConfig);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("addresses", this.addresses).add("attributes", this.attributes).add("serviceConfig", this.serviceConfig).toString();
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ResolutionResultAttr {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: classes2.dex */
    public static abstract class ServiceConfigParser {
        public abstract ConfigOrError parseServiceConfig(Map<String, ?> map);
    }

    public abstract String getServiceAuthority();

    public void refresh() {
    }

    public abstract void shutdown();

    public void start(Listener2 listener2) {
        start((Listener) listener2);
    }

    public void start(final Listener listener) {
        if (listener instanceof Listener2) {
            start((Listener2) listener);
        } else {
            start(new Listener2(this) { // from class: io.grpc.NameResolver.1
                @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
                public void onError(Status status) {
                    listener.onError(status);
                }

                @Override // io.grpc.NameResolver.Listener2
                public void onResult(ResolutionResult resolutionResult) {
                    listener.onAddresses(resolutionResult.getAddresses(), resolutionResult.getAttributes());
                }
            });
        }
    }
}
