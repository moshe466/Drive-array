package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import io.grpc.internal.RetriableStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class ServiceConfigUtil {
    private static final long DURATION_SECONDS_MAX = 315576000000L;
    private static final long DURATION_SECONDS_MIN = -315576000000L;
    private static final String HEDGING_POLICY_HEDGING_DELAY_KEY = "hedgingDelay";
    private static final String HEDGING_POLICY_MAX_ATTEMPTS_KEY = "maxAttempts";
    private static final String HEDGING_POLICY_NON_FATAL_STATUS_CODES_KEY = "nonFatalStatusCodes";
    private static final String METHOD_CONFIG_HEDGING_POLICY_KEY = "hedgingPolicy";
    private static final String METHOD_CONFIG_MAX_REQUEST_MESSAGE_BYTES_KEY = "maxRequestMessageBytes";
    private static final String METHOD_CONFIG_MAX_RESPONSE_MESSAGE_BYTES_KEY = "maxResponseMessageBytes";
    private static final String METHOD_CONFIG_NAME_KEY = "name";
    private static final String METHOD_CONFIG_RETRY_POLICY_KEY = "retryPolicy";
    private static final String METHOD_CONFIG_TIMEOUT_KEY = "timeout";
    private static final String METHOD_CONFIG_WAIT_FOR_READY_KEY = "waitForReady";
    private static final String NAME_METHOD_KEY = "method";
    private static final String NAME_SERVICE_KEY = "service";
    private static final long NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);
    private static final String RETRY_POLICY_BACKOFF_MULTIPLIER_KEY = "backoffMultiplier";
    private static final String RETRY_POLICY_INITIAL_BACKOFF_KEY = "initialBackoff";
    private static final String RETRY_POLICY_MAX_ATTEMPTS_KEY = "maxAttempts";
    private static final String RETRY_POLICY_MAX_BACKOFF_KEY = "maxBackoff";
    private static final String RETRY_POLICY_RETRYABLE_STATUS_CODES_KEY = "retryableStatusCodes";
    private static final String SERVICE_CONFIG_LOAD_BALANCING_CONFIG_KEY = "loadBalancingConfig";
    private static final String SERVICE_CONFIG_LOAD_BALANCING_POLICY_KEY = "loadBalancingPolicy";
    private static final String SERVICE_CONFIG_METHOD_CONFIG_KEY = "methodConfig";
    private static final String SERVICE_CONFIG_STICKINESS_METADATA_KEY = "stickinessMetadataKey";
    private static final String XDS_CONFIG_BALANCER_NAME_KEY = "balancerName";
    private static final String XDS_CONFIG_CHILD_POLICY_KEY = "childPolicy";
    private static final String XDS_CONFIG_FALLBACK_POLICY_KEY = "fallbackPolicy";

    /* loaded from: classes2.dex */
    public static final class LbConfig {
        private final String policyName;
        private final Map<String, ?> rawConfigValue;

        public LbConfig(String str, Map<String, ?> map) {
            this.policyName = (String) Preconditions.checkNotNull(str, "policyName");
            this.rawConfigValue = (Map) Preconditions.checkNotNull(map, "rawConfigValue");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LbConfig)) {
                return false;
            }
            LbConfig lbConfig = (LbConfig) obj;
            return this.policyName.equals(lbConfig.policyName) && this.rawConfigValue.equals(lbConfig.rawConfigValue);
        }

        public String getPolicyName() {
            return this.policyName;
        }

        public Map<String, ?> getRawConfigValue() {
            return this.rawConfigValue;
        }

        public int hashCode() {
            return Objects.hashCode(this.policyName, this.rawConfigValue);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("policyName", this.policyName).add("rawConfigValue", this.rawConfigValue).toString();
        }
    }

    private ServiceConfigUtil() {
    }

    @Nullable
    static Boolean a(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, str, map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Double a(Map<String, ?> map) {
        if (map.containsKey(RETRY_POLICY_BACKOFF_MULTIPLIER_KEY)) {
            return b(map, RETRY_POLICY_BACKOFF_MULTIPLIER_KEY);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Map<String, ?>> a(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i) instanceof Map)) {
                throw new ClassCastException(String.format("value %s for idx %d in %s is not object", list.get(i), Integer.valueOf(i), list));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Double b(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Double", obj, str, map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long b(Map<String, ?> map) {
        if (!map.containsKey(HEDGING_POLICY_HEDGING_DELAY_KEY)) {
            return null;
        }
        try {
            return Long.valueOf(parseDuration(e(map, HEDGING_POLICY_HEDGING_DELAY_KEY)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> b(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i) instanceof String)) {
                throw new ClassCastException(String.format("value '%s' for idx %d in '%s' is not string", list.get(i), Integer.valueOf(i), list));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<?> c(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof List) {
            return (List) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, str, map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Map<String, ?> c(Map<String, ?> map) {
        if (map.containsKey(METHOD_CONFIG_HEDGING_POLICY_KEY)) {
            return d(map, METHOD_CONFIG_HEDGING_POLICY_KEY);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long d(Map<String, ?> map) {
        if (!map.containsKey(RETRY_POLICY_INITIAL_BACKOFF_KEY)) {
            return null;
        }
        try {
            return Long.valueOf(parseDuration(e(map, RETRY_POLICY_INITIAL_BACKOFF_KEY)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Map<String, ?> d(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, str, map));
    }

    private static boolean durationIsValid(long j, int i) {
        if (j >= DURATION_SECONDS_MIN && j <= DURATION_SECONDS_MAX) {
            long j2 = i;
            if (j2 >= -999999999 && j2 < NANOS_PER_SECOND) {
                if (j >= 0 && i >= 0) {
                    return true;
                }
                if (j <= 0 && i <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer e(Map<String, ?> map) {
        if (map.containsKey("maxAttempts")) {
            return Integer.valueOf(b(map, "maxAttempts").intValue());
        }
        return null;
    }

    @Nullable
    static String e(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, str, map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer f(Map<String, ?> map) {
        if (map.containsKey("maxAttempts")) {
            return Integer.valueOf(b(map, "maxAttempts").intValue());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long g(Map<String, ?> map) {
        if (!map.containsKey(RETRY_POLICY_MAX_BACKOFF_KEY)) {
            return null;
        }
        try {
            return Long.valueOf(parseDuration(e(map, RETRY_POLICY_MAX_BACKOFF_KEY)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBalancerNameFromXdsConfig(LbConfig lbConfig) {
        return e(lbConfig.getRawConfigValue(), XDS_CONFIG_BALANCER_NAME_KEY);
    }

    @Nullable
    public static List<LbConfig> getChildPolicyFromXdsConfig(LbConfig lbConfig) {
        List<?> c = c(lbConfig.getRawConfigValue(), XDS_CONFIG_CHILD_POLICY_KEY);
        if (c == null) {
            return null;
        }
        a(c);
        return unwrapLoadBalancingConfigList(c);
    }

    @Nullable
    public static List<LbConfig> getFallbackPolicyFromXdsConfig(LbConfig lbConfig) {
        List<?> c = c(lbConfig.getRawConfigValue(), XDS_CONFIG_FALLBACK_POLICY_KEY);
        if (c == null) {
            return null;
        }
        a(c);
        return unwrapLoadBalancingConfigList(c);
    }

    @Nullable
    public static String getHealthCheckedServiceName(@Nullable Map<String, ?> map) {
        if (map == null || !map.containsKey("healthCheckConfig")) {
            return null;
        }
        Map<String, ?> d = d(map, "healthCheckConfig");
        if (d.containsKey("serviceName")) {
            return e(d, "serviceName");
        }
        return null;
    }

    @VisibleForTesting
    public static List<Map<String, ?>> getLoadBalancingConfigsFromServiceConfig(Map<String, ?> map) {
        ArrayList arrayList = new ArrayList();
        if (map.containsKey(SERVICE_CONFIG_LOAD_BALANCING_CONFIG_KEY)) {
            List<?> c = c(map, SERVICE_CONFIG_LOAD_BALANCING_CONFIG_KEY);
            a(c);
            Iterator<?> it = c.iterator();
            while (it.hasNext()) {
                arrayList.add((Map) it.next());
            }
        }
        if (arrayList.isEmpty() && map.containsKey(SERVICE_CONFIG_LOAD_BALANCING_POLICY_KEY)) {
            arrayList.add(Collections.singletonMap(e(map, SERVICE_CONFIG_LOAD_BALANCING_POLICY_KEY).toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    public static String getStickinessMetadataKeyFromServiceConfig(Map<String, ?> map) {
        if (map.containsKey(SERVICE_CONFIG_STICKINESS_METADATA_KEY)) {
            return e(map, SERVICE_CONFIG_STICKINESS_METADATA_KEY);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer h(Map<String, ?> map) {
        if (map.containsKey(METHOD_CONFIG_MAX_REQUEST_MESSAGE_BYTES_KEY)) {
            return Integer.valueOf(b(map, METHOD_CONFIG_MAX_REQUEST_MESSAGE_BYTES_KEY).intValue());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer i(Map<String, ?> map) {
        if (map.containsKey(METHOD_CONFIG_MAX_RESPONSE_MESSAGE_BYTES_KEY)) {
            return Integer.valueOf(b(map, METHOD_CONFIG_MAX_RESPONSE_MESSAGE_BYTES_KEY).intValue());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<Map<String, ?>> j(Map<String, ?> map) {
        if (!map.containsKey(SERVICE_CONFIG_METHOD_CONFIG_KEY)) {
            return null;
        }
        List c = c(map, SERVICE_CONFIG_METHOD_CONFIG_KEY);
        a((List<?>) c);
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String k(Map<String, ?> map) {
        if (map.containsKey("method")) {
            return e(map, "method");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<Map<String, ?>> l(Map<String, ?> map) {
        if (!map.containsKey("name")) {
            return null;
        }
        List c = c(map, "name");
        a((List<?>) c);
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<String> m(Map<String, ?> map) {
        if (!map.containsKey(HEDGING_POLICY_NON_FATAL_STATUS_CODES_KEY)) {
            return null;
        }
        List c = c(map, HEDGING_POLICY_NON_FATAL_STATUS_CODES_KEY);
        b((List<?>) c);
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Map<String, ?> n(Map<String, ?> map) {
        if (map.containsKey(METHOD_CONFIG_RETRY_POLICY_KEY)) {
            return d(map, METHOD_CONFIG_RETRY_POLICY_KEY);
        }
        return null;
    }

    private static long normalizedDuration(long j, int i) {
        long j2 = i;
        long j3 = NANOS_PER_SECOND;
        if (j2 <= (-j3) || j2 >= j3) {
            j = LongMath.checkedAdd(j, j2 / NANOS_PER_SECOND);
            i = (int) (j2 % NANOS_PER_SECOND);
        }
        if (j > 0 && i < 0) {
            i = (int) (i + NANOS_PER_SECOND);
            j--;
        }
        if (j < 0 && i > 0) {
            i = (int) (i - NANOS_PER_SECOND);
            j++;
        }
        if (durationIsValid(j, i)) {
            return saturatedAdd(TimeUnit.SECONDS.toNanos(j), i);
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(j), Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<String> o(Map<String, ?> map) {
        if (!map.containsKey(RETRY_POLICY_RETRYABLE_STATUS_CODES_KEY)) {
            return null;
        }
        List c = c(map, RETRY_POLICY_RETRYABLE_STATUS_CODES_KEY);
        b((List<?>) c);
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String p(Map<String, ?> map) {
        if (map.containsKey("service")) {
            return e(map, "service");
        }
        return null;
    }

    private static long parseDuration(String str) {
        boolean z;
        String str2;
        if (str.isEmpty() || str.charAt(str.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z = true;
        } else {
            z = false;
        }
        String substring = str.substring(0, str.length() - 1);
        int indexOf = substring.indexOf(46);
        if (indexOf != -1) {
            str2 = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            str2 = "";
        }
        long parseLong = Long.parseLong(substring);
        int parseNanos = str2.isEmpty() ? 0 : parseNanos(str2);
        if (parseLong < 0) {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (z) {
            parseLong = -parseLong;
            parseNanos = -parseNanos;
        }
        try {
            return normalizedDuration(parseLong, parseNanos);
        } catch (IllegalArgumentException unused) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }

    private static int parseNanos(String str) {
        int i = 0;
        for (int i2 = 0; i2 < 9; i2++) {
            i *= 10;
            if (i2 < str.length()) {
                if (str.charAt(i2) < '0' || str.charAt(i2) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                i += str.charAt(i2) - '0';
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static RetriableStream.Throttle q(@Nullable Map<String, ?> map) {
        if (map == null || !map.containsKey("retryThrottling")) {
            return null;
        }
        Map<String, ?> d = d(map, "retryThrottling");
        float floatValue = b(d, "maxTokens").floatValue();
        float floatValue2 = b(d, "tokenRatio").floatValue();
        Preconditions.checkState(floatValue > 0.0f, "maxToken should be greater than zero");
        Preconditions.checkState(floatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new RetriableStream.Throttle(floatValue, floatValue2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long r(Map<String, ?> map) {
        if (!map.containsKey(METHOD_CONFIG_TIMEOUT_KEY)) {
            return null;
        }
        try {
            return Long.valueOf(parseDuration(e(map, METHOD_CONFIG_TIMEOUT_KEY)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Boolean s(Map<String, ?> map) {
        if (map.containsKey(METHOD_CONFIG_WAIT_FOR_READY_KEY)) {
            return a(map, METHOD_CONFIG_WAIT_FOR_READY_KEY);
        }
        return null;
    }

    private static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) < 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static LbConfig unwrapLoadBalancingConfig(Map<String, ?> map) {
        if (map.size() == 1) {
            String key = map.entrySet().iterator().next().getKey();
            return new LbConfig(key, d(map, key));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }

    public static List<LbConfig> unwrapLoadBalancingConfigList(List<Map<String, ?>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, ?>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(unwrapLoadBalancingConfig(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
