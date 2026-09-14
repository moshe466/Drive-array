package io.grpc;

import com.google.common.base.MoreObjects;
import io.grpc.LoadBalancer;
import io.grpc.NameResolver;
import java.util.Map;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
/* loaded from: classes2.dex */
public abstract class LoadBalancerProvider extends LoadBalancer.Factory {
    private static final NameResolver.ConfigOrError UNKNOWN_CONFIG = NameResolver.ConfigOrError.fromConfig(new UnknownConfig());

    /* loaded from: classes2.dex */
    private static final class UnknownConfig {
        UnknownConfig() {
        }

        public String toString() {
            return "service config is unused";
        }
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public abstract String getPolicyName();

    public abstract int getPriority();

    public final int hashCode() {
        return super.hashCode();
    }

    public abstract boolean isAvailable();

    public NameResolver.ConfigOrError parseLoadBalancingPolicyConfig(Map<String, ?> map) {
        return UNKNOWN_CONFIG;
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("policy", getPolicyName()).add("priority", getPriority()).add("available", isAvailable()).toString();
    }
}
