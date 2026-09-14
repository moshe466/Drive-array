package n9;

/* loaded from: classes.dex */
public abstract class r extends u {

    /* renamed from: a, reason: collision with root package name */
    private final h1 f12298a;

    public r(h1 h1Var) {
        y8.k.e(h1Var, "delegate");
        this.f12298a = h1Var;
    }

    @Override // n9.u
    public h1 b() {
        return this.f12298a;
    }

    @Override // n9.u
    public String c() {
        return b().b();
    }

    @Override // n9.u
    public u f() {
        u j10 = t.j(b().d());
        y8.k.d(j10, "toDescriptorVisibility(delegate.normalize())");
        return j10;
    }
}
