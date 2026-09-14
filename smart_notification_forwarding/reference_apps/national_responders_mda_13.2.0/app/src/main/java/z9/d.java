package z9;

import ca.u;
import ea.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import m8.r0;
import m8.v;
import n9.p0;
import n9.u0;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public final class d implements ua.h {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f16256f = {w.g(new t(w.b(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* renamed from: b, reason: collision with root package name */
    private final y9.g f16257b;

    /* renamed from: c, reason: collision with root package name */
    private final h f16258c;

    /* renamed from: d, reason: collision with root package name */
    private final i f16259d;

    /* renamed from: e, reason: collision with root package name */
    private final ab.i f16260e;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<MemberScope[]> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ua.h[] b() {
            Collection<o> values = d.this.f16258c.X0().values();
            d dVar = d.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                ua.h d10 = dVar.f16257b.a().b().d(dVar.f16258c, (o) it.next());
                if (d10 != null) {
                    arrayList.add(d10);
                }
            }
            Object[] array = ib.a.b(arrayList).toArray(new ua.h[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (ua.h[]) array;
        }
    }

    public d(y9.g gVar, u uVar, h hVar) {
        y8.k.e(gVar, "c");
        y8.k.e(uVar, "jPackage");
        y8.k.e(hVar, "packageFragment");
        this.f16257b = gVar;
        this.f16258c = hVar;
        this.f16259d = new i(gVar, uVar, hVar);
        this.f16260e = gVar.e().a(new a());
    }

    private final ua.h[] k() {
        return (ua.h[]) ab.m.a(this.f16260e, this, f16256f[0]);
    }

    @Override // ua.h
    public Collection<p0> a(la.e eVar, u9.b bVar) {
        Set b10;
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        l(eVar, bVar);
        i iVar = this.f16259d;
        ua.h[] k10 = k();
        Collection<? extends p0> a10 = iVar.a(eVar, bVar);
        int length = k10.length;
        int i10 = 0;
        Collection collection = a10;
        while (i10 < length) {
            ua.h hVar = k10[i10];
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
        Set b10;
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        l(eVar, bVar);
        i iVar = this.f16259d;
        ua.h[] k10 = k();
        Collection<? extends u0> b11 = iVar.b(eVar, bVar);
        int length = k10.length;
        int i10 = 0;
        Collection collection = b11;
        while (i10 < length) {
            ua.h hVar = k10[i10];
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
        ua.h[] k10 = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ua.h hVar : k10) {
            v.r(linkedHashSet, hVar.c());
        }
        linkedHashSet.addAll(j().c());
        return linkedHashSet;
    }

    @Override // ua.h
    public Set<la.e> d() {
        ua.h[] k10 = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ua.h hVar : k10) {
            v.r(linkedHashSet, hVar.d());
        }
        linkedHashSet.addAll(j().d());
        return linkedHashSet;
    }

    @Override // ua.k
    public Collection<n9.m> e(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        Set b10;
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        i iVar = this.f16259d;
        ua.h[] k10 = k();
        Collection<n9.m> e10 = iVar.e(dVar, lVar);
        int length = k10.length;
        int i10 = 0;
        while (i10 < length) {
            ua.h hVar = k10[i10];
            i10++;
            e10 = ib.a.a(e10, hVar.e(dVar, lVar));
        }
        if (e10 != null) {
            return e10;
        }
        b10 = r0.b();
        return b10;
    }

    @Override // ua.h
    public Set<la.e> f() {
        Iterable j10;
        j10 = m8.k.j(k());
        Set<la.e> a10 = ua.j.a(j10);
        if (a10 == null) {
            return null;
        }
        a10.addAll(j().f());
        return a10;
    }

    @Override // ua.k
    public n9.h g(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        l(eVar, bVar);
        n9.e g10 = this.f16259d.g(eVar, bVar);
        if (g10 != null) {
            return g10;
        }
        ua.h[] k10 = k();
        n9.h hVar = null;
        int i10 = 0;
        int length = k10.length;
        while (i10 < length) {
            ua.h hVar2 = k10[i10];
            i10++;
            n9.h g11 = hVar2.g(eVar, bVar);
            if (g11 != null) {
                if (!(g11 instanceof n9.i) || !((n9.i) g11).l0()) {
                    return g11;
                }
                if (hVar == null) {
                    hVar = g11;
                }
            }
        }
        return hVar;
    }

    public final i j() {
        return this.f16259d;
    }

    public void l(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        t9.a.b(this.f16257b.a().k(), bVar, this.f16258c, eVar);
    }
}
