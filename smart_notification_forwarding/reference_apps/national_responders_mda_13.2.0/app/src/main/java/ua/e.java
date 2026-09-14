package ua;

import bb.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KProperty;
import m8.q;
import m8.v;
import m8.y;
import n9.p0;
import n9.u0;
import n9.x;
import ua.k;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public abstract class e extends i {

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f14528d = {w.g(new t(w.b(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};

    /* renamed from: b, reason: collision with root package name */
    private final n9.e f14529b;

    /* renamed from: c, reason: collision with root package name */
    private final ab.i f14530c;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<List<? extends n9.m>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<n9.m> b() {
            List<n9.m> a02;
            List<x> i10 = e.this.i();
            a02 = y.a0(i10, e.this.j(i10));
            return a02;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends na.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<n9.m> f14532a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f14533b;

        b(ArrayList<n9.m> arrayList, e eVar) {
            this.f14532a = arrayList;
            this.f14533b = eVar;
        }

        @Override // na.i
        public void a(n9.b bVar) {
            y8.k.e(bVar, "fakeOverride");
            na.j.N(bVar, null);
            this.f14532a.add(bVar);
        }

        @Override // na.h
        protected void e(n9.b bVar, n9.b bVar2) {
            y8.k.e(bVar, "fromSuper");
            y8.k.e(bVar2, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.f14533b.l() + ": " + bVar + " vs " + bVar2).toString());
        }
    }

    public e(ab.n nVar, n9.e eVar) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(eVar, "containingClass");
        this.f14529b = eVar;
        this.f14530c = nVar.a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<n9.m> j(List<? extends x> list) {
        Collection<? extends n9.b> d10;
        ArrayList arrayList = new ArrayList(3);
        Collection<b0> x10 = this.f14529b.o().x();
        y8.k.d(x10, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = x10.iterator();
        while (it.hasNext()) {
            v.r(arrayList2, k.a.a(((b0) it.next()).A(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof n9.b) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            la.e c10 = ((n9.b) obj2).c();
            Object obj3 = linkedHashMap.get(c10);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(c10, obj3);
            }
            ((List) obj3).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            la.e eVar = (la.e) entry.getKey();
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj4 : list2) {
                Boolean valueOf = Boolean.valueOf(((n9.b) obj4) instanceof x);
                Object obj5 = linkedHashMap2.get(valueOf);
                if (obj5 == null) {
                    obj5 = new ArrayList();
                    linkedHashMap2.put(valueOf, obj5);
                }
                ((List) obj5).add(obj4);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                na.j jVar = na.j.f12341d;
                if (booleanValue) {
                    d10 = new ArrayList<>();
                    for (Object obj6 : list) {
                        if (y8.k.a(((x) obj6).c(), eVar)) {
                            d10.add(obj6);
                        }
                    }
                } else {
                    d10 = q.d();
                }
                jVar.y(eVar, list3, d10, this.f14529b, new b(arrayList, this));
            }
        }
        return jb.a.c(arrayList);
    }

    private final List<n9.m> k() {
        return (List) ab.m.a(this.f14530c, this, f14528d[0]);
    }

    @Override // ua.i, ua.h
    public Collection<p0> a(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        List<n9.m> k10 = k();
        jb.i iVar = new jb.i();
        for (Object obj : k10) {
            if ((obj instanceof p0) && y8.k.a(((p0) obj).c(), eVar)) {
                iVar.add(obj);
            }
        }
        return iVar;
    }

    @Override // ua.i, ua.h
    public Collection<u0> b(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        List<n9.m> k10 = k();
        jb.i iVar = new jb.i();
        for (Object obj : k10) {
            if ((obj instanceof u0) && y8.k.a(((u0) obj).c(), eVar)) {
                iVar.add(obj);
            }
        }
        return iVar;
    }

    @Override // ua.i, ua.k
    public Collection<n9.m> e(d dVar, x8.l<? super la.e, Boolean> lVar) {
        List d10;
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        if (dVar.a(d.f14518p.o())) {
            return k();
        }
        d10 = q.d();
        return d10;
    }

    protected abstract List<x> i();

    /* JADX INFO: Access modifiers changed from: protected */
    public final n9.e l() {
        return this.f14529b;
    }
}
