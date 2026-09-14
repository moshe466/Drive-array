package h9;

import java.lang.ref.SoftReference;

/* loaded from: classes.dex */
public class d0 {

    /* loaded from: classes.dex */
    public static class a<T> extends c<T> implements x8.a<T> {

        /* renamed from: g, reason: collision with root package name */
        private final x8.a<T> f10514g;

        /* renamed from: h, reason: collision with root package name */
        private volatile SoftReference<Object> f10515h;

        public a(T t10, x8.a<T> aVar) {
            if (aVar == null) {
                i(0);
            }
            this.f10515h = null;
            this.f10514g = aVar;
            if (t10 != null) {
                this.f10515h = new SoftReference<>(a(t10));
            }
        }

        private static /* synthetic */ void i(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        @Override // h9.d0.c, x8.a
        public T b() {
            Object obj;
            SoftReference<Object> softReference = this.f10515h;
            if (softReference != null && (obj = softReference.get()) != null) {
                return d(obj);
            }
            T b10 = this.f10514g.b();
            this.f10515h = new SoftReference<>(a(b10));
            return b10;
        }
    }

    /* loaded from: classes.dex */
    public static class b<T> extends c<T> {

        /* renamed from: g, reason: collision with root package name */
        private final x8.a<T> f10516g;

        /* renamed from: h, reason: collision with root package name */
        private volatile Object f10517h;

        public b(x8.a<T> aVar) {
            if (aVar == null) {
                i(0);
            }
            this.f10517h = null;
            this.f10516g = aVar;
        }

        private static /* synthetic */ void i(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        @Override // h9.d0.c, x8.a
        public T b() {
            Object obj = this.f10517h;
            if (obj != null) {
                return d(obj);
            }
            T b10 = this.f10516g.b();
            this.f10517h = a(b10);
            return b10;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c<T> {

        /* renamed from: f, reason: collision with root package name */
        private static final Object f10518f = new a();

        /* loaded from: classes.dex */
        static class a {
            a() {
            }
        }

        protected Object a(T t10) {
            return t10 == null ? f10518f : t10;
        }

        public abstract T b();

        public final T c(Object obj, Object obj2) {
            return b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected T d(Object obj) {
            if (obj == f10518f) {
                return null;
            }
            return obj;
        }
    }

    private static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i10 == 1 || i10 == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <T> b<T> b(x8.a<T> aVar) {
        if (aVar == null) {
            a(0);
        }
        return new b<>(aVar);
    }

    public static <T> a<T> c(T t10, x8.a<T> aVar) {
        if (aVar == null) {
            a(1);
        }
        return new a<>(t10, aVar);
    }

    public static <T> a<T> d(x8.a<T> aVar) {
        if (aVar == null) {
            a(2);
        }
        return c(null, aVar);
    }
}
