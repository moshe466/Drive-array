package ua;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import m8.q;
import m8.r0;
import m8.v;
import n9.p0;
import n9.u0;
import ua.h;

/* loaded from: classes.dex */
public final class b implements h {

    /* renamed from: d, reason: collision with root package name */
    public static final a f14499d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final String f14500b;

    /* renamed from: c, reason: collision with root package name */
    private final h[] f14501c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final h a(String str, Iterable<? extends h> iterable) {
            y8.k.e(str, "debugName");
            y8.k.e(iterable, "scopes");
            jb.i iVar = new jb.i();
            for (h hVar : iterable) {
                if (hVar != h.b.f14541b) {
                    if (hVar instanceof b) {
                        v.s(iVar, ((b) hVar).f14501c);
                    } else {
                        iVar.add(hVar);
                    }
                }
            }
            return b(str, iVar);
        }

        public final h b(String str, List<? extends h> list) {
            y8.k.e(str, "debugName");
            y8.k.e(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return h.b.f14541b;
            }
            if (size == 1) {
                return list.get(0);
            }
            Object[] array = list.toArray(new h[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new b(str, (h[]) array, null);
        }
    }

    private b(String str, h[] hVarArr) {
        this.f14500b = str;
        this.f14501c = hVarArr;
    }

    public /* synthetic */ b(String str, h[] hVarArr, y8.g gVar) {
        this(str, hVarArr);
    }

    @Override // ua.h
    public Collection<p0> a(la.e eVar, u9.b bVar) {
        List d10;
        Set b10;
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        h[] hVarArr = this.f14501c;
        int length = hVarArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        int i10 = 0;
        if (length == 1) {
            return hVarArr[0].a(eVar, bVar);
        }
        Collection<p0> collection = null;
        int length2 = hVarArr.length;
        while (i10 < length2) {
            h hVar = hVarArr[i10];
            i10++;
            collection = ib.a.a(collection, hVar.a(eVar, bVar));
        }
        if (collection != null) {
            return collection;
        }
        b10 = r0.b();
        return b10;
    }

    @Override // ua.h
    public Collection<u0> b(la.e eVar, u9.b bVar) {
        List d10;
        Set b10;
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        h[] hVarArr = this.f14501c;
        int length = hVarArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        int i10 = 0;
        if (length == 1) {
            return hVarArr[0].b(eVar, bVar);
        }
        Collection<u0> collection = null;
        int length2 = hVarArr.length;
        while (i10 < length2) {
            h hVar = hVarArr[i10];
            i10++;
            collection = ib.a.a(collection, hVar.b(eVar, bVar));
        }
        if (collection != null) {
            return collection;
        }
        b10 = r0.b();
        return b10;
    }

    @Override // ua.h
    public Set<la.e> c() {
        h[] hVarArr = this.f14501c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : hVarArr) {
            v.r(linkedHashSet, hVar.c());
        }
        return linkedHashSet;
    }

    @Override // ua.h
    public Set<la.e> d() {
        h[] hVarArr = this.f14501c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : hVarArr) {
            v.r(linkedHashSet, hVar.d());
        }
        return linkedHashSet;
    }

    @Override // ua.k
    public Collection<n9.m> e(d dVar, x8.l<? super la.e, Boolean> lVar) {
        List d10;
        Set b10;
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        h[] hVarArr = this.f14501c;
        int length = hVarArr.length;
        if (length == 0) {
            d10 = q.d();
            return d10;
        }
        int i10 = 0;
        if (length == 1) {
            return hVarArr[0].e(dVar, lVar);
        }
        Collection<n9.m> collection = null;
        int length2 = hVarArr.length;
        while (i10 < length2) {
            h hVar = hVarArr[i10];
            i10++;
            collection = ib.a.a(collection, hVar.e(dVar, lVar));
        }
        if (collection != null) {
            return collection;
        }
        b10 = r0.b();
        return b10;
    }

    @Override // ua.h
    public Set<la.e> f() {
        Iterable j10;
        j10 = m8.k.j(this.f14501c);
        return j.a(j10);
    }

    @Override // ua.k
    public n9.h g(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        h[] hVarArr = this.f14501c;
        int length = hVarArr.length;
        n9.h hVar = null;
        int i10 = 0;
        while (i10 < length) {
            h hVar2 = hVarArr[i10];
            i10++;
            n9.h g10 = hVar2.g(eVar, bVar);
            if (g10 != null) {
                if (!(g10 instanceof n9.i) || !((n9.i) g10).l0()) {
                    return g10;
                }
                if (hVar == null) {
                    hVar = g10;
                }
            }
        }
        return hVar;
    }

    public String toString() {
        return this.f14500b;
    }
}
