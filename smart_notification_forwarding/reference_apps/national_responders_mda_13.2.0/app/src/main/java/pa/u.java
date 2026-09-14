package pa;

import bb.i0;
import n9.d0;

/* loaded from: classes.dex */
public final class u extends o<Short> {
    public u(short s10) {
        super(Short.valueOf(s10));
    }

    @Override // pa.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i0 a(d0 d0Var) {
        y8.k.e(d0Var, "module");
        i0 S = d0Var.w().S();
        y8.k.d(S, "module.builtIns.shortType");
        return S;
    }

    @Override // pa.g
    public String toString() {
        return b().intValue() + ".toShort()";
    }
}
