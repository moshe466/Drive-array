package p9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import m8.r0;
import ua.c;

/* loaded from: classes.dex */
public class g0 extends ua.i {

    /* renamed from: b, reason: collision with root package name */
    private final n9.d0 f13202b;

    /* renamed from: c, reason: collision with root package name */
    private final la.b f13203c;

    public g0(n9.d0 d0Var, la.b bVar) {
        y8.k.e(d0Var, "moduleDescriptor");
        y8.k.e(bVar, "fqName");
        this.f13202b = d0Var;
        this.f13203c = bVar;
    }

    @Override // ua.i, ua.k
    public Collection<n9.m> e(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        List d10;
        List d11;
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        if (!dVar.a(ua.d.f14505c.g())) {
            d11 = m8.q.d();
            return d11;
        }
        if (this.f13203c.d() && dVar.n().contains(c.b.f14504a)) {
            d10 = m8.q.d();
            return d10;
        }
        Collection<la.b> z10 = this.f13202b.z(this.f13203c, lVar);
        ArrayList arrayList = new ArrayList(z10.size());
        Iterator<la.b> it = z10.iterator();
        while (it.hasNext()) {
            la.e g10 = it.next().g();
            y8.k.d(g10, "subFqName.shortName()");
            if (lVar.h(g10).booleanValue()) {
                jb.a.a(arrayList, h(g10));
            }
        }
        return arrayList;
    }

    @Override // ua.i, ua.h
    public Set<la.e> f() {
        Set<la.e> b10;
        b10 = r0.b();
        return b10;
    }

    protected final n9.l0 h(la.e eVar) {
        y8.k.e(eVar, "name");
        if (eVar.s()) {
            return null;
        }
        n9.d0 d0Var = this.f13202b;
        la.b c10 = this.f13203c.c(eVar);
        y8.k.d(c10, "fqName.child(name)");
        n9.l0 C = d0Var.C(c10);
        if (C.isEmpty()) {
            return null;
        }
        return C;
    }
}
