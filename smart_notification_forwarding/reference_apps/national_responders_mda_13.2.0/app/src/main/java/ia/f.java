package ia;

import ga.n;
import ga.q;
import ga.r;
import ga.s;
import ga.u;
import java.util.ArrayList;
import java.util.List;
import y8.k;

/* loaded from: classes.dex */
public final class f {
    public static final q a(q qVar, g gVar) {
        k.e(qVar, "<this>");
        k.e(gVar, "typeTable");
        if (qVar.l0()) {
            return qVar.T();
        }
        if (qVar.m0()) {
            return gVar.a(qVar.U());
        }
        return null;
    }

    public static final q b(r rVar, g gVar) {
        k.e(rVar, "<this>");
        k.e(gVar, "typeTable");
        if (rVar.f0()) {
            q V = rVar.V();
            k.d(V, "expandedType");
            return V;
        }
        if (rVar.g0()) {
            return gVar.a(rVar.W());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final q c(q qVar, g gVar) {
        k.e(qVar, "<this>");
        k.e(gVar, "typeTable");
        if (qVar.q0()) {
            return qVar.d0();
        }
        if (qVar.r0()) {
            return gVar.a(qVar.e0());
        }
        return null;
    }

    public static final boolean d(ga.i iVar) {
        k.e(iVar, "<this>");
        return iVar.p0() || iVar.q0();
    }

    public static final boolean e(n nVar) {
        k.e(nVar, "<this>");
        return nVar.m0() || nVar.n0();
    }

    public static final q f(q qVar, g gVar) {
        k.e(qVar, "<this>");
        k.e(gVar, "typeTable");
        if (qVar.t0()) {
            return qVar.g0();
        }
        if (qVar.u0()) {
            return gVar.a(qVar.h0());
        }
        return null;
    }

    public static final q g(ga.i iVar, g gVar) {
        k.e(iVar, "<this>");
        k.e(gVar, "typeTable");
        if (iVar.p0()) {
            return iVar.Z();
        }
        if (iVar.q0()) {
            return gVar.a(iVar.a0());
        }
        return null;
    }

    public static final q h(n nVar, g gVar) {
        k.e(nVar, "<this>");
        k.e(gVar, "typeTable");
        if (nVar.m0()) {
            return nVar.Y();
        }
        if (nVar.n0()) {
            return gVar.a(nVar.Z());
        }
        return null;
    }

    public static final q i(ga.i iVar, g gVar) {
        k.e(iVar, "<this>");
        k.e(gVar, "typeTable");
        if (iVar.r0()) {
            q b02 = iVar.b0();
            k.d(b02, "returnType");
            return b02;
        }
        if (iVar.s0()) {
            return gVar.a(iVar.c0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final q j(n nVar, g gVar) {
        k.e(nVar, "<this>");
        k.e(gVar, "typeTable");
        if (nVar.o0()) {
            q a02 = nVar.a0();
            k.d(a02, "returnType");
            return a02;
        }
        if (nVar.p0()) {
            return gVar.a(nVar.b0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    public static final List<q> k(ga.c cVar, g gVar) {
        int n10;
        k.e(cVar, "<this>");
        k.e(gVar, "typeTable");
        List<q> B0 = cVar.B0();
        if (!(!B0.isEmpty())) {
            B0 = null;
        }
        if (B0 == null) {
            List<Integer> A0 = cVar.A0();
            k.d(A0, "supertypeIdList");
            n10 = m8.r.n(A0, 10);
            B0 = new ArrayList<>(n10);
            for (Integer num : A0) {
                k.d(num, "it");
                B0.add(gVar.a(num.intValue()));
            }
        }
        return B0;
    }

    public static final q l(q.b bVar, g gVar) {
        k.e(bVar, "<this>");
        k.e(gVar, "typeTable");
        if (bVar.C()) {
            return bVar.z();
        }
        if (bVar.E()) {
            return gVar.a(bVar.A());
        }
        return null;
    }

    public static final q m(u uVar, g gVar) {
        k.e(uVar, "<this>");
        k.e(gVar, "typeTable");
        if (uVar.U()) {
            q O = uVar.O();
            k.d(O, "type");
            return O;
        }
        if (uVar.V()) {
            return gVar.a(uVar.P());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final q n(r rVar, g gVar) {
        k.e(rVar, "<this>");
        k.e(gVar, "typeTable");
        if (rVar.j0()) {
            q c02 = rVar.c0();
            k.d(c02, "underlyingType");
            return c02;
        }
        if (rVar.k0()) {
            return gVar.a(rVar.d0());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<q> o(s sVar, g gVar) {
        int n10;
        k.e(sVar, "<this>");
        k.e(gVar, "typeTable");
        List<q> U = sVar.U();
        if (!(!U.isEmpty())) {
            U = null;
        }
        if (U == null) {
            List<Integer> T = sVar.T();
            k.d(T, "upperBoundIdList");
            n10 = m8.r.n(T, 10);
            U = new ArrayList<>(n10);
            for (Integer num : T) {
                k.d(num, "it");
                U.add(gVar.a(num.intValue()));
            }
        }
        return U;
    }

    public static final q p(u uVar, g gVar) {
        k.e(uVar, "<this>");
        k.e(gVar, "typeTable");
        if (uVar.W()) {
            return uVar.Q();
        }
        if (uVar.X()) {
            return gVar.a(uVar.R());
        }
        return null;
    }
}
