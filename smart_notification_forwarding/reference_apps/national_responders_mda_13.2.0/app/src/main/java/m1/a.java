package m1;

/* loaded from: classes.dex */
public final class a<T> implements k8.a<T> {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f12006c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private volatile k8.a<T> f12007a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f12008b = f12006c;

    private a(k8.a<T> aVar) {
        this.f12007a = aVar;
    }

    public static <P extends k8.a<T>, T> k8.a<T> a(P p10) {
        d.b(p10);
        return p10 instanceof a ? p10 : new a(p10);
    }

    public static Object b(Object obj, Object obj2) {
        if (!(obj != f12006c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // k8.a
    public T get() {
        T t10 = (T) this.f12008b;
        Object obj = f12006c;
        if (t10 == obj) {
            synchronized (this) {
                t10 = (T) this.f12008b;
                if (t10 == obj) {
                    t10 = this.f12007a.get();
                    this.f12008b = b(this.f12008b, t10);
                    this.f12007a = null;
                }
            }
        }
        return t10;
    }
}
