package pa;

import bb.b0;
import bb.i0;
import k9.k;
import n9.d0;

/* loaded from: classes.dex */
public final class z extends a0<Short> {
    public z(short s10) {
        super(Short.valueOf(s10));
    }

    @Override // pa.g
    public b0 a(d0 d0Var) {
        y8.k.e(d0Var, "module");
        n9.e a10 = n9.w.a(d0Var, k.a.f11262f0);
        i0 s10 = a10 == null ? null : a10.s();
        if (s10 != null) {
            return s10;
        }
        i0 j10 = bb.t.j("Unsigned type UShort not found");
        y8.k.d(j10, "createErrorType(\"Unsigned type UShort not found\")");
        return j10;
    }

    @Override // pa.g
    public String toString() {
        return b().intValue() + ".toUShort()";
    }
}
