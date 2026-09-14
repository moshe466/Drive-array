package za;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import m8.r0;
import m8.v;
import m8.y;
import n9.g0;

/* loaded from: classes.dex */
public class i extends h {

    /* renamed from: g, reason: collision with root package name */
    private final g0 f16478g;

    /* renamed from: h, reason: collision with root package name */
    private final la.b f16479h;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i(n9.g0 r16, ga.l r17, ia.c r18, ia.a r19, za.f r20, xa.j r21, x8.a<? extends java.util.Collection<la.e>> r22) {
        /*
            r15 = this;
            r6 = r15
            r14 = r16
            java.lang.String r0 = "packageDescriptor"
            y8.k.e(r14, r0)
            java.lang.String r0 = "proto"
            r1 = r17
            y8.k.e(r1, r0)
            java.lang.String r0 = "nameResolver"
            r2 = r18
            y8.k.e(r2, r0)
            java.lang.String r0 = "metadataVersion"
            r3 = r19
            y8.k.e(r3, r0)
            java.lang.String r0 = "components"
            r4 = r21
            y8.k.e(r4, r0)
            java.lang.String r0 = "classNames"
            r5 = r22
            y8.k.e(r5, r0)
            ia.g r10 = new ia.g
            ga.t r0 = r17.X()
            java.lang.String r7 = "proto.typeTable"
            y8.k.d(r0, r7)
            r10.<init>(r0)
            ia.i$a r0 = ia.i.f10840b
            ga.w r7 = r17.Y()
            java.lang.String r8 = "proto.versionRequirementTable"
            y8.k.d(r7, r8)
            ia.i r11 = r0.a(r7)
            r7 = r21
            r8 = r16
            r9 = r18
            r12 = r19
            r13 = r20
            xa.l r2 = r7.a(r8, r9, r10, r11, r12, r13)
            java.util.List r3 = r17.Q()
            java.lang.String r0 = "proto.functionList"
            y8.k.d(r3, r0)
            java.util.List r4 = r17.T()
            java.lang.String r0 = "proto.propertyList"
            y8.k.d(r4, r0)
            java.util.List r7 = r17.W()
            java.lang.String r0 = "proto.typeAliasList"
            y8.k.d(r7, r0)
            r0 = r15
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f16478g = r14
            la.b r0 = r16.f()
            r6.f16479h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: za.i.<init>(n9.g0, ga.l, ia.c, ia.a, za.f, xa.j, x8.a):void");
    }

    public void A(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        t9.a.b(q().c().o(), bVar, this.f16478g, eVar);
    }

    @Override // za.h, ua.i, ua.k
    public n9.h g(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        A(eVar, bVar);
        return super.g(eVar, bVar);
    }

    @Override // za.h
    protected void j(Collection<n9.m> collection, x8.l<? super la.e, Boolean> lVar) {
        y8.k.e(collection, "result");
        y8.k.e(lVar, "nameFilter");
    }

    @Override // za.h
    protected la.a n(la.e eVar) {
        y8.k.e(eVar, "name");
        return new la.a(this.f16479h, eVar);
    }

    @Override // za.h
    protected Set<la.e> t() {
        Set<la.e> b10;
        b10 = r0.b();
        return b10;
    }

    @Override // za.h
    protected Set<la.e> u() {
        Set<la.e> b10;
        b10 = r0.b();
        return b10;
    }

    @Override // za.h
    protected Set<la.e> v() {
        Set<la.e> b10;
        b10 = r0.b();
        return b10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // za.h
    public boolean x(la.e eVar) {
        boolean z10;
        y8.k.e(eVar, "name");
        if (super.x(eVar)) {
            return true;
        }
        Iterable<o9.b> k10 = q().c().k();
        if (!(k10 instanceof Collection) || !((Collection) k10).isEmpty()) {
            Iterator<o9.b> it = k10.iterator();
            while (it.hasNext()) {
                if (it.next().a(this.f16479h, eVar)) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        return z10;
    }

    @Override // ua.i, ua.k
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public List<n9.m> e(ua.d dVar, x8.l<? super la.e, Boolean> lVar) {
        List<n9.m> a02;
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        Collection<n9.m> k10 = k(dVar, lVar, u9.d.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<o9.b> k11 = q().c().k();
        ArrayList arrayList = new ArrayList();
        Iterator<o9.b> it = k11.iterator();
        while (it.hasNext()) {
            v.r(arrayList, it.next().c(this.f16479h));
        }
        a02 = y.a0(k10, arrayList);
        return a02;
    }
}
