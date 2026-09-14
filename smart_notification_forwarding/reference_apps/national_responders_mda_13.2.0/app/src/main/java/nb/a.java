package nb;

/* loaded from: classes.dex */
public abstract class a<T> extends g1 implements a1 {

    /* renamed from: g, reason: collision with root package name */
    private final p8.f f12358g;

    @Override // nb.g1
    public final void J(Throwable th) {
        y.a(this.f12358g, th);
    }

    @Override // nb.g1
    public String R() {
        String a10 = t.a(this.f12358g);
        if (a10 == null) {
            return super.R();
        }
        return '\"' + a10 + "\":" + super.R();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nb.g1
    protected final void W(Object obj) {
        if (!(obj instanceof n)) {
            m0(obj);
        } else {
            n nVar = (n) obj;
            l0(nVar.f12408a, nVar.a());
        }
    }

    public final void b(Object obj) {
        Object P = P(r.d(obj, null, 1, null));
        if (P == h1.f12390b) {
            return;
        }
        k0(P);
    }

    public final p8.f c() {
        return this.f12358g;
    }

    @Override // nb.g1, nb.a1
    public boolean d() {
        return super.d();
    }

    protected void k0(Object obj) {
        m(obj);
    }

    protected void l0(Throwable th, boolean z10) {
    }

    protected void m0(T t10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // nb.g1
    public String r() {
        return y8.k.j(e0.a(this), " was cancelled");
    }
}
