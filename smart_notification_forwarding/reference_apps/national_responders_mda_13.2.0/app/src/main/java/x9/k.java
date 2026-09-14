package x9;

import bb.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import l8.n;
import m8.r;
import m8.y;
import n9.d1;
import n9.v0;
import p9.k0;
import pa.v;

/* loaded from: classes.dex */
public final class k {
    public static final List<d1> a(Collection<l> collection, Collection<? extends d1> collection2, n9.a aVar) {
        List<n> u02;
        int n10;
        y8.k.e(collection, "newValueParametersTypes");
        y8.k.e(collection2, "oldValueParameters");
        y8.k.e(aVar, "newOwner");
        collection.size();
        collection2.size();
        u02 = y.u0(collection, collection2);
        n10 = r.n(u02, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (n nVar : u02) {
            l lVar = (l) nVar.a();
            d1 d1Var = (d1) nVar.b();
            int j10 = d1Var.j();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = d1Var.u();
            la.e c10 = d1Var.c();
            y8.k.d(c10, "oldParameter.name");
            b0 b10 = lVar.b();
            boolean a10 = lVar.a();
            boolean E = d1Var.E();
            boolean G0 = d1Var.G0();
            b0 k10 = d1Var.R() != null ? ra.a.l(aVar).w().k(lVar.b()) : null;
            v0 k11 = d1Var.k();
            y8.k.d(k11, "oldParameter.source");
            arrayList.add(new k0(aVar, null, j10, u10, c10, b10, a10, E, G0, k10, k11));
        }
        return arrayList;
    }

    public static final a b(d1 d1Var) {
        pa.g<?> b10;
        v vVar;
        String b11;
        y8.k.e(d1Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = d1Var.u();
        la.b bVar = v9.y.f14830r;
        y8.k.d(bVar, "DEFAULT_VALUE_FQ_NAME");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e10 = u10.e(bVar);
        if (e10 == null || (b10 = ra.a.b(e10)) == null) {
            vVar = null;
        } else {
            if (!(b10 instanceof v)) {
                b10 = null;
            }
            vVar = (v) b10;
        }
        if (vVar != null && (b11 = vVar.b()) != null) {
            return new j(b11);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u11 = d1Var.u();
        la.b bVar2 = v9.y.f14831s;
        y8.k.d(bVar2, "DEFAULT_NULL_FQ_NAME");
        if (u11.r(bVar2)) {
            return h.f15539a;
        }
        return null;
    }

    public static final z9.k c(n9.e eVar) {
        y8.k.e(eVar, "<this>");
        n9.e p10 = ra.a.p(eVar);
        if (p10 == null) {
            return null;
        }
        ua.h x02 = p10.x0();
        z9.k kVar = x02 instanceof z9.k ? (z9.k) x02 : null;
        return kVar == null ? c(p10) : kVar;
    }
}
