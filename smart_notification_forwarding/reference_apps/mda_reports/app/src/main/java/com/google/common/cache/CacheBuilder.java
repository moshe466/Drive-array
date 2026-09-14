package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class CacheBuilder<K, V> {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;

    @MonotonicNonNullDecl
    Weigher<? super K, ? super V> f;

    @MonotonicNonNullDecl
    LocalCache.Strength g;

    @MonotonicNonNullDecl
    LocalCache.Strength h;

    @MonotonicNonNullDecl
    Equivalence<Object> l;

    @MonotonicNonNullDecl
    Equivalence<Object> m;

    @MonotonicNonNullDecl
    RemovalListener<? super K, ? super V> n;

    @MonotonicNonNullDecl
    Ticker o;
    static final Supplier<? extends AbstractCache.StatsCounter> q = Suppliers.ofInstance(new AbstractCache.StatsCounter() { // from class: com.google.common.cache.CacheBuilder.1
        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return CacheBuilder.r;
        }
    });
    static final CacheStats r = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<AbstractCache.StatsCounter> s = new Supplier<AbstractCache.StatsCounter>() { // from class: com.google.common.cache.CacheBuilder.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.Supplier
        public AbstractCache.StatsCounter get() {
            return new AbstractCache.SimpleStatsCounter();
        }
    };
    static final Ticker t = new Ticker() { // from class: com.google.common.cache.CacheBuilder.3
        @Override // com.google.common.base.Ticker
        public long read() {
            return 0L;
        }
    };
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    boolean a = true;
    int b = -1;
    int c = -1;
    long d = -1;
    long e = -1;
    long i = -1;
    long j = -1;
    long k = -1;
    Supplier<? extends AbstractCache.StatsCounter> p = q;

    /* loaded from: classes2.dex */
    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    /* loaded from: classes2.dex */
    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    private void checkNonLoadingCache() {
        Preconditions.checkState(this.k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        boolean z;
        String str;
        if (this.f == null) {
            z = this.e == -1;
            str = "maximumWeight requires weigher";
        } else {
            if (!this.a) {
                if (this.e == -1) {
                    logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
                    return;
                }
                return;
            }
            z = this.e != -1;
            str = "weigher requires maximumWeight";
        }
        Preconditions.checkState(z, str);
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.a().n();
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i = this.c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ticker a(boolean z) {
        Ticker ticker = this.o;
        return ticker != null ? ticker : z ? Ticker.systemTicker() : t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public CacheBuilder<K, V> a(Equivalence<Object> equivalence) {
        Preconditions.checkState(this.l == null, "key equivalence was already set to %s", this.l);
        this.l = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> a(LocalCache.Strength strength) {
        Preconditions.checkState(this.g == null, "Key strength was already set to %s", this.g);
        this.g = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b() {
        long j = this.j;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public CacheBuilder<K, V> b(Equivalence<Object> equivalence) {
        Preconditions.checkState(this.m == null, "value equivalence was already set to %s", this.m);
        this.m = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> b(LocalCache.Strength strength) {
        Preconditions.checkState(this.h == null, "Value strength was already set to %s", this.h);
        this.h = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        long j = this.i;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public CacheBuilder<K, V> concurrencyLevel(int i) {
        Preconditions.checkState(this.c == -1, "concurrency level was already set to %s", this.c);
        Preconditions.checkArgument(i > 0);
        this.c = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        int i = this.b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> e() {
        return (Equivalence) MoreObjects.firstNonNull(this.l, f().a());
    }

    public CacheBuilder<K, V> expireAfterAccess(long j, TimeUnit timeUnit) {
        Preconditions.checkState(this.j == -1, "expireAfterAccess was already set to %s ns", this.j);
        Preconditions.checkArgument(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.j = timeUnit.toNanos(j);
        return this;
    }

    public CacheBuilder<K, V> expireAfterWrite(long j, TimeUnit timeUnit) {
        Preconditions.checkState(this.i == -1, "expireAfterWrite was already set to %s ns", this.i);
        Preconditions.checkArgument(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.i = timeUnit.toNanos(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength f() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.g, LocalCache.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long g() {
        if (this.i == 0 || this.j == 0) {
            return 0L;
        }
        return this.f == null ? this.d : this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h() {
        long j = this.k;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> i() {
        return (RemovalListener) MoreObjects.firstNonNull(this.n, NullListener.INSTANCE);
    }

    public CacheBuilder<K, V> initialCapacity(int i) {
        Preconditions.checkState(this.b == -1, "initial capacity was already set to %s", this.b);
        Preconditions.checkArgument(i >= 0);
        this.b = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Supplier<? extends AbstractCache.StatsCounter> j() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> k() {
        return (Equivalence) MoreObjects.firstNonNull(this.m, l().a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength l() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.h, LocalCache.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> Weigher<K1, V1> m() {
        return (Weigher) MoreObjects.firstNonNull(this.f, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> maximumSize(long j) {
        Preconditions.checkState(this.d == -1, "maximum size was already set to %s", this.d);
        Preconditions.checkState(this.e == -1, "maximum weight was already set to %s", this.e);
        Preconditions.checkState(this.f == null, "maximum size can not be combined with weigher");
        Preconditions.checkArgument(j >= 0, "maximum size must not be negative");
        this.d = j;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> maximumWeight(long j) {
        Preconditions.checkState(this.e == -1, "maximum weight was already set to %s", this.e);
        Preconditions.checkState(this.d == -1, "maximum size was already set to %s", this.d);
        this.e = j;
        Preconditions.checkArgument(j >= 0, "maximum weight must not be negative");
        return this;
    }

    @GwtIncompatible
    CacheBuilder<K, V> n() {
        this.a = false;
        return this;
    }

    public CacheBuilder<K, V> recordStats() {
        this.p = s;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> refreshAfterWrite(long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        Preconditions.checkState(this.k == -1, "refresh was already set to %s ns", this.k);
        Preconditions.checkArgument(j > 0, "duration must be positive: %s %s", j, timeUnit);
        this.k = timeUnit.toNanos(j);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener) {
        Preconditions.checkState(this.n == null);
        this.n = (RemovalListener) Preconditions.checkNotNull(removalListener);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> softValues() {
        return b(LocalCache.Strength.SOFT);
    }

    public CacheBuilder<K, V> ticker(Ticker ticker) {
        Preconditions.checkState(this.o == null);
        this.o = (Ticker) Preconditions.checkNotNull(ticker);
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i = this.b;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        long j = this.d;
        if (j != -1) {
            stringHelper.add("maximumSize", j);
        }
        long j2 = this.e;
        if (j2 != -1) {
            stringHelper.add("maximumWeight", j2);
        }
        if (this.i != -1) {
            stringHelper.add("expireAfterWrite", this.i + "ns");
        }
        if (this.j != -1) {
            stringHelper.add("expireAfterAccess", this.j + "ns");
        }
        LocalCache.Strength strength = this.g;
        if (strength != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(strength.toString()));
        }
        LocalCache.Strength strength2 = this.h;
        if (strength2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(strength2.toString()));
        }
        if (this.l != null) {
            stringHelper.addValue("keyEquivalence");
        }
        if (this.m != null) {
            stringHelper.addValue("valueEquivalence");
        }
        if (this.n != null) {
            stringHelper.addValue("removalListener");
        }
        return stringHelper.toString();
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakKeys() {
        return a(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakValues() {
        return b(LocalCache.Strength.WEAK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher) {
        Preconditions.checkState(this.f == null);
        if (this.a) {
            Preconditions.checkState(this.d == -1, "weigher can not be combined with maximum size", this.d);
        }
        this.f = (Weigher) Preconditions.checkNotNull(weigher);
        return this;
    }
}
