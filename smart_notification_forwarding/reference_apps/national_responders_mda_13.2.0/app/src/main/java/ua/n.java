package ua;

import bb.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import m8.r;
import m8.y;
import n9.p0;
import n9.u0;

/* loaded from: classes.dex */
public final class n extends ua.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f14551c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final h f14552b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final h a(String str, Collection<? extends b0> collection) {
            int n10;
            y8.k.e(str, "message");
            y8.k.e(collection, "types");
            n10 = r.n(collection, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((b0) it.next()).A());
            }
            jb.i<h> b10 = ib.a.b(arrayList);
            h b11 = ua.b.f14499d.b(str, b10);
            return b10.size() <= 1 ? b11 : new n(str, b11, null);
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.l<n9.a, n9.a> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f14553f = new b();

        b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n9.a h(n9.a aVar) {
            y8.k.e(aVar, "<this>");
            return aVar;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.l<u0, n9.a> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f14554f = new c();

        c() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n9.a h(u0 u0Var) {
            y8.k.e(u0Var, "<this>");
            return u0Var;
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.l<p0, n9.a> {

        /* renamed from: f, reason: collision with root package name */
        public static final d f14555f = new d();

        d() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n9.a h(p0 p0Var) {
            y8.k.e(p0Var, "<this>");
            return p0Var;
        }
    }

    private n(String str, h hVar) {
        this.f14552b = hVar;
    }

    public /* synthetic */ n(String str, h hVar, y8.g gVar) {
        this(str, hVar);
    }

    public static final h j(String str, Collection<? extends b0> collection) {
        return f14551c.a(str, collection);
    }

    @Override // ua.a, ua.h
    public Collection<p0> a(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return na.k.a(super.a(eVar, bVar), d.f14555f);
    }

    @Override // ua.a, ua.h
    public Collection<u0> b(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return na.k.a(super.b(eVar, bVar), c.f14554f);
    }

    @Override // ua.a, ua.k
    public Collection<n9.m> e(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        List a02;
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        Collection<n9.m> e10 = super.e(dVar, lVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : e10) {
            if (((n9.m) obj) instanceof n9.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        l8.n nVar = new l8.n(arrayList, arrayList2);
        List list = (List) nVar.a();
        a02 = y.a0(na.k.a(list, b.f14553f), (List) nVar.b());
        return a02;
    }

    @Override // ua.a
    protected h i() {
        return this.f14552b;
    }
}
