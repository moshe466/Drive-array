package L0;

/* loaded from: classes.dex */
public final class f extends a {

    /* renamed from: d, reason: collision with root package name */
    public final e f1247d;

    /* renamed from: e, reason: collision with root package name */
    public final Object[] f1248e;

    public f(e eVar, Object[] objArr) {
        super(eVar.f1246a, objArr);
        this.f1247d = eVar;
        this.f1248e = objArr;
    }

    @Override // L0.a
    public final Object[] a() {
        return (Object[]) this.f1248e.clone();
    }

    @Override // L0.a
    public final String toString() {
        return String.format(this.f1247d.f1246a, this.f1248e);
    }
}
