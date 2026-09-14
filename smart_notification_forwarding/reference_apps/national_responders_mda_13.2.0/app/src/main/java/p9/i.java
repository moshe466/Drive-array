package p9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class i implements n9.k0 {

    /* renamed from: a, reason: collision with root package name */
    private final List<n9.h0> f13210a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(List<? extends n9.h0> list) {
        Set r02;
        y8.k.e(list, "providers");
        this.f13210a = list;
        list.size();
        r02 = m8.y.r0(list);
        r02.size();
    }

    @Override // n9.h0
    public List<n9.g0> a(la.b bVar) {
        List<n9.g0> n02;
        y8.k.e(bVar, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<n9.h0> it = this.f13210a.iterator();
        while (it.hasNext()) {
            n9.j0.a(it.next(), bVar, arrayList);
        }
        n02 = m8.y.n0(arrayList);
        return n02;
    }

    @Override // n9.k0
    public void b(la.b bVar, Collection<n9.g0> collection) {
        y8.k.e(bVar, "fqName");
        y8.k.e(collection, "packageFragments");
        Iterator<n9.h0> it = this.f13210a.iterator();
        while (it.hasNext()) {
            n9.j0.a(it.next(), bVar, collection);
        }
    }

    @Override // n9.h0
    public Collection<la.b> z(la.b bVar, x8.l<? super la.e, Boolean> lVar) {
        y8.k.e(bVar, "fqName");
        y8.k.e(lVar, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<n9.h0> it = this.f13210a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().z(bVar, lVar));
        }
        return hashSet;
    }
}
