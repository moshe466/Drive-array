package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class CacheBuilderSpec {
    private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
    private static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
    private static final ImmutableMap<String, ValueParser> VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser()).put("weakKeys", new KeyStrengthParser(LocalCache.Strength.WEAK)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(LocalCache.Strength.WEAK)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).build();

    @VisibleForTesting
    @MonotonicNonNullDecl
    Integer a;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Long b;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Long c;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Integer d;

    @VisibleForTesting
    @MonotonicNonNullDecl
    LocalCache.Strength e;

    @VisibleForTesting
    @MonotonicNonNullDecl
    LocalCache.Strength f;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Boolean g;

    @VisibleForTesting
    long h;

    @VisibleForTesting
    @MonotonicNonNullDecl
    TimeUnit i;

    @VisibleForTesting
    long j;

    @VisibleForTesting
    @MonotonicNonNullDecl
    TimeUnit k;

    @VisibleForTesting
    long l;

    @VisibleForTesting
    @MonotonicNonNullDecl
    TimeUnit m;
    private final String specification;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.cache.CacheBuilderSpec$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[LocalCache.Strength.values().length];

        static {
            try {
                a[LocalCache.Strength.WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LocalCache.Strength.SOFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    static class AccessDurationParser extends DurationParser {
        AccessDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void a(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.k == null, "expireAfterAccess already set");
            cacheBuilderSpec.j = j;
            cacheBuilderSpec.k = timeUnit;
        }
    }

    /* loaded from: classes2.dex */
    static class ConcurrencyLevelParser extends IntegerParser {
        ConcurrencyLevelParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        protected void a(CacheBuilderSpec cacheBuilderSpec, int i) {
            Preconditions.checkArgument(cacheBuilderSpec.d == null, "concurrency level was already set to ", cacheBuilderSpec.d);
            cacheBuilderSpec.d = Integer.valueOf(i);
        }
    }

    /* loaded from: classes2.dex */
    static abstract class DurationParser implements ValueParser {
        DurationParser() {
        }

        protected abstract void a(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit);

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            TimeUnit timeUnit;
            Preconditions.checkArgument((str2 == null || str2.isEmpty()) ? false : true, "value of key %s omitted", str);
            try {
                char charAt = str2.charAt(str2.length() - 1);
                if (charAt == 'd') {
                    timeUnit = TimeUnit.DAYS;
                } else if (charAt == 'h') {
                    timeUnit = TimeUnit.HOURS;
                } else if (charAt == 'm') {
                    timeUnit = TimeUnit.MINUTES;
                } else {
                    if (charAt != 's') {
                        throw new IllegalArgumentException(CacheBuilderSpec.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", str, str2));
                    }
                    timeUnit = TimeUnit.SECONDS;
                }
                a(cacheBuilderSpec, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2));
            }
        }
    }

    /* loaded from: classes2.dex */
    static class InitialCapacityParser extends IntegerParser {
        InitialCapacityParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        protected void a(CacheBuilderSpec cacheBuilderSpec, int i) {
            Preconditions.checkArgument(cacheBuilderSpec.a == null, "initial capacity was already set to ", cacheBuilderSpec.a);
            cacheBuilderSpec.a = Integer.valueOf(i);
        }
    }

    /* loaded from: classes2.dex */
    static abstract class IntegerParser implements ValueParser {
        IntegerParser() {
        }

        protected abstract void a(CacheBuilderSpec cacheBuilderSpec, int i);

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            Preconditions.checkArgument((str2 == null || str2.isEmpty()) ? false : true, "value of key %s omitted", str);
            try {
                a(cacheBuilderSpec, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2), e);
            }
        }
    }

    /* loaded from: classes2.dex */
    static class KeyStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public KeyStrengthParser(LocalCache.Strength strength) {
            this.strength = strength;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2) {
            Preconditions.checkArgument(str2 == null, "key %s does not take values", str);
            Preconditions.checkArgument(cacheBuilderSpec.e == null, "%s was already set to %s", str, cacheBuilderSpec.e);
            cacheBuilderSpec.e = this.strength;
        }
    }

    /* loaded from: classes2.dex */
    static abstract class LongParser implements ValueParser {
        LongParser() {
        }

        protected abstract void a(CacheBuilderSpec cacheBuilderSpec, long j);

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            Preconditions.checkArgument((str2 == null || str2.isEmpty()) ? false : true, "value of key %s omitted", str);
            try {
                a(cacheBuilderSpec, Long.parseLong(str2));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2), e);
            }
        }
    }

    /* loaded from: classes2.dex */
    static class MaximumSizeParser extends LongParser {
        MaximumSizeParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        protected void a(CacheBuilderSpec cacheBuilderSpec, long j) {
            Preconditions.checkArgument(cacheBuilderSpec.b == null, "maximum size was already set to ", cacheBuilderSpec.b);
            Preconditions.checkArgument(cacheBuilderSpec.c == null, "maximum weight was already set to ", cacheBuilderSpec.c);
            cacheBuilderSpec.b = Long.valueOf(j);
        }
    }

    /* loaded from: classes2.dex */
    static class MaximumWeightParser extends LongParser {
        MaximumWeightParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        protected void a(CacheBuilderSpec cacheBuilderSpec, long j) {
            Preconditions.checkArgument(cacheBuilderSpec.c == null, "maximum weight was already set to ", cacheBuilderSpec.c);
            Preconditions.checkArgument(cacheBuilderSpec.b == null, "maximum size was already set to ", cacheBuilderSpec.b);
            cacheBuilderSpec.c = Long.valueOf(j);
        }
    }

    /* loaded from: classes2.dex */
    static class RecordStatsParser implements ValueParser {
        RecordStatsParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2) {
            Preconditions.checkArgument(str2 == null, "recordStats does not take values");
            Preconditions.checkArgument(cacheBuilderSpec.g == null, "recordStats already set");
            cacheBuilderSpec.g = true;
        }
    }

    /* loaded from: classes2.dex */
    static class RefreshDurationParser extends DurationParser {
        RefreshDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void a(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.m == null, "refreshAfterWrite already set");
            cacheBuilderSpec.l = j;
            cacheBuilderSpec.m = timeUnit;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface ValueParser {
        void parse(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2);
    }

    /* loaded from: classes2.dex */
    static class ValueStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public ValueStrengthParser(LocalCache.Strength strength) {
            this.strength = strength;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @NullableDecl String str2) {
            Preconditions.checkArgument(str2 == null, "key %s does not take values", str);
            Preconditions.checkArgument(cacheBuilderSpec.f == null, "%s was already set to %s", str, cacheBuilderSpec.f);
            cacheBuilderSpec.f = this.strength;
        }
    }

    /* loaded from: classes2.dex */
    static class WriteDurationParser extends DurationParser {
        WriteDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void a(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.i == null, "expireAfterWrite already set");
            cacheBuilderSpec.h = j;
            cacheBuilderSpec.i = timeUnit;
        }
    }

    private CacheBuilderSpec(String str) {
        this.specification = str;
    }

    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    @NullableDecl
    private static Long durationInNanos(long j, @NullableDecl TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String format(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CacheBuilderSpec parse(String str) {
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(str);
        if (!str.isEmpty()) {
            for (String str2 : KEYS_SPLITTER.split(str)) {
                ImmutableList copyOf = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(str2));
                Preconditions.checkArgument(!copyOf.isEmpty(), "blank key-value pair");
                Preconditions.checkArgument(copyOf.size() <= 2, "key-value pair %s with more than one equals sign", str2);
                String str3 = (String) copyOf.get(0);
                ValueParser valueParser = VALUE_PARSERS.get(str3);
                Preconditions.checkArgument(valueParser != null, "unknown key %s", str3);
                valueParser.parse(cacheBuilderSpec, str3, copyOf.size() == 1 ? null : (String) copyOf.get(1));
            }
        }
        return cacheBuilderSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<Object, Object> a() {
        CacheBuilder<Object, Object> newBuilder = CacheBuilder.newBuilder();
        Integer num = this.a;
        if (num != null) {
            newBuilder.initialCapacity(num.intValue());
        }
        Long l = this.b;
        if (l != null) {
            newBuilder.maximumSize(l.longValue());
        }
        Long l2 = this.c;
        if (l2 != null) {
            newBuilder.maximumWeight(l2.longValue());
        }
        Integer num2 = this.d;
        if (num2 != null) {
            newBuilder.concurrencyLevel(num2.intValue());
        }
        LocalCache.Strength strength = this.e;
        if (strength != null) {
            if (AnonymousClass1.a[strength.ordinal()] != 1) {
                throw new AssertionError();
            }
            newBuilder.weakKeys();
        }
        LocalCache.Strength strength2 = this.f;
        if (strength2 != null) {
            int i = AnonymousClass1.a[strength2.ordinal()];
            if (i == 1) {
                newBuilder.weakValues();
            } else {
                if (i != 2) {
                    throw new AssertionError();
                }
                newBuilder.softValues();
            }
        }
        Boolean bool = this.g;
        if (bool != null && bool.booleanValue()) {
            newBuilder.recordStats();
        }
        TimeUnit timeUnit = this.i;
        if (timeUnit != null) {
            newBuilder.expireAfterWrite(this.h, timeUnit);
        }
        TimeUnit timeUnit2 = this.k;
        if (timeUnit2 != null) {
            newBuilder.expireAfterAccess(this.j, timeUnit2);
        }
        TimeUnit timeUnit3 = this.m;
        if (timeUnit3 != null) {
            newBuilder.refreshAfterWrite(this.l, timeUnit3);
        }
        return newBuilder;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        return Objects.equal(this.a, cacheBuilderSpec.a) && Objects.equal(this.b, cacheBuilderSpec.b) && Objects.equal(this.c, cacheBuilderSpec.c) && Objects.equal(this.d, cacheBuilderSpec.d) && Objects.equal(this.e, cacheBuilderSpec.e) && Objects.equal(this.f, cacheBuilderSpec.f) && Objects.equal(this.g, cacheBuilderSpec.g) && Objects.equal(durationInNanos(this.h, this.i), durationInNanos(cacheBuilderSpec.h, cacheBuilderSpec.i)) && Objects.equal(durationInNanos(this.j, this.k), durationInNanos(cacheBuilderSpec.j, cacheBuilderSpec.k)) && Objects.equal(durationInNanos(this.l, this.m), durationInNanos(cacheBuilderSpec.l, cacheBuilderSpec.m));
    }

    public int hashCode() {
        return Objects.hashCode(this.a, this.b, this.c, this.d, this.e, this.f, this.g, durationInNanos(this.h, this.i), durationInNanos(this.j, this.k), durationInNanos(this.l, this.m));
    }

    public String toParsableString() {
        return this.specification;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
    }
}
