package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Verify;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.RetriableStream;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
final class ManagedChannelServiceConfig {

    @Nullable
    private final Object loadBalancingConfig;

    @Nullable
    private final RetriableStream.Throttle retryThrottling;
    private final Map<String, MethodInfo> serviceMap;
    private final Map<String, MethodInfo> serviceMethodMap;

    /* loaded from: classes2.dex */
    static final class MethodInfo {
        final Long a;
        final Boolean b;
        final Integer c;
        final Integer d;
        final RetryPolicy e;
        final HedgingPolicy f;

        MethodInfo(Map<String, ?> map, boolean z, int i, int i2) {
            this.a = ServiceConfigUtil.r(map);
            this.b = ServiceConfigUtil.s(map);
            this.c = ServiceConfigUtil.i(map);
            Integer num = this.c;
            if (num != null) {
                Preconditions.checkArgument(num.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", this.c);
            }
            this.d = ServiceConfigUtil.h(map);
            Integer num2 = this.d;
            if (num2 != null) {
                Preconditions.checkArgument(num2.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", this.d);
            }
            Map<String, ?> n = z ? ServiceConfigUtil.n(map) : null;
            this.e = n == null ? RetryPolicy.f : retryPolicy(n, i);
            Map<String, ?> c = z ? ServiceConfigUtil.c(map) : null;
            this.f = c == null ? HedgingPolicy.d : hedgingPolicy(c, i2);
        }

        private static HedgingPolicy hedgingPolicy(Map<String, ?> map, int i) {
            int intValue = ((Integer) Preconditions.checkNotNull(ServiceConfigUtil.e(map), "maxAttempts cannot be empty")).intValue();
            Preconditions.checkArgument(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i);
            long longValue = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.b(map), "hedgingDelay cannot be empty")).longValue();
            Preconditions.checkArgument(longValue >= 0, "hedgingDelay must not be negative: %s", longValue);
            List<String> m = ServiceConfigUtil.m(map);
            Preconditions.checkNotNull(m, "rawCodes must be present");
            Preconditions.checkArgument(!m.isEmpty(), "rawCodes can't be empty");
            EnumSet noneOf = EnumSet.noneOf(Status.Code.class);
            for (String str : m) {
                Verify.verify(!"OK".equals(str), "rawCode can not be \"OK\"", new Object[0]);
                noneOf.add(Status.Code.valueOf(str));
            }
            return new HedgingPolicy(min, longValue, Collections.unmodifiableSet(noneOf));
        }

        private static RetryPolicy retryPolicy(Map<String, ?> map, int i) {
            int intValue = ((Integer) Preconditions.checkNotNull(ServiceConfigUtil.f(map), "maxAttempts cannot be empty")).intValue();
            Preconditions.checkArgument(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i);
            long longValue = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.d(map), "initialBackoff cannot be empty")).longValue();
            Preconditions.checkArgument(longValue > 0, "initialBackoffNanos must be greater than 0: %s", longValue);
            long longValue2 = ((Long) Preconditions.checkNotNull(ServiceConfigUtil.g(map), "maxBackoff cannot be empty")).longValue();
            Preconditions.checkArgument(longValue2 > 0, "maxBackoff must be greater than 0: %s", longValue2);
            double doubleValue = ((Double) Preconditions.checkNotNull(ServiceConfigUtil.a(map), "backoffMultiplier cannot be empty")).doubleValue();
            Preconditions.checkArgument(doubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", Double.valueOf(doubleValue));
            List<String> o = ServiceConfigUtil.o(map);
            Preconditions.checkNotNull(o, "rawCodes must be present");
            Preconditions.checkArgument(!o.isEmpty(), "rawCodes can't be empty");
            EnumSet noneOf = EnumSet.noneOf(Status.Code.class);
            for (String str : o) {
                Verify.verify(!"OK".equals(str), "rawCode can not be \"OK\"", new Object[0]);
                noneOf.add(Status.Code.valueOf(str));
            }
            return new RetryPolicy(min, longValue, longValue2, doubleValue, Collections.unmodifiableSet(noneOf));
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MethodInfo)) {
                return false;
            }
            MethodInfo methodInfo = (MethodInfo) obj;
            return Objects.equal(this.a, methodInfo.a) && Objects.equal(this.b, methodInfo.b) && Objects.equal(this.c, methodInfo.c) && Objects.equal(this.d, methodInfo.d) && Objects.equal(this.e, methodInfo.e) && Objects.equal(this.f, methodInfo.f);
        }

        public int hashCode() {
            return Objects.hashCode(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("timeoutNanos", this.a).add("waitForReady", this.b).add("maxInboundMessageSize", this.c).add("maxOutboundMessageSize", this.d).add("retryPolicy", this.e).add("hedgingPolicy", this.f).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagedChannelServiceConfig(Map<String, MethodInfo> map, Map<String, MethodInfo> map2, @Nullable RetriableStream.Throttle throttle, @Nullable Object obj) {
        this.serviceMethodMap = Collections.unmodifiableMap(new HashMap(map));
        this.serviceMap = Collections.unmodifiableMap(new HashMap(map2));
        this.retryThrottling = throttle;
        this.loadBalancingConfig = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ManagedChannelServiceConfig a(Map<String, ?> map, boolean z, int i, int i2, @Nullable Object obj) {
        RetriableStream.Throttle q = z ? ServiceConfigUtil.q(map) : null;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        List<Map<String, ?>> j = ServiceConfigUtil.j(map);
        if (j == null) {
            return new ManagedChannelServiceConfig(hashMap, hashMap2, q, obj);
        }
        for (Map<String, ?> map2 : j) {
            MethodInfo methodInfo = new MethodInfo(map2, z, i, i2);
            List<Map<String, ?>> l = ServiceConfigUtil.l(map2);
            Preconditions.checkArgument((l == null || l.isEmpty()) ? false : true, "no names in method config %s", map2);
            for (Map<String, ?> map3 : l) {
                String p = ServiceConfigUtil.p(map3);
                Preconditions.checkArgument(!Strings.isNullOrEmpty(p), "missing service name");
                String k = ServiceConfigUtil.k(map3);
                if (Strings.isNullOrEmpty(k)) {
                    Preconditions.checkArgument(!hashMap2.containsKey(p), "Duplicate service %s", p);
                    hashMap2.put(p, methodInfo);
                } else {
                    String generateFullMethodName = MethodDescriptor.generateFullMethodName(p, k);
                    Preconditions.checkArgument(!hashMap.containsKey(generateFullMethodName), "Duplicate method name %s", generateFullMethodName);
                    hashMap.put(generateFullMethodName, methodInfo);
                }
            }
        }
        return new ManagedChannelServiceConfig(hashMap, hashMap2, q, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, MethodInfo> a() {
        return this.serviceMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, MethodInfo> b() {
        return this.serviceMethodMap;
    }
}
