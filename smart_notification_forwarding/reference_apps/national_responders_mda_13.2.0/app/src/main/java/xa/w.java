package xa;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import m8.k0;
import n9.v0;

/* loaded from: classes.dex */
public final class w implements g {

    /* renamed from: a, reason: collision with root package name */
    private final ia.c f15653a;

    /* renamed from: b, reason: collision with root package name */
    private final ia.a f15654b;

    /* renamed from: c, reason: collision with root package name */
    private final x8.l<la.a, v0> f15655c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<la.a, ga.c> f15656d;

    /* JADX WARN: Multi-variable type inference failed */
    public w(ga.m mVar, ia.c cVar, ia.a aVar, x8.l<? super la.a, ? extends v0> lVar) {
        int n10;
        int d10;
        int a10;
        y8.k.e(mVar, "proto");
        y8.k.e(cVar, "nameResolver");
        y8.k.e(aVar, "metadataVersion");
        y8.k.e(lVar, "classSource");
        this.f15653a = cVar;
        this.f15654b = aVar;
        this.f15655c = lVar;
        List<ga.c> L = mVar.L();
        y8.k.d(L, "proto.class_List");
        n10 = m8.r.n(L, 10);
        d10 = k0.d(n10);
        a10 = d9.f.a(d10, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
        for (Object obj : L) {
            linkedHashMap.put(v.a(this.f15653a, ((ga.c) obj).p0()), obj);
        }
        this.f15656d = linkedHashMap;
    }

    @Override // xa.g
    public f a(la.a aVar) {
        y8.k.e(aVar, "classId");
        ga.c cVar = this.f15656d.get(aVar);
        if (cVar == null) {
            return null;
        }
        return new f(this.f15653a, cVar, this.f15654b, this.f15655c.h(aVar));
    }

    public final Collection<la.a> b() {
        return this.f15656d.keySet();
    }
}
