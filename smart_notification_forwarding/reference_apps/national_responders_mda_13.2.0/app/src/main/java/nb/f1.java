package nb;

/* loaded from: classes.dex */
public abstract class f1 extends p implements n0, w0 {

    /* renamed from: i, reason: collision with root package name */
    public g1 f12373i;

    @Override // nb.w0
    public boolean d() {
        return true;
    }

    @Override // nb.n0
    public void dispose() {
        x().Z(this);
    }

    @Override // nb.w0
    public j1 i() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.o
    public String toString() {
        return e0.a(this) + '@' + e0.b(this) + "[job@" + e0.b(x()) + ']';
    }

    public final g1 x() {
        g1 g1Var = this.f12373i;
        if (g1Var != null) {
            return g1Var;
        }
        y8.k.o("job");
        return null;
    }

    public final void y(g1 g1Var) {
        this.f12373i = g1Var;
    }
}
