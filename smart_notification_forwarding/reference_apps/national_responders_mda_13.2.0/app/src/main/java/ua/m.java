package ua;

import bb.a1;
import bb.y0;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import n9.p0;
import n9.u0;
import n9.x0;
import ua.k;

/* loaded from: classes.dex */
public final class m implements h {

    /* renamed from: b, reason: collision with root package name */
    private final h f14546b;

    /* renamed from: c, reason: collision with root package name */
    private final a1 f14547c;

    /* renamed from: d, reason: collision with root package name */
    private Map<n9.m, n9.m> f14548d;

    /* renamed from: e, reason: collision with root package name */
    private final l8.h f14549e;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<Collection<? extends n9.m>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<n9.m> b() {
            m mVar = m.this;
            return mVar.k(k.a.a(mVar.f14546b, null, null, 3, null));
        }
    }

    public m(h hVar, a1 a1Var) {
        l8.h b10;
        y8.k.e(hVar, "workerScope");
        y8.k.e(a1Var, "givenSubstitutor");
        this.f14546b = hVar;
        y0 j10 = a1Var.j();
        y8.k.d(j10, "givenSubstitutor.substitution");
        this.f14547c = oa.d.f(j10, false, 1, null).c();
        b10 = l8.j.b(new a());
        this.f14549e = b10;
    }

    private final Collection<n9.m> j() {
        return (Collection) this.f14549e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends n9.m> Collection<D> k(Collection<? extends D> collection) {
        if (this.f14547c.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet g10 = jb.a.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            g10.add(l((n9.m) it.next()));
        }
        return g10;
    }

    private final <D extends n9.m> D l(D d10) {
        if (this.f14547c.k()) {
            return d10;
        }
        if (this.f14548d == null) {
            this.f14548d = new HashMap();
        }
        Map<n9.m, n9.m> map = this.f14548d;
        y8.k.b(map);
        n9.m mVar = map.get(d10);
        if (mVar == null) {
            if (!(d10 instanceof x0)) {
                throw new IllegalStateException(y8.k.j("Unknown descriptor in scope: ", d10).toString());
            }
            mVar = ((x0) d10).e(this.f14547c);
            if (mVar == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d10 + " substitution fails");
            }
            map.put(d10, mVar);
        }
        return (D) mVar;
    }

    @Override // ua.h
    public Collection<? extends p0> a(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return k(this.f14546b.a(eVar, bVar));
    }

    @Override // ua.h
    public Collection<? extends u0> b(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return k(this.f14546b.b(eVar, bVar));
    }

    @Override // ua.h
    public Set<la.e> c() {
        return this.f14546b.c();
    }

    @Override // ua.h
    public Set<la.e> d() {
        return this.f14546b.d();
    }

    @Override // ua.k
    public Collection<n9.m> e(d dVar, x8.l<? super la.e, Boolean> lVar) {
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        return j();
    }

    @Override // ua.h
    public Set<la.e> f() {
        return this.f14546b.f();
    }

    @Override // ua.k
    public n9.h g(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        n9.h g10 = this.f14546b.g(eVar, bVar);
        if (g10 == null) {
            return null;
        }
        return (n9.h) l(g10);
    }
}
