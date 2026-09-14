package v9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k9.k;
import m8.l0;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f14784a = new g();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<la.b, la.e> f14785b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<la.e, List<la.e>> f14786c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set<la.b> f14787d;

    /* renamed from: e, reason: collision with root package name */
    private static final Set<la.e> f14788e;

    static {
        la.b d10;
        la.b d11;
        la.b c10;
        la.b c11;
        la.b d12;
        la.b c12;
        la.b c13;
        la.b c14;
        Map<la.b, la.e> k10;
        int n10;
        int n11;
        Set<la.e> r02;
        la.c cVar = k.a.f11284r;
        d10 = h.d(cVar, "name");
        d11 = h.d(cVar, "ordinal");
        c10 = h.c(k.a.J, "size");
        la.b bVar = k.a.N;
        c11 = h.c(bVar, "size");
        d12 = h.d(k.a.f11261f, "length");
        c12 = h.c(bVar, "keys");
        c13 = h.c(bVar, "values");
        c14 = h.c(bVar, "entries");
        k10 = l0.k(l8.t.a(d10, la.e.r("name")), l8.t.a(d11, la.e.r("ordinal")), l8.t.a(c10, la.e.r("size")), l8.t.a(c11, la.e.r("size")), l8.t.a(d12, la.e.r("length")), l8.t.a(c12, la.e.r("keySet")), l8.t.a(c13, la.e.r("values")), l8.t.a(c14, la.e.r("entrySet")));
        f14785b = k10;
        Set<Map.Entry<la.b, la.e>> entrySet = k10.entrySet();
        n10 = m8.r.n(entrySet, 10);
        ArrayList<l8.n> arrayList = new ArrayList(n10);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new l8.n(((la.b) entry.getKey()).g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (l8.n nVar : arrayList) {
            la.e eVar = (la.e) nVar.d();
            Object obj = linkedHashMap.get(eVar);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(eVar, obj);
            }
            ((List) obj).add((la.e) nVar.c());
        }
        f14786c = linkedHashMap;
        Set<la.b> keySet = f14785b.keySet();
        f14787d = keySet;
        n11 = m8.r.n(keySet, 10);
        ArrayList arrayList2 = new ArrayList(n11);
        Iterator<T> it2 = keySet.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((la.b) it2.next()).g());
        }
        r02 = m8.y.r0(arrayList2);
        f14788e = r02;
    }

    private g() {
    }

    public final Map<la.b, la.e> a() {
        return f14785b;
    }

    public final List<la.e> b(la.e eVar) {
        List<la.e> d10;
        y8.k.e(eVar, "name1");
        List<la.e> list = f14786c.get(eVar);
        if (list != null) {
            return list;
        }
        d10 = m8.q.d();
        return d10;
    }

    public final Set<la.b> c() {
        return f14787d;
    }

    public final Set<la.e> d() {
        return f14788e;
    }
}
