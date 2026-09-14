package v9;

import n9.p0;
import na.e;

/* loaded from: classes.dex */
public final class p implements na.e {
    @Override // na.e
    public e.b a(n9.a aVar, n9.a aVar2, n9.e eVar) {
        y8.k.e(aVar, "superDescriptor");
        y8.k.e(aVar2, "subDescriptor");
        if (!(aVar2 instanceof p0) || !(aVar instanceof p0)) {
            return e.b.UNKNOWN;
        }
        p0 p0Var = (p0) aVar2;
        p0 p0Var2 = (p0) aVar;
        return !y8.k.a(p0Var.c(), p0Var2.c()) ? e.b.UNKNOWN : (z9.c.a(p0Var) && z9.c.a(p0Var2)) ? e.b.OVERRIDABLE : (z9.c.a(p0Var) || z9.c.a(p0Var2)) ? e.b.INCOMPATIBLE : e.b.UNKNOWN;
    }

    @Override // na.e
    public e.a b() {
        return e.a.BOTH;
    }
}
