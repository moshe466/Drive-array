package nb;

/* loaded from: classes.dex */
public final class j1 extends kotlinx.coroutines.internal.m implements w0 {
    @Override // nb.w0
    public boolean d() {
        return true;
    }

    @Override // nb.w0
    public j1 i() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.o
    public String toString() {
        return d0.b() ? w("Active") : super.toString();
    }

    public final String w(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("List{");
        sb2.append(str);
        sb2.append("}[");
        boolean z10 = true;
        for (kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) m(); !y8.k.a(oVar, this); oVar = oVar.o()) {
            if (oVar instanceof f1) {
                f1 f1Var = (f1) oVar;
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(", ");
                }
                sb2.append(f1Var);
            }
        }
        sb2.append("]");
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
