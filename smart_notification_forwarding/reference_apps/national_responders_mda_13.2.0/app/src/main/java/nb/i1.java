package nb;

/* loaded from: classes.dex */
public abstract class i1 extends u {
    public abstract i1 c0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final String d0() {
        i1 i1Var;
        i1 b10 = m0.b();
        if (this == b10) {
            return "Dispatchers.Main";
        }
        try {
            i1Var = b10.c0();
        } catch (UnsupportedOperationException unused) {
            i1Var = null;
        }
        if (this == i1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // nb.u
    public String toString() {
        String d02 = d0();
        if (d02 != null) {
            return d02;
        }
        return e0.a(this) + '@' + e0.b(this);
    }
}
