package v9;

import java.util.Iterator;
import java.util.List;
import n9.a1;
import n9.d1;
import n9.s0;
import n9.u0;
import n9.x;
import na.e;
import na.j;

/* loaded from: classes.dex */
public final class n implements na.e {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14794a;

        static {
            int[] iArr = new int[j.i.a.values().length];
            iArr[j.i.a.OVERRIDABLE.ordinal()] = 1;
            f14794a = iArr;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.l<d1, bb.b0> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f14795f = new b();

        b() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final bb.b0 h(d1 d1Var) {
            return d1Var.b();
        }
    }

    @Override // na.e
    public e.b a(n9.a aVar, n9.a aVar2, n9.e eVar) {
        lb.h A;
        lb.h q10;
        lb.h t10;
        List h10;
        lb.h s10;
        boolean z10;
        u0 e10;
        List<a1> d10;
        y8.k.e(aVar, "superDescriptor");
        y8.k.e(aVar2, "subDescriptor");
        if (aVar2 instanceof x9.f) {
            x9.f fVar = (x9.f) aVar2;
            y8.k.d(fVar.m(), "subDescriptor.typeParameters");
            if (!(!r0.isEmpty())) {
                j.i z11 = na.j.z(aVar, aVar2);
                if ((z11 == null ? null : z11.c()) != null) {
                    return e.b.UNKNOWN;
                }
                List<d1> l10 = fVar.l();
                y8.k.d(l10, "subDescriptor.valueParameters");
                A = m8.y.A(l10);
                q10 = lb.n.q(A, b.f14795f);
                bb.b0 i10 = fVar.i();
                y8.k.b(i10);
                t10 = lb.n.t(q10, i10);
                s0 U = fVar.U();
                h10 = m8.q.h(U != null ? U.b() : null);
                s10 = lb.n.s(t10, h10);
                Iterator it = s10.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z10 = false;
                        break;
                    }
                    bb.b0 b0Var = (bb.b0) it.next();
                    if ((b0Var.V0().isEmpty() ^ true) && !(b0Var.Z0() instanceof aa.f)) {
                        z10 = true;
                        break;
                    }
                }
                if (!z10 && (e10 = aVar.e(aa.e.f345b.c())) != null) {
                    if (e10 instanceof u0) {
                        u0 u0Var = (u0) e10;
                        y8.k.d(u0Var.m(), "erasedSuper.typeParameters");
                        if (!r0.isEmpty()) {
                            x.a<? extends u0> y10 = u0Var.y();
                            d10 = m8.q.d();
                            e10 = y10.g(d10).c();
                            y8.k.b(e10);
                        }
                    }
                    j.i.a c10 = na.j.f12341d.I(e10, aVar2, false).c();
                    y8.k.d(c10, "DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).result");
                    return a.f14794a[c10.ordinal()] == 1 ? e.b.OVERRIDABLE : e.b.UNKNOWN;
                }
                return e.b.UNKNOWN;
            }
        }
        return e.b.UNKNOWN;
    }

    @Override // na.e
    public e.a b() {
        return e.a.SUCCESS_ONLY;
    }
}
