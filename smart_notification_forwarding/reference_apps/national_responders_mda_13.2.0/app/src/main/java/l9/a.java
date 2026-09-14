package l9;

import ab.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import k9.f;
import l9.c;
import m8.o;
import m8.r0;
import mb.r;
import mb.s;
import n9.d0;
import n9.g0;
import y8.k;

/* loaded from: classes.dex */
public final class a implements o9.b {

    /* renamed from: a, reason: collision with root package name */
    private final n f11827a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f11828b;

    public a(n nVar, d0 d0Var) {
        k.e(nVar, "storageManager");
        k.e(d0Var, "module");
        this.f11827a = nVar;
        this.f11828b = d0Var;
    }

    @Override // o9.b
    public boolean a(la.b bVar, la.e eVar) {
        boolean w10;
        boolean w11;
        boolean w12;
        boolean w13;
        k.e(bVar, "packageFqName");
        k.e(eVar, "name");
        String k10 = eVar.k();
        k.d(k10, "name.asString()");
        w10 = r.w(k10, "Function", false, 2, null);
        if (!w10) {
            w11 = r.w(k10, "KFunction", false, 2, null);
            if (!w11) {
                w12 = r.w(k10, "SuspendFunction", false, 2, null);
                if (!w12) {
                    w13 = r.w(k10, "KSuspendFunction", false, 2, null);
                    if (!w13) {
                        return false;
                    }
                }
            }
        }
        return c.Companion.c(k10, bVar) != null;
    }

    @Override // o9.b
    public n9.e b(la.a aVar) {
        boolean A;
        k.e(aVar, "classId");
        if (aVar.k() || aVar.l()) {
            return null;
        }
        String b10 = aVar.i().b();
        k.d(b10, "classId.relativeClassName.asString()");
        A = s.A(b10, "Function", false, 2, null);
        if (!A) {
            return null;
        }
        la.b h10 = aVar.h();
        k.d(h10, "classId.packageFqName");
        c.a.C0247a c10 = c.Companion.c(b10, h10);
        if (c10 == null) {
            return null;
        }
        c a10 = c10.a();
        int b11 = c10.b();
        List<g0> f02 = this.f11828b.C(h10).f0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : f02) {
            if (obj instanceof k9.b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof f) {
                arrayList2.add(obj2);
            }
        }
        g0 g0Var = (f) o.J(arrayList2);
        if (g0Var == null) {
            g0Var = (k9.b) o.H(arrayList);
        }
        return new b(this.f11827a, g0Var, a10, b11);
    }

    @Override // o9.b
    public Collection<n9.e> c(la.b bVar) {
        Set b10;
        k.e(bVar, "packageFqName");
        b10 = r0.b();
        return b10;
    }
}
