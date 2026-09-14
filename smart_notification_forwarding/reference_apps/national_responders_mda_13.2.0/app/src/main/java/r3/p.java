package r3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
class p {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final d<?> f13760a;

        /* renamed from: b, reason: collision with root package name */
        private final Set<b> f13761b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        private final Set<b> f13762c = new HashSet();

        b(d<?> dVar) {
            this.f13760a = dVar;
        }

        void a(b bVar) {
            this.f13761b.add(bVar);
        }

        void b(b bVar) {
            this.f13762c.add(bVar);
        }

        d<?> c() {
            return this.f13760a;
        }

        Set<b> d() {
            return this.f13761b;
        }

        boolean e() {
            return this.f13761b.isEmpty();
        }

        boolean f() {
            return this.f13762c.isEmpty();
        }

        void g(b bVar) {
            this.f13762c.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final Class<?> f13763a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f13764b;

        private c(Class<?> cls, boolean z10) {
            this.f13763a = cls;
            this.f13764b = z10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f13763a.equals(this.f13763a) && cVar.f13764b == this.f13764b;
        }

        public int hashCode() {
            return ((this.f13763a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f13764b).hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<d<?>> list) {
        Set<b> c10 = c(list);
        Set<b> b10 = b(c10);
        int i10 = 0;
        while (!b10.isEmpty()) {
            b next = b10.iterator().next();
            b10.remove(next);
            i10++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    b10.add(bVar);
                }
            }
        }
        if (i10 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : c10) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new r(arrayList);
    }

    private static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set<b> c(List<d<?>> list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator<d<?>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = hashMap.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (q qVar : bVar.c().c()) {
                            if (qVar.d() && (set = (Set) hashMap.get(new c(qVar.b(), qVar.f()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = hashMap.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            d<?> next = it.next();
            b bVar3 = new b(next);
            for (Class<? super Object> cls : next.e()) {
                c cVar = new c(cls, !next.k());
                if (!hashMap.containsKey(cVar)) {
                    hashMap.put(cVar, new HashSet());
                }
                Set set2 = (Set) hashMap.get(cVar);
                if (!set2.isEmpty() && !cVar.f13764b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(bVar3);
            }
        }
    }
}
