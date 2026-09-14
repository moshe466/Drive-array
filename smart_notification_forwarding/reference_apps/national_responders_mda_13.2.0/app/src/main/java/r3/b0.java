package r3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b0<T> implements r4.b<T> {

    /* renamed from: c, reason: collision with root package name */
    private static final r4.a<Object> f13714c = z.b();

    /* renamed from: d, reason: collision with root package name */
    private static final r4.b<Object> f13715d = a0.a();

    /* renamed from: a, reason: collision with root package name */
    private r4.a<T> f13716a;

    /* renamed from: b, reason: collision with root package name */
    private volatile r4.b<T> f13717b;

    private b0(r4.a<T> aVar, r4.b<T> bVar) {
        this.f13716a = aVar;
        this.f13717b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> b0<T> a() {
        return new b0<>(f13714c, f13715d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(r4.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object c() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(r4.b<T> bVar) {
        r4.a<T> aVar;
        if (this.f13717b != f13715d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            aVar = this.f13716a;
            this.f13716a = null;
            this.f13717b = bVar;
        }
        aVar.a(bVar);
    }

    @Override // r4.b
    public T get() {
        return this.f13717b.get();
    }
}
