package pa;

import bb.i0;
import n9.d0;

/* loaded from: classes.dex */
public final class r extends o<Long> {
    public r(long j10) {
        super(Long.valueOf(j10));
    }

    @Override // pa.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i0 a(d0 d0Var) {
        y8.k.e(d0Var, "module");
        i0 F = d0Var.w().F();
        y8.k.d(F, "module.builtIns.longType");
        return F;
    }

    @Override // pa.g
    public String toString() {
        return b().longValue() + ".toLong()";
    }
}
