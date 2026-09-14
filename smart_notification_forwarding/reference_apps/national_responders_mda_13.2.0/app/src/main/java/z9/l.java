package z9;

import bb.b0;
import ca.r;
import java.util.Collection;
import java.util.List;
import m8.q;
import n9.a1;
import n9.d1;
import n9.p0;
import n9.s0;
import z9.j;

/* loaded from: classes.dex */
public abstract class l extends j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(y9.g gVar) {
        super(gVar, null, 2, null);
        y8.k.e(gVar, "c");
    }

    @Override // z9.j
    protected j.a H(r rVar, List<? extends a1> list, b0 b0Var, List<? extends d1> list2) {
        List d10;
        y8.k.e(rVar, "method");
        y8.k.e(list, "methodTypeParameters");
        y8.k.e(b0Var, "returnType");
        y8.k.e(list2, "valueParameters");
        d10 = q.d();
        return new j.a(b0Var, null, list2, list, false, d10);
    }

    @Override // z9.j
    protected void s(la.e eVar, Collection<p0> collection) {
        y8.k.e(eVar, "name");
        y8.k.e(collection, "result");
    }

    @Override // z9.j
    protected s0 z() {
        return null;
    }
}
