package ab;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import l8.w;
import mb.s;

/* loaded from: classes.dex */
public class f implements ab.n {

    /* renamed from: d, reason: collision with root package name */
    private static final String f358d;

    /* renamed from: e, reason: collision with root package name */
    public static final ab.n f359e;

    /* renamed from: a, reason: collision with root package name */
    protected final ab.k f360a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0012f f361b;

    /* renamed from: c, reason: collision with root package name */
    private final String f362c;

    /* loaded from: classes.dex */
    static class a extends f {
        a(String str, InterfaceC0012f interfaceC0012f, ab.k kVar) {
            super(str, interfaceC0012f, kVar, null);
        }

        private static /* synthetic */ void j(int i10) {
            String str = i10 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 1 ? 3 : 2];
            if (i10 != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i10 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i10 != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String format = String.format(str, objArr);
            if (i10 == 1) {
                throw new IllegalStateException(format);
            }
        }

        @Override // ab.f
        protected <K, V> o<V> p(String str, K k10) {
            if (str == null) {
                j(0);
            }
            o<V> a10 = o.a();
            if (a10 == null) {
                j(1);
            }
            return a10;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    class b<T> extends j<T> {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Object f363i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(f fVar, f fVar2, x8.a aVar, Object obj) {
            super(fVar2, aVar);
            this.f363i = obj;
        }

        private static /* synthetic */ void a(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }

        @Override // ab.f.h
        protected o<T> d(boolean z10) {
            o<T> d10 = o.d(this.f363i);
            if (d10 == null) {
                a(0);
            }
            return d10;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    class c<T> extends k<T> {

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ x8.l f364j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ x8.l f365k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(f fVar, f fVar2, x8.a aVar, x8.l lVar, x8.l lVar2) {
            super(fVar2, aVar);
            this.f364j = lVar;
            this.f365k = lVar2;
        }

        private static /* synthetic */ void a(int i10) {
            String str = i10 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i10 != 2 ? 2 : 3];
            if (i10 != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i10 != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i10 == 2) {
                objArr[2] = "doPostCompute";
            }
            String format = String.format(str, objArr);
            if (i10 == 2) {
                throw new IllegalArgumentException(format);
            }
        }

        @Override // ab.f.h
        protected o<T> d(boolean z10) {
            x8.l lVar = this.f364j;
            if (lVar == null) {
                o<T> d10 = super.d(z10);
                if (d10 == null) {
                    a(0);
                }
                return d10;
            }
            o<T> d11 = o.d(lVar.h(Boolean.valueOf(z10)));
            if (d11 == null) {
                a(1);
            }
            return d11;
        }

        @Override // ab.f.i
        protected void i(T t10) {
            if (t10 == null) {
                a(2);
            }
            this.f365k.h(t10);
        }
    }

    /* loaded from: classes.dex */
    private static class d<K, V> extends e<K, V> implements ab.a<K, V> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private d(f fVar, ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, null);
            if (fVar == null) {
                c(0);
            }
            if (concurrentMap == null) {
                c(1);
            }
        }

        /* synthetic */ d(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void c(int i10) {
            String str = i10 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 3 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 == 2) {
                objArr[0] = "computation";
            } else if (i10 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i10 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i10 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i10 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i10 == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // ab.f.e, ab.a
        public V a(K k10, x8.a<? extends V> aVar) {
            if (aVar == null) {
                c(2);
            }
            V v10 = (V) super.a(k10, aVar);
            if (v10 == null) {
                c(3);
            }
            return v10;
        }
    }

    /* loaded from: classes.dex */
    private static class e<K, V> extends l<g<K, V>, V> implements ab.b<K, V> {

        /* loaded from: classes.dex */
        class a implements x8.l<g<K, V>, V> {
            a() {
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public V h(g<K, V> gVar) {
                return (V) ((g) gVar).f368b.b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private e(f fVar, ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, new a());
            if (fVar == null) {
                c(0);
            }
            if (concurrentMap == null) {
                c(1);
            }
        }

        /* synthetic */ e(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void c(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i10 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public V a(K k10, x8.a<? extends V> aVar) {
            if (aVar == null) {
                c(2);
            }
            return h(new g(k10, aVar));
        }
    }

    /* renamed from: ab.f$f, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0012f {

        /* renamed from: a, reason: collision with root package name */
        public static final InterfaceC0012f f366a = new a();

        /* renamed from: ab.f$f$a */
        /* loaded from: classes.dex */
        static class a implements InterfaceC0012f {
            a() {
            }

            private static /* synthetic */ void b(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // ab.f.InterfaceC0012f
            public RuntimeException a(Throwable th) {
                if (th == null) {
                    b(0);
                }
                throw jb.c.b(th);
            }
        }

        RuntimeException a(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final K f367a;

        /* renamed from: b, reason: collision with root package name */
        private final x8.a<? extends V> f368b;

        public g(K k10, x8.a<? extends V> aVar) {
            this.f367a = k10;
            this.f368b = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && g.class == obj.getClass() && this.f367a.equals(((g) obj).f367a);
        }

        public int hashCode() {
            return this.f367a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h<T> implements ab.j<T> {

        /* renamed from: f, reason: collision with root package name */
        private final f f369f;

        /* renamed from: g, reason: collision with root package name */
        private final x8.a<? extends T> f370g;

        /* renamed from: h, reason: collision with root package name */
        private volatile Object f371h;

        public h(f fVar, x8.a<? extends T> aVar) {
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
            this.f371h = n.NOT_COMPUTED;
            this.f369f = fVar;
            this.f370g = aVar;
        }

        private static /* synthetic */ void a(int i10) {
            String str = (i10 == 2 || i10 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 2 || i10 == 3) ? 2 : 3];
            if (i10 == 1) {
                objArr[0] = "computable";
            } else if (i10 == 2 || i10 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i10 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i10 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i10 != 2 && i10 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i10 != 2 && i10 != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // x8.a
        public T b() {
            T b10;
            Object obj = this.f371h;
            if (!(obj instanceof n)) {
                return (T) jb.k.f(obj);
            }
            this.f369f.f360a.b();
            try {
                Object obj2 = this.f371h;
                if (obj2 instanceof n) {
                    n nVar = n.COMPUTING;
                    if (obj2 == nVar) {
                        this.f371h = n.RECURSION_WAS_DETECTED;
                        o<T> d10 = d(true);
                        if (!d10.c()) {
                            b10 = d10.b();
                        }
                    }
                    if (obj2 == n.RECURSION_WAS_DETECTED) {
                        o<T> d11 = d(false);
                        if (!d11.c()) {
                            b10 = d11.b();
                        }
                    }
                    this.f371h = nVar;
                    try {
                        b10 = this.f370g.b();
                        c(b10);
                        this.f371h = b10;
                    } catch (Throwable th) {
                        if (jb.c.a(th)) {
                            this.f371h = n.NOT_COMPUTED;
                            throw th;
                        }
                        if (this.f371h == n.COMPUTING) {
                            this.f371h = jb.k.c(th);
                        }
                        throw this.f369f.f361b.a(th);
                    }
                } else {
                    b10 = (T) jb.k.f(obj2);
                }
                return b10;
            } finally {
                this.f369f.f360a.a();
            }
        }

        protected void c(T t10) {
        }

        protected o<T> d(boolean z10) {
            o<T> p10 = this.f369f.p("in a lazy value", null);
            if (p10 == null) {
                a(2);
            }
            return p10;
        }

        public boolean e() {
            return (this.f371h == n.NOT_COMPUTED || this.f371h == n.COMPUTING) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class i<T> extends h<T> {

        /* renamed from: i, reason: collision with root package name */
        private volatile ab.l<T> f372i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(f fVar, x8.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
            this.f372i = null;
        }

        private static /* synthetic */ void a(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ab.f.h, x8.a
        public T b() {
            ab.l<T> lVar = this.f372i;
            return (lVar == null || !lVar.b()) ? (T) super.b() : lVar.a();
        }

        @Override // ab.f.h
        protected final void c(T t10) {
            this.f372i = new ab.l<>(t10);
            try {
                i(t10);
            } finally {
                this.f372i = null;
            }
        }

        protected abstract void i(T t10);
    }

    /* loaded from: classes.dex */
    private static class j<T> extends h<T> implements ab.i<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(f fVar, x8.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i10) {
            String str = i10 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 2 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "computable";
            } else if (i10 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i10 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i10 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i10 == 2) {
                throw new IllegalStateException(format);
            }
        }

        @Override // ab.f.h, x8.a
        public T b() {
            T t10 = (T) super.b();
            if (t10 == null) {
                a(2);
            }
            return t10;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class k<T> extends i<T> implements ab.i<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(f fVar, x8.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i10) {
            String str = i10 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 2 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "computable";
            } else if (i10 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i10 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i10 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i10 == 2) {
                throw new IllegalStateException(format);
            }
        }

        @Override // ab.f.i, ab.f.h, x8.a
        public T b() {
            T t10 = (T) super.b();
            if (t10 == null) {
                a(2);
            }
            return t10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l<K, V> implements ab.h<K, V> {

        /* renamed from: f, reason: collision with root package name */
        private final f f373f;

        /* renamed from: g, reason: collision with root package name */
        private final ConcurrentMap<K, Object> f374g;

        /* renamed from: h, reason: collision with root package name */
        private final x8.l<? super K, ? extends V> f375h;

        public l(f fVar, ConcurrentMap<K, Object> concurrentMap, x8.l<? super K, ? extends V> lVar) {
            if (fVar == null) {
                c(0);
            }
            if (concurrentMap == null) {
                c(1);
            }
            if (lVar == null) {
                c(2);
            }
            this.f373f = fVar;
            this.f374g = concurrentMap;
            this.f375h = lVar;
        }

        private static /* synthetic */ void c(int i10) {
            String str = (i10 == 3 || i10 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 3 || i10 == 4) ? 2 : 3];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 == 2) {
                objArr[0] = "compute";
            } else if (i10 == 3 || i10 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i10 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i10 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i10 != 3 && i10 != 4) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i10 != 3 && i10 != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        private AssertionError d(K k10, Object obj) {
            AssertionError assertionError = (AssertionError) f.q(new AssertionError("Race condition detected on input " + k10 + ". Old value is " + obj + " under " + this.f373f));
            if (assertionError == null) {
                c(4);
            }
            return assertionError;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        
            if (r2.c() == false) goto L13;
         */
        @Override // x8.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public V h(K r6) {
            /*
                r5 = this;
                java.util.concurrent.ConcurrentMap<K, java.lang.Object> r0 = r5.f374g
                java.lang.Object r0 = r0.get(r6)
                if (r0 == 0) goto L11
                ab.f$n r1 = ab.f.n.COMPUTING
                if (r0 == r1) goto L11
                java.lang.Object r6 = jb.k.d(r0)
                return r6
            L11:
                ab.f r0 = r5.f373f
                ab.k r0 = r0.f360a
                r0.b()
                java.util.concurrent.ConcurrentMap<K, java.lang.Object> r0 = r5.f374g     // Catch: java.lang.Throwable -> Lb1
                java.lang.Object r0 = r0.get(r6)     // Catch: java.lang.Throwable -> Lb1
                ab.f$n r1 = ab.f.n.COMPUTING     // Catch: java.lang.Throwable -> Lb1
                if (r0 != r1) goto L3b
                ab.f$n r0 = ab.f.n.RECURSION_WAS_DETECTED     // Catch: java.lang.Throwable -> Lb1
                r2 = 1
                ab.f$o r2 = r5.i(r6, r2)     // Catch: java.lang.Throwable -> Lb1
                boolean r3 = r2.c()     // Catch: java.lang.Throwable -> Lb1
                if (r3 != 0) goto L3b
            L2f:
                java.lang.Object r6 = r2.b()     // Catch: java.lang.Throwable -> Lb1
            L33:
                ab.f r0 = r5.f373f
                ab.k r0 = r0.f360a
                r0.a()
                return r6
            L3b:
                ab.f$n r2 = ab.f.n.RECURSION_WAS_DETECTED     // Catch: java.lang.Throwable -> Lb1
                if (r0 != r2) goto L4b
                r2 = 0
                ab.f$o r2 = r5.i(r6, r2)     // Catch: java.lang.Throwable -> Lb1
                boolean r3 = r2.c()     // Catch: java.lang.Throwable -> Lb1
                if (r3 != 0) goto L4b
                goto L2f
            L4b:
                if (r0 == 0) goto L52
                java.lang.Object r6 = jb.k.d(r0)     // Catch: java.lang.Throwable -> Lb1
                goto L33
            L52:
                r0 = 0
                java.util.concurrent.ConcurrentMap<K, java.lang.Object> r2 = r5.f374g     // Catch: java.lang.Throwable -> L77
                r2.put(r6, r1)     // Catch: java.lang.Throwable -> L77
                x8.l<? super K, ? extends V> r2 = r5.f375h     // Catch: java.lang.Throwable -> L77
                java.lang.Object r2 = r2.h(r6)     // Catch: java.lang.Throwable -> L77
                java.util.concurrent.ConcurrentMap<K, java.lang.Object> r3 = r5.f374g     // Catch: java.lang.Throwable -> L77
                java.lang.Object r4 = jb.k.b(r2)     // Catch: java.lang.Throwable -> L77
                java.lang.Object r3 = r3.put(r6, r4)     // Catch: java.lang.Throwable -> L77
                if (r3 != r1) goto L72
                ab.f r6 = r5.f373f
                ab.k r6 = r6.f360a
                r6.a()
                return r2
            L72:
                java.lang.AssertionError r0 = r5.d(r6, r3)     // Catch: java.lang.Throwable -> L77
                throw r0     // Catch: java.lang.Throwable -> L77
            L77:
                r1 = move-exception
                boolean r2 = jb.c.a(r1)     // Catch: java.lang.Throwable -> Lb1
                if (r2 != 0) goto La9
                if (r1 == r0) goto L9e
                java.util.concurrent.ConcurrentMap<K, java.lang.Object> r0 = r5.f374g     // Catch: java.lang.Throwable -> Lb1
                java.lang.Object r2 = jb.k.c(r1)     // Catch: java.lang.Throwable -> Lb1
                java.lang.Object r0 = r0.put(r6, r2)     // Catch: java.lang.Throwable -> Lb1
                ab.f$n r2 = ab.f.n.COMPUTING     // Catch: java.lang.Throwable -> Lb1
                if (r0 == r2) goto L93
                java.lang.AssertionError r6 = r5.d(r6, r0)     // Catch: java.lang.Throwable -> Lb1
                throw r6     // Catch: java.lang.Throwable -> Lb1
            L93:
                ab.f r6 = r5.f373f     // Catch: java.lang.Throwable -> Lb1
                ab.f$f r6 = ab.f.k(r6)     // Catch: java.lang.Throwable -> Lb1
                java.lang.RuntimeException r6 = r6.a(r1)     // Catch: java.lang.Throwable -> Lb1
                throw r6     // Catch: java.lang.Throwable -> Lb1
            L9e:
                ab.f r6 = r5.f373f     // Catch: java.lang.Throwable -> Lb1
                ab.f$f r6 = ab.f.k(r6)     // Catch: java.lang.Throwable -> Lb1
                java.lang.RuntimeException r6 = r6.a(r1)     // Catch: java.lang.Throwable -> Lb1
                throw r6     // Catch: java.lang.Throwable -> Lb1
            La9:
                java.util.concurrent.ConcurrentMap<K, java.lang.Object> r0 = r5.f374g     // Catch: java.lang.Throwable -> Lb1
                r0.remove(r6)     // Catch: java.lang.Throwable -> Lb1
                java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch: java.lang.Throwable -> Lb1
                throw r1     // Catch: java.lang.Throwable -> Lb1
            Lb1:
                r6 = move-exception
                ab.f r0 = r5.f373f
                ab.k r0 = r0.f360a
                r0.a()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ab.f.l.h(java.lang.Object):java.lang.Object");
        }

        protected o<V> i(K k10, boolean z10) {
            o<V> p10 = this.f373f.p("", k10);
            if (p10 == null) {
                c(3);
            }
            return p10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class m<K, V> extends l<K, V> implements ab.g<K, V> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(f fVar, ConcurrentMap<K, Object> concurrentMap, x8.l<? super K, ? extends V> lVar) {
            super(fVar, concurrentMap, lVar);
            if (fVar == null) {
                c(0);
            }
            if (concurrentMap == null) {
                c(1);
            }
            if (lVar == null) {
                c(2);
            }
        }

        private static /* synthetic */ void c(int i10) {
            String str = i10 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 3 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 == 2) {
                objArr[0] = "compute";
            } else if (i10 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i10 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i10 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i10 == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // ab.f.l, x8.l
        public V h(K k10) {
            V v10 = (V) super.h(k10);
            if (v10 == null) {
                c(3);
            }
            return v10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum n {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class o<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f376a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f377b;

        private o(T t10, boolean z10) {
            this.f376a = t10;
            this.f377b = z10;
        }

        public static <T> o<T> a() {
            return new o<>(null, true);
        }

        public static <T> o<T> d(T t10) {
            return new o<>(t10, false);
        }

        public T b() {
            return this.f376a;
        }

        public boolean c() {
            return this.f377b;
        }

        public String toString() {
            return c() ? "FALL_THROUGH" : String.valueOf(this.f376a);
        }
    }

    static {
        String i02;
        i02 = s.i0(f.class.getCanonicalName(), ".", "");
        f358d = i02;
        f359e = new a("NO_LOCKS", InterfaceC0012f.f366a, ab.e.f357b);
    }

    public f(String str) {
        this(str, (Runnable) null, (x8.l<InterruptedException, w>) null);
    }

    private f(String str, InterfaceC0012f interfaceC0012f, ab.k kVar) {
        if (str == null) {
            j(4);
        }
        if (interfaceC0012f == null) {
            j(5);
        }
        if (kVar == null) {
            j(6);
        }
        this.f360a = kVar;
        this.f361b = interfaceC0012f;
        this.f362c = str;
    }

    /* synthetic */ f(String str, InterfaceC0012f interfaceC0012f, ab.k kVar, a aVar) {
        this(str, interfaceC0012f, kVar);
    }

    public f(String str, Runnable runnable, x8.l<InterruptedException, w> lVar) {
        this(str, InterfaceC0012f.f366a, ab.k.f378a.a(runnable, lVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void j(int r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.f.j(int):void");
    }

    private static <K> ConcurrentMap<K, Object> m() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Throwable> T q(T t10) {
        if (t10 == null) {
            j(36);
        }
        StackTraceElement[] stackTrace = t10.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            if (!stackTrace[i11].getClassName().startsWith(f358d)) {
                i10 = i11;
                break;
            }
            i11++;
        }
        List subList = Arrays.asList(stackTrace).subList(i10, length);
        t10.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t10;
    }

    @Override // ab.n
    public <T> ab.i<T> a(x8.a<? extends T> aVar) {
        if (aVar == null) {
            j(23);
        }
        return new j(this, aVar);
    }

    @Override // ab.n
    public <K, V> ab.b<K, V> b() {
        return new e(this, m(), null);
    }

    @Override // ab.n
    public <K, V> ab.h<K, V> c(x8.l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            j(19);
        }
        ab.h<K, V> o10 = o(lVar, m());
        if (o10 == null) {
            j(20);
        }
        return o10;
    }

    @Override // ab.n
    public <T> T d(x8.a<? extends T> aVar) {
        if (aVar == null) {
            j(34);
        }
        this.f360a.b();
        try {
            return aVar.b();
        } finally {
        }
    }

    @Override // ab.n
    public <T> ab.i<T> e(x8.a<? extends T> aVar, T t10) {
        if (aVar == null) {
            j(26);
        }
        if (t10 == null) {
            j(27);
        }
        return new b(this, this, aVar, t10);
    }

    @Override // ab.n
    public <K, V> ab.a<K, V> f() {
        return new d(this, m(), null);
    }

    @Override // ab.n
    public <T> ab.i<T> g(x8.a<? extends T> aVar, x8.l<? super Boolean, ? extends T> lVar, x8.l<? super T, w> lVar2) {
        if (aVar == null) {
            j(28);
        }
        if (lVar2 == null) {
            j(29);
        }
        return new c(this, this, aVar, lVar, lVar2);
    }

    @Override // ab.n
    public <T> ab.j<T> h(x8.a<? extends T> aVar) {
        if (aVar == null) {
            j(30);
        }
        return new h(this, aVar);
    }

    @Override // ab.n
    public <K, V> ab.g<K, V> i(x8.l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            j(9);
        }
        ab.g<K, V> n10 = n(lVar, m());
        if (n10 == null) {
            j(10);
        }
        return n10;
    }

    public <K, V> ab.g<K, V> n(x8.l<? super K, ? extends V> lVar, ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            j(14);
        }
        if (concurrentMap == null) {
            j(15);
        }
        return new m(this, concurrentMap, lVar);
    }

    public <K, V> ab.h<K, V> o(x8.l<? super K, ? extends V> lVar, ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            j(21);
        }
        if (concurrentMap == null) {
            j(22);
        }
        return new l(this, concurrentMap, lVar);
    }

    protected <K, V> o<V> p(String str, K k10) {
        String str2;
        if (str == null) {
            j(35);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Recursion detected ");
        sb2.append(str);
        if (k10 == null) {
            str2 = "";
        } else {
            str2 = "on input: " + k10;
        }
        sb2.append(str2);
        sb2.append(" under ");
        sb2.append(this);
        throw ((AssertionError) q(new AssertionError(sb2.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.f362c + ")";
    }
}
