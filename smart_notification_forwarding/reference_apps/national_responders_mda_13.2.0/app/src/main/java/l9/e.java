package l9;

import bb.b0;
import bb.h1;
import bb.i0;
import gb.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import m8.d0;
import m8.o;
import m8.q;
import m8.r;
import m8.y;
import n9.a0;
import n9.a1;
import n9.b;
import n9.d1;
import n9.m;
import n9.s0;
import n9.t;
import n9.v0;
import n9.x;
import p9.f0;
import p9.k0;
import p9.p;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class e extends f0 {
    public static final a I = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final d1 b(e eVar, int i10, a1 a1Var) {
            String lowerCase;
            String k10 = a1Var.c().k();
            k.d(k10, "typeParameter.name.asString()");
            if (k.a(k10, "T")) {
                lowerCase = "instance";
            } else if (k.a(k10, "E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = k10.toLowerCase();
                k.d(lowerCase, "(this as java.lang.String).toLowerCase()");
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b10 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
            la.e r10 = la.e.r(lowerCase);
            k.d(r10, "identifier(name)");
            i0 s10 = a1Var.s();
            k.d(s10, "typeParameter.defaultType");
            v0 v0Var = v0.f12324a;
            k.d(v0Var, "NO_SOURCE");
            return new k0(eVar, null, i10, b10, r10, s10, false, false, false, null, v0Var);
        }

        public final e a(b bVar, boolean z10) {
            List<? extends a1> d10;
            Iterable<d0> t02;
            int n10;
            k.e(bVar, "functionClass");
            List<a1> B = bVar.B();
            e eVar = new e(bVar, null, b.a.DECLARATION, z10, null);
            s0 T0 = bVar.T0();
            d10 = q.d();
            ArrayList arrayList = new ArrayList();
            for (Object obj : B) {
                if (!(((a1) obj).v() == h1.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            t02 = y.t0(arrayList);
            n10 = r.n(t02, 10);
            ArrayList arrayList2 = new ArrayList(n10);
            for (d0 d0Var : t02) {
                arrayList2.add(b(eVar, d0Var.c(), (a1) d0Var.d()));
            }
            eVar.c1(null, T0, d10, arrayList2, ((a1) o.S(B)).s(), a0.ABSTRACT, t.f12303e);
            eVar.k1(true);
            return eVar;
        }
    }

    private e(m mVar, e eVar, b.a aVar, boolean z10) {
        super(mVar, eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), j.f10371g, aVar, v0.f12324a);
        q1(true);
        s1(z10);
        j1(false);
    }

    public /* synthetic */ e(m mVar, e eVar, b.a aVar, boolean z10, g gVar) {
        this(mVar, eVar, aVar, z10);
    }

    private final x A1(List<la.e> list) {
        int n10;
        la.e eVar;
        int size = l().size() - list.size();
        boolean z10 = true;
        List<d1> l10 = l();
        k.d(l10, "valueParameters");
        n10 = r.n(l10, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (d1 d1Var : l10) {
            la.e c10 = d1Var.c();
            k.d(c10, "it.name");
            int j10 = d1Var.j();
            int i10 = j10 - size;
            if (i10 >= 0 && (eVar = list.get(i10)) != null) {
                c10 = eVar;
            }
            arrayList.add(d1Var.Q(this, c10, j10));
        }
        p.c d12 = d1(bb.a1.f4159b);
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((la.e) it.next()) == null) {
                    break;
                }
            }
        }
        z10 = false;
        p.c h10 = d12.G(z10).f(arrayList).h(a());
        k.d(h10, "newCopyBuilder(TypeSubstitutor.EMPTY)\n                .setHasSynthesizedParameterNames(parameterNames.any { it == null })\n                .setValueParameters(newValueParameters)\n                .setOriginal(original)");
        x X0 = super.X0(h10);
        k.b(X0);
        return X0;
    }

    @Override // p9.p, n9.z
    public boolean I() {
        return false;
    }

    @Override // p9.f0, p9.p
    protected p W0(m mVar, x xVar, b.a aVar, la.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var) {
        k.e(mVar, "newOwner");
        k.e(aVar, "kind");
        k.e(gVar, "annotations");
        k.e(v0Var, "source");
        return new e(mVar, (e) xVar, aVar, q0());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.p
    public x X0(p.c cVar) {
        int n10;
        k.e(cVar, "configuration");
        e eVar = (e) super.X0(cVar);
        if (eVar == null) {
            return null;
        }
        List<d1> l10 = eVar.l();
        k.d(l10, "substituted.valueParameters");
        boolean z10 = false;
        if (!(l10 instanceof Collection) || !l10.isEmpty()) {
            Iterator<T> it = l10.iterator();
            while (it.hasNext()) {
                b0 b10 = ((d1) it.next()).b();
                k.d(b10, "it.type");
                if (k9.g.c(b10) != null) {
                    break;
                }
            }
        }
        z10 = true;
        if (z10) {
            return eVar;
        }
        List<d1> l11 = eVar.l();
        k.d(l11, "substituted.valueParameters");
        n10 = r.n(l11, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it2 = l11.iterator();
        while (it2.hasNext()) {
            b0 b11 = ((d1) it2.next()).b();
            k.d(b11, "it.type");
            arrayList.add(k9.g.c(b11));
        }
        return eVar.A1(arrayList);
    }

    @Override // p9.p, n9.x
    public boolean s0() {
        return false;
    }

    @Override // p9.p, n9.x
    public boolean x() {
        return false;
    }
}
