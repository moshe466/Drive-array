package r3;

/* loaded from: classes.dex */
public class w<T> implements r4.b<T> {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f13774c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private volatile Object f13775a = f13774c;

    /* renamed from: b, reason: collision with root package name */
    private volatile r4.b<T> f13776b;

    public w(r4.b<T> bVar) {
        this.f13776b = bVar;
    }

    @Override // r4.b
    public T get() {
        T t10 = (T) this.f13775a;
        Object obj = f13774c;
        if (t10 == obj) {
            synchronized (this) {
                t10 = (T) this.f13775a;
                if (t10 == obj) {
                    t10 = this.f13776b.get();
                    this.f13775a = t10;
                    this.f13776b = null;
                }
            }
        }
        return t10;
    }
}
