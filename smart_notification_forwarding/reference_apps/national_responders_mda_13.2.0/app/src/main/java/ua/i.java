package ua;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import m8.q;
import n9.p0;
import n9.u0;

/* loaded from: classes.dex */
public abstract class i implements h {
    @Override // ua.h
    public Collection<? extends p0> a(la.e eVar, u9.b bVar) {
        List d10;
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        d10 = q.d();
        return d10;
    }

    @Override // ua.h
    public Collection<? extends u0> b(la.e eVar, u9.b bVar) {
        List d10;
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        d10 = q.d();
        return d10;
    }

    @Override // ua.h
    public Set<la.e> c() {
        Collection<n9.m> e10 = e(d.f14520r, jb.d.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : e10) {
            if (obj instanceof u0) {
                la.e c10 = ((u0) obj).c();
                y8.k.d(c10, "it.name");
                linkedHashSet.add(c10);
            }
        }
        return linkedHashSet;
    }

    @Override // ua.h
    public Set<la.e> d() {
        Collection<n9.m> e10 = e(d.f14521s, jb.d.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : e10) {
            if (obj instanceof u0) {
                la.e c10 = ((u0) obj).c();
                y8.k.d(c10, "it.name");
                linkedHashSet.add(c10);
            }
        }
        return linkedHashSet;
    }

    @Override // ua.k
    public Collection<n9.m> e(d dVar, x8.l<? super la.e, Boolean> lVar) {
        List d10;
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        d10 = q.d();
        return d10;
    }

    @Override // ua.h
    public Set<la.e> f() {
        return null;
    }

    @Override // ua.k
    public n9.h g(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return null;
    }
}
