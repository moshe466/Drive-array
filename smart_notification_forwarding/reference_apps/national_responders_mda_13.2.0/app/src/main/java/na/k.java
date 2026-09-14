package na;

import a0.a;
import java.util.Collection;
import java.util.LinkedList;
import l8.w;

/* loaded from: classes.dex */
public final class k {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [H] */
    /* loaded from: classes.dex */
    public static final class a<H> extends y8.l implements x8.l<H, w> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ jb.j<H> f12356f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(jb.j<H> jVar) {
            super(1);
            this.f12356f = jVar;
        }

        public final void a(H h10) {
            jb.j<H> jVar = this.f12356f;
            y8.k.d(h10, "it");
            jVar.add(h10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // x8.l
        public /* bridge */ /* synthetic */ w h(Object obj) {
            a(obj);
            return w.f11824a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> a(Collection<? extends H> collection, x8.l<? super H, ? extends n9.a> lVar) {
        y8.k.e(collection, "<this>");
        y8.k.e(lVar, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        jb.j a10 = jb.j.f11086h.a();
        while (!linkedList.isEmpty()) {
            Object H = m8.o.H(linkedList);
            jb.j a11 = jb.j.f11086h.a();
            Collection<a.d> s10 = j.s(H, linkedList, lVar, new a(a11));
            y8.k.d(s10, "val conflictedHandles = SmartSet.create<H>()\n\n        val overridableGroup =\n            OverridingUtil.extractMembersOverridableInBothWays(nextHandle, queue, descriptorByHandle) { conflictedHandles.add(it) }");
            if (s10.size() == 1 && a11.isEmpty()) {
                Object c02 = m8.o.c0(s10);
                y8.k.d(c02, "overridableGroup.single()");
                a10.add(c02);
            } else {
                a.d dVar = (Object) j.O(s10, lVar);
                y8.k.d(dVar, "selectMostSpecificMember(overridableGroup, descriptorByHandle)");
                n9.a h10 = lVar.h(dVar);
                for (a.d dVar2 : s10) {
                    y8.k.d(dVar2, "it");
                    if (!j.E(h10, lVar.h(dVar2))) {
                        a11.add(dVar2);
                    }
                }
                if (!a11.isEmpty()) {
                    a10.addAll(a11);
                }
                a10.add(dVar);
            }
        }
        return a10;
    }
}
