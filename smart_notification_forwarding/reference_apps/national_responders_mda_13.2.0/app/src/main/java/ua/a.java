package ua;

import java.util.Collection;
import java.util.Set;
import n9.p0;
import n9.u0;

/* loaded from: classes.dex */
public abstract class a implements h {
    @Override // ua.h
    public Collection<p0> a(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return i().a(eVar, bVar);
    }

    @Override // ua.h
    public Collection<u0> b(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return i().b(eVar, bVar);
    }

    @Override // ua.h
    public Set<la.e> c() {
        return i().c();
    }

    @Override // ua.h
    public Set<la.e> d() {
        return i().d();
    }

    @Override // ua.k
    public Collection<n9.m> e(d dVar, x8.l<? super la.e, Boolean> lVar) {
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        return i().e(dVar, lVar);
    }

    @Override // ua.h
    public Set<la.e> f() {
        return i().f();
    }

    @Override // ua.k
    public n9.h g(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return i().g(eVar, bVar);
    }

    public final h h() {
        return i() instanceof a ? ((a) i()).h() : i();
    }

    protected abstract h i();
}
