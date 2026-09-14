package ua;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import m8.q;
import n9.z0;

/* loaded from: classes.dex */
public final class f extends i {

    /* renamed from: b, reason: collision with root package name */
    private final h f14534b;

    public f(h hVar) {
        y8.k.e(hVar, "workerScope");
        this.f14534b = hVar;
    }

    @Override // ua.i, ua.h
    public Set<la.e> c() {
        return this.f14534b.c();
    }

    @Override // ua.i, ua.h
    public Set<la.e> d() {
        return this.f14534b.d();
    }

    @Override // ua.i, ua.h
    public Set<la.e> f() {
        return this.f14534b.f();
    }

    @Override // ua.i, ua.k
    public n9.h g(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        n9.h g10 = this.f14534b.g(eVar, bVar);
        if (g10 == null) {
            return null;
        }
        n9.e eVar2 = g10 instanceof n9.e ? (n9.e) g10 : null;
        if (eVar2 != null) {
            return eVar2;
        }
        if (g10 instanceof z0) {
            return (z0) g10;
        }
        return null;
    }

    @Override // ua.i, ua.k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public List<n9.h> e(d dVar, x8.l<? super la.e, Boolean> lVar) {
        List<n9.h> d10;
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        d p10 = dVar.p(d.f14505c.d());
        if (p10 == null) {
            d10 = q.d();
            return d10;
        }
        Collection<n9.m> e10 = this.f14534b.e(p10, lVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : e10) {
            if (obj instanceof n9.i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public String toString() {
        return y8.k.j("Classes from ", this.f14534b);
    }
}
