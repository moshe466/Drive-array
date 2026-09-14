package db;

import java.util.Collection;
import java.util.List;
import y8.w;

/* loaded from: classes.dex */
public interface n extends q {

    /* loaded from: classes.dex */
    public static final class a {
        public static List<i> a(n nVar, i iVar, l lVar) {
            y8.k.e(nVar, "this");
            y8.k.e(iVar, "receiver");
            y8.k.e(lVar, "constructor");
            return null;
        }

        public static k b(n nVar, j jVar, int i10) {
            y8.k.e(nVar, "this");
            y8.k.e(jVar, "receiver");
            if (jVar instanceof i) {
                return nVar.f((h) jVar, i10);
            }
            if (jVar instanceof db.a) {
                k kVar = ((db.a) jVar).get(i10);
                y8.k.d(kVar, "get(index)");
                return kVar;
            }
            throw new IllegalStateException(("unknown type argument list type: " + jVar + ", " + w.b(jVar.getClass())).toString());
        }

        public static k c(n nVar, i iVar, int i10) {
            y8.k.e(nVar, "this");
            y8.k.e(iVar, "receiver");
            boolean z10 = false;
            if (i10 >= 0 && i10 < nVar.y(iVar)) {
                z10 = true;
            }
            if (z10) {
                return nVar.f(iVar, i10);
            }
            return null;
        }

        public static boolean d(n nVar, h hVar) {
            y8.k.e(nVar, "this");
            y8.k.e(hVar, "receiver");
            return nVar.m(nVar.C(hVar)) != nVar.m(nVar.i(hVar));
        }

        public static boolean e(n nVar, i iVar) {
            y8.k.e(nVar, "this");
            y8.k.e(iVar, "receiver");
            return nVar.h(nVar.a(iVar));
        }

        public static boolean f(n nVar, h hVar) {
            y8.k.e(nVar, "this");
            y8.k.e(hVar, "receiver");
            i b10 = nVar.b(hVar);
            return (b10 == null ? null : nVar.L(b10)) != null;
        }

        public static boolean g(n nVar, h hVar) {
            y8.k.e(nVar, "this");
            y8.k.e(hVar, "receiver");
            f R = nVar.R(hVar);
            return (R == null ? null : nVar.n(R)) != null;
        }

        public static boolean h(n nVar, i iVar) {
            y8.k.e(nVar, "this");
            y8.k.e(iVar, "receiver");
            return nVar.E(nVar.a(iVar));
        }

        public static boolean i(n nVar, h hVar) {
            y8.k.e(nVar, "this");
            y8.k.e(hVar, "receiver");
            return (hVar instanceof i) && nVar.m((i) hVar);
        }

        public static boolean j(n nVar, h hVar) {
            y8.k.e(nVar, "this");
            y8.k.e(hVar, "receiver");
            return nVar.I(nVar.J(hVar)) && !nVar.M(hVar);
        }

        public static i k(n nVar, h hVar) {
            y8.k.e(nVar, "this");
            y8.k.e(hVar, "receiver");
            f R = nVar.R(hVar);
            if (R != null) {
                return nVar.c(R);
            }
            i b10 = nVar.b(hVar);
            y8.k.b(b10);
            return b10;
        }

        public static int l(n nVar, j jVar) {
            y8.k.e(nVar, "this");
            y8.k.e(jVar, "receiver");
            if (jVar instanceof i) {
                return nVar.y((h) jVar);
            }
            if (jVar instanceof db.a) {
                return ((db.a) jVar).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + jVar + ", " + w.b(jVar.getClass())).toString());
        }

        public static l m(n nVar, h hVar) {
            y8.k.e(nVar, "this");
            y8.k.e(hVar, "receiver");
            i b10 = nVar.b(hVar);
            if (b10 == null) {
                b10 = nVar.C(hVar);
            }
            return nVar.a(b10);
        }

        public static i n(n nVar, h hVar) {
            y8.k.e(nVar, "this");
            y8.k.e(hVar, "receiver");
            f R = nVar.R(hVar);
            if (R != null) {
                return nVar.e(R);
            }
            i b10 = nVar.b(hVar);
            y8.k.b(b10);
            return b10;
        }
    }

    j A(i iVar);

    Collection<h> B(i iVar);

    i C(h hVar);

    int D(l lVar);

    boolean E(l lVar);

    i F(d dVar);

    h G(c cVar);

    boolean H(i iVar);

    boolean I(l lVar);

    l J(h hVar);

    d L(i iVar);

    boolean M(h hVar);

    r Q(m mVar);

    f R(h hVar);

    i S(i iVar, b bVar);

    Collection<h> T(l lVar);

    boolean U(c cVar);

    boolean V(h hVar);

    boolean W(l lVar, l lVar2);

    h X(List<? extends h> list);

    boolean Y(l lVar);

    l a(i iVar);

    boolean a0(l lVar);

    i b(h hVar);

    i c(f fVar);

    k c0(j jVar, int i10);

    i d(i iVar, boolean z10);

    i e(f fVar);

    k f(h hVar, int i10);

    boolean f0(i iVar);

    h g(k kVar);

    boolean g0(l lVar);

    boolean h(l lVar);

    boolean h0(i iVar);

    i i(h hVar);

    c j(i iVar);

    boolean k(h hVar);

    int l(j jVar);

    boolean m(i iVar);

    e n(f fVar);

    r o(k kVar);

    h q(h hVar);

    m r(l lVar, int i10);

    boolean u(l lVar);

    k v(h hVar);

    boolean x(k kVar);

    int y(h hVar);

    h z(h hVar, boolean z10);
}
