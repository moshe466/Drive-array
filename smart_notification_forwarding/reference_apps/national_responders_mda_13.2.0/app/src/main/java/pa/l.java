package pa;

import bb.i0;
import n9.d0;

/* loaded from: classes.dex */
public final class l extends g<Float> {
    public l(float f10) {
        super(Float.valueOf(f10));
    }

    @Override // pa.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i0 a(d0 d0Var) {
        y8.k.e(d0Var, "module");
        i0 B = d0Var.w().B();
        y8.k.d(B, "module.builtIns.floatType");
        return B;
    }

    @Override // pa.g
    public String toString() {
        return b().floatValue() + ".toFloat()";
    }
}
