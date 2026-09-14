package pa;

import bb.i0;
import n9.d0;

/* loaded from: classes.dex */
public final class i extends g<Double> {
    public i(double d10) {
        super(Double.valueOf(d10));
    }

    @Override // pa.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i0 a(d0 d0Var) {
        y8.k.e(d0Var, "module");
        i0 z10 = d0Var.w().z();
        y8.k.d(z10, "module.builtIns.doubleType");
        return z10;
    }

    @Override // pa.g
    public String toString() {
        return b().doubleValue() + ".toDouble()";
    }
}
