package pa;

import bb.i0;
import n9.d0;

/* loaded from: classes.dex */
public final class v extends g<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(String str) {
        super(str);
        y8.k.e(str, "value");
    }

    @Override // pa.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i0 a(d0 d0Var) {
        y8.k.e(d0Var, "module");
        i0 V = d0Var.w().V();
        y8.k.d(V, "module.builtIns.stringType");
        return V;
    }

    @Override // pa.g
    public String toString() {
        return '\"' + b() + '\"';
    }
}
