package v9;

import ea.j;
import java.util.List;
import n9.d1;
import na.e;

/* loaded from: classes.dex */
public final class v implements na.e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14809a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        private final boolean b(n9.x xVar) {
            if (xVar.l().size() != 1) {
                return false;
            }
            n9.m d10 = xVar.d();
            n9.e eVar = d10 instanceof n9.e ? (n9.e) d10 : null;
            if (eVar == null) {
                return false;
            }
            List<d1> l10 = xVar.l();
            y8.k.d(l10, "f.valueParameters");
            n9.h o10 = ((d1) m8.o.d0(l10)).b().W0().o();
            n9.e eVar2 = o10 instanceof n9.e ? (n9.e) o10 : null;
            return eVar2 != null && k9.h.x0(eVar) && y8.k.a(ra.a.i(eVar), ra.a.i(eVar2));
        }

        private final ea.j c(n9.x xVar, d1 d1Var) {
            bb.b0 k10;
            if (ea.t.e(xVar) || b(xVar)) {
                bb.b0 b10 = d1Var.b();
                y8.k.d(b10, "valueParameterDescriptor.type");
                k10 = eb.a.k(b10);
            } else {
                k10 = d1Var.b();
                y8.k.d(k10, "valueParameterDescriptor.type");
            }
            return ea.t.g(k10);
        }

        public final boolean a(n9.a aVar, n9.a aVar2) {
            List<l8.n> u02;
            y8.k.e(aVar, "superDescriptor");
            y8.k.e(aVar2, "subDescriptor");
            if ((aVar2 instanceof x9.f) && (aVar instanceof n9.x)) {
                x9.f fVar = (x9.f) aVar2;
                fVar.l().size();
                n9.x xVar = (n9.x) aVar;
                xVar.l().size();
                List<d1> l10 = fVar.a().l();
                y8.k.d(l10, "subDescriptor.original.valueParameters");
                List<d1> l11 = xVar.a().l();
                y8.k.d(l11, "superDescriptor.original.valueParameters");
                u02 = m8.y.u0(l10, l11);
                for (l8.n nVar : u02) {
                    d1 d1Var = (d1) nVar.a();
                    d1 d1Var2 = (d1) nVar.b();
                    y8.k.d(d1Var, "subParameter");
                    boolean z10 = c((n9.x) aVar2, d1Var) instanceof j.d;
                    y8.k.d(d1Var2, "superParameter");
                    if (z10 != (c(xVar, d1Var2) instanceof j.d)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private final boolean c(n9.a aVar, n9.a aVar2, n9.e eVar) {
        if ((aVar instanceof n9.b) && (aVar2 instanceof n9.x) && !k9.h.e0(aVar2)) {
            f fVar = f.f14781m;
            n9.x xVar = (n9.x) aVar2;
            la.e c10 = xVar.c();
            y8.k.d(c10, "subDescriptor.name");
            if (!fVar.l(c10)) {
                e eVar2 = e.f14779m;
                la.e c11 = xVar.c();
                y8.k.d(c11, "subDescriptor.name");
                if (!eVar2.k(c11)) {
                    return false;
                }
            }
            n9.b e10 = b0.e((n9.b) aVar);
            Boolean valueOf = Boolean.valueOf(xVar.p0());
            boolean z10 = aVar instanceof n9.x;
            if ((!y8.k.a(valueOf, (z10 ? (n9.x) aVar : null) == null ? null : Boolean.valueOf(r5.p0()))) && (e10 == null || !xVar.p0())) {
                return true;
            }
            if ((eVar instanceof x9.d) && xVar.H() == null && e10 != null && !b0.f(eVar, e10)) {
                if ((e10 instanceof n9.x) && z10 && f.k((n9.x) e10) != null) {
                    String c12 = ea.t.c(xVar, false, false, 2, null);
                    n9.x a10 = ((n9.x) aVar).a();
                    y8.k.d(a10, "superDescriptor.original");
                    if (y8.k.a(c12, ea.t.c(a10, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // na.e
    public e.b a(n9.a aVar, n9.a aVar2, n9.e eVar) {
        y8.k.e(aVar, "superDescriptor");
        y8.k.e(aVar2, "subDescriptor");
        if (!c(aVar, aVar2, eVar) && !f14809a.a(aVar, aVar2)) {
            return e.b.UNKNOWN;
        }
        return e.b.INCOMPATIBLE;
    }

    @Override // na.e
    public e.a b() {
        return e.a.CONFLICTS_ONLY;
    }
}
