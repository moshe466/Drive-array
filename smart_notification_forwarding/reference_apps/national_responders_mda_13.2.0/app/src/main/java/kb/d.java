package kb;

/* loaded from: classes.dex */
final class d<V> {

    /* renamed from: b, reason: collision with root package name */
    private static final d<Object> f11337b = new d<>(c.f11331f);

    /* renamed from: a, reason: collision with root package name */
    private final c<V> f11338a;

    private d(c<V> cVar) {
        this.f11338a = cVar;
    }

    public static <V> d<V> a() {
        return (d<V>) f11337b;
    }

    private d<V> d(c<V> cVar) {
        return cVar == this.f11338a ? this : new d<>(cVar);
    }

    public V b(int i10) {
        return this.f11338a.a(i10);
    }

    public d<V> c(int i10, V v10) {
        return d(this.f11338a.b(i10, v10));
    }
}
