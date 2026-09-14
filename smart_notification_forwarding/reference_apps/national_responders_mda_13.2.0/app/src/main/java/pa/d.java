package pa;

import bb.i0;
import n9.d0;

/* loaded from: classes.dex */
public final class d extends o<Byte> {
    public d(byte b10) {
        super(Byte.valueOf(b10));
    }

    @Override // pa.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i0 a(d0 d0Var) {
        y8.k.e(d0Var, "module");
        i0 t10 = d0Var.w().t();
        y8.k.d(t10, "module.builtIns.byteType");
        return t10;
    }

    @Override // pa.g
    public String toString() {
        return b().intValue() + ".toByte()";
    }
}
