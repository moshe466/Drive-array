package k9;

import bb.b0;
import bb.c1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import l8.t;
import m8.l0;
import m8.y;
import n9.g0;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f11295a = new o();

    /* renamed from: b, reason: collision with root package name */
    private static final Set<la.e> f11296b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<la.a, la.a> f11297c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<la.a, la.a> f11298d;

    /* renamed from: e, reason: collision with root package name */
    private static final Set<la.e> f11299e;

    static {
        Set<la.e> r02;
        n[] values = n.values();
        ArrayList arrayList = new ArrayList(values.length);
        int i10 = 0;
        for (n nVar : values) {
            arrayList.add(nVar.getTypeName());
        }
        r02 = y.r0(arrayList);
        f11296b = r02;
        m[] values2 = m.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (m mVar : values2) {
            arrayList2.add(mVar.getTypeName());
        }
        y.r0(arrayList2);
        f11297c = new HashMap<>();
        f11298d = new HashMap<>();
        l0.j(t.a(m.UBYTEARRAY, la.e.r("ubyteArrayOf")), t.a(m.USHORTARRAY, la.e.r("ushortArrayOf")), t.a(m.UINTARRAY, la.e.r("uintArrayOf")), t.a(m.ULONGARRAY, la.e.r("ulongArrayOf")));
        n[] values3 = n.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (n nVar2 : values3) {
            linkedHashSet.add(nVar2.getArrayClassId().j());
        }
        f11299e = linkedHashSet;
        n[] values4 = n.values();
        int length = values4.length;
        while (i10 < length) {
            n nVar3 = values4[i10];
            i10++;
            f11297c.put(nVar3.getArrayClassId(), nVar3.getClassId());
            f11298d.put(nVar3.getClassId(), nVar3.getArrayClassId());
        }
    }

    private o() {
    }

    public static final boolean d(b0 b0Var) {
        n9.h o10;
        y8.k.e(b0Var, "type");
        if (c1.v(b0Var) || (o10 = b0Var.W0().o()) == null) {
            return false;
        }
        return f11295a.c(o10);
    }

    public final la.a a(la.a aVar) {
        y8.k.e(aVar, "arrayClassId");
        return f11297c.get(aVar);
    }

    public final boolean b(la.e eVar) {
        y8.k.e(eVar, "name");
        return f11299e.contains(eVar);
    }

    public final boolean c(n9.m mVar) {
        y8.k.e(mVar, "descriptor");
        n9.m d10 = mVar.d();
        return (d10 instanceof g0) && y8.k.a(((g0) d10).f(), k.f11246l) && f11296b.contains(mVar.c());
    }
}
