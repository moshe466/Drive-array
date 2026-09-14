package z9;

import ca.n;
import ca.p;
import ca.q;
import ca.r;
import ca.t;
import ca.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m8.k0;
import m8.y;

/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final ca.g f16248a;

    /* renamed from: b, reason: collision with root package name */
    private final x8.l<q, Boolean> f16249b;

    /* renamed from: c, reason: collision with root package name */
    private final x8.l<r, Boolean> f16250c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<la.e, List<r>> f16251d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<la.e, n> f16252e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<la.e, w> f16253f;

    /* renamed from: z9.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0345a extends y8.l implements x8.l<r, Boolean> {
        C0345a() {
            super(1);
        }

        public final boolean a(r rVar) {
            y8.k.e(rVar, "m");
            return ((Boolean) a.this.f16249b.h(rVar)).booleanValue() && !p.c(rVar);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(r rVar) {
            return Boolean.valueOf(a(rVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(ca.g gVar, x8.l<? super q, Boolean> lVar) {
        lb.h A;
        lb.h l10;
        lb.h A2;
        lb.h l11;
        int n10;
        int d10;
        int a10;
        y8.k.e(gVar, "jClass");
        y8.k.e(lVar, "memberFilter");
        this.f16248a = gVar;
        this.f16249b = lVar;
        C0345a c0345a = new C0345a();
        this.f16250c = c0345a;
        A = y.A(gVar.O());
        l10 = lb.n.l(A, c0345a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : l10) {
            la.e c10 = ((r) obj).c();
            Object obj2 = linkedHashMap.get(c10);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(c10, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.f16251d = linkedHashMap;
        A2 = y.A(this.f16248a.w());
        l11 = lb.n.l(A2, this.f16249b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : l11) {
            linkedHashMap2.put(((n) obj3).c(), obj3);
        }
        this.f16252e = linkedHashMap2;
        Collection<w> t10 = this.f16248a.t();
        x8.l<q, Boolean> lVar2 = this.f16249b;
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : t10) {
            if (((Boolean) lVar2.h(obj4)).booleanValue()) {
                arrayList.add(obj4);
            }
        }
        n10 = m8.r.n(arrayList, 10);
        d10 = k0.d(n10);
        a10 = d9.f.a(d10, 16);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(a10);
        for (Object obj5 : arrayList) {
            linkedHashMap3.put(((w) obj5).c(), obj5);
        }
        this.f16253f = linkedHashMap3;
    }

    @Override // z9.b
    public Set<la.e> a() {
        lb.h A;
        lb.h l10;
        A = y.A(this.f16248a.O());
        l10 = lb.n.l(A, this.f16250c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = l10.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((t) it.next()).c());
        }
        return linkedHashSet;
    }

    @Override // z9.b
    public Set<la.e> b() {
        return this.f16253f.keySet();
    }

    @Override // z9.b
    public w c(la.e eVar) {
        y8.k.e(eVar, "name");
        return this.f16253f.get(eVar);
    }

    @Override // z9.b
    public Set<la.e> d() {
        lb.h A;
        lb.h l10;
        A = y.A(this.f16248a.w());
        l10 = lb.n.l(A, this.f16249b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = l10.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((t) it.next()).c());
        }
        return linkedHashSet;
    }

    @Override // z9.b
    public Collection<r> e(la.e eVar) {
        List d10;
        y8.k.e(eVar, "name");
        List<r> list = this.f16251d.get(eVar);
        if (list != null) {
            return list;
        }
        d10 = m8.q.d();
        return d10;
    }

    @Override // z9.b
    public n f(la.e eVar) {
        y8.k.e(eVar, "name");
        return this.f16252e.get(eVar);
    }
}
