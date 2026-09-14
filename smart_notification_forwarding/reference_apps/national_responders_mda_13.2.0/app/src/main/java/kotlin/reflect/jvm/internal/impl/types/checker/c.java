package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.a0;
import bb.b1;
import bb.c0;
import bb.c1;
import bb.d0;
import bb.g1;
import bb.h1;
import bb.i0;
import bb.t0;
import bb.v0;
import db.p;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import k9.k;
import n9.a1;
import n9.b0;
import n9.z0;

/* loaded from: classes.dex */
public interface c extends b1, db.p {

    /* loaded from: classes.dex */
    public static final class a {
        public static boolean A(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                return k9.h.D0((t0) lVar, k.a.f11253b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static boolean B(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                return ((t0) lVar).o() instanceof n9.e;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static boolean C(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                n9.h o10 = ((t0) lVar).o();
                n9.e eVar = o10 instanceof n9.e ? (n9.e) o10 : null;
                return (eVar == null || !b0.a(eVar) || eVar.r() == n9.f.ENUM_ENTRY || eVar.r() == n9.f.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static boolean D(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                return ((t0) lVar).z();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static boolean E(c cVar, db.h hVar) {
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            if (hVar instanceof bb.b0) {
                return d0.a((bb.b0) hVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + y8.w.b(hVar.getClass())).toString());
        }

        public static boolean F(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                n9.h o10 = ((t0) lVar).o();
                n9.e eVar = o10 instanceof n9.e ? (n9.e) o10 : null;
                return y8.k.a(eVar != null ? Boolean.valueOf(na.f.b(eVar)) : null, Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static boolean G(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                return lVar instanceof pa.n;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static boolean H(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                return lVar instanceof a0;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static boolean I(c cVar, db.h hVar) {
            return p.a.b(cVar, hVar);
        }

        public static boolean J(c cVar, db.i iVar) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "receiver");
            if (iVar instanceof i0) {
                return ((i0) iVar).X0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
        }

        public static boolean K(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                return k9.h.D0((t0) lVar, k.a.f11255c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static boolean L(c cVar, db.h hVar) {
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            if (hVar instanceof bb.b0) {
                return c1.l((bb.b0) hVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + y8.w.b(hVar.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean M(c cVar, db.i iVar) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "receiver");
            if (iVar instanceof bb.b0) {
                return k9.h.y0((bb.b0) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
        }

        public static boolean N(c cVar, db.c cVar2) {
            y8.k.e(cVar, "this");
            y8.k.e(cVar2, "receiver");
            if (cVar2 instanceof i) {
                return ((i) cVar2).i1();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar2 + ", " + y8.w.b(cVar2.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean O(c cVar, db.i iVar) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "receiver");
            if (!(iVar instanceof i0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
            }
            if (!d0.a((bb.b0) iVar)) {
                i0 i0Var = (i0) iVar;
                if (!(i0Var.W0().o() instanceof z0) && (i0Var.W0().o() != null || (iVar instanceof oa.a) || (iVar instanceof i) || (iVar instanceof bb.k) || (i0Var.W0() instanceof pa.n))) {
                    return true;
                }
            }
            return false;
        }

        public static boolean P(c cVar, db.k kVar) {
            y8.k.e(cVar, "this");
            y8.k.e(kVar, "receiver");
            if (kVar instanceof v0) {
                return ((v0) kVar).d();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + y8.w.b(kVar.getClass())).toString());
        }

        public static boolean Q(c cVar, db.i iVar) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "receiver");
            if (iVar instanceof i0) {
                return false;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
        }

        public static boolean R(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                n9.h o10 = ((t0) lVar).o();
                return y8.k.a(o10 == null ? null : Boolean.valueOf(k9.h.I0(o10)), Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static db.i S(c cVar, db.f fVar) {
            y8.k.e(cVar, "this");
            y8.k.e(fVar, "receiver");
            if (fVar instanceof bb.v) {
                return ((bb.v) fVar).e1();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + fVar + ", " + y8.w.b(fVar.getClass())).toString());
        }

        public static db.i T(c cVar, db.h hVar) {
            return p.a.c(cVar, hVar);
        }

        public static db.h U(c cVar, db.c cVar2) {
            y8.k.e(cVar, "this");
            y8.k.e(cVar2, "receiver");
            if (cVar2 instanceof i) {
                return ((i) cVar2).h1();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar2 + ", " + y8.w.b(cVar2.getClass())).toString());
        }

        public static db.h V(c cVar, db.h hVar) {
            g1 b10;
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            if (hVar instanceof g1) {
                b10 = d.b((g1) hVar);
                return b10;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + y8.w.b(hVar.getClass())).toString());
        }

        public static db.h W(c cVar, db.h hVar) {
            return b1.a.a(cVar, hVar);
        }

        public static bb.f X(c cVar, boolean z10, boolean z11) {
            y8.k.e(cVar, "this");
            return new kotlin.reflect.jvm.internal.impl.types.checker.a(z10, z11, false, null, 12, null);
        }

        public static db.i Y(c cVar, db.d dVar) {
            y8.k.e(cVar, "this");
            y8.k.e(dVar, "receiver");
            if (dVar instanceof bb.k) {
                return ((bb.k) dVar).i1();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + y8.w.b(dVar.getClass())).toString());
        }

        public static int Z(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                return ((t0) lVar).B().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static boolean a(c cVar, db.l lVar, db.l lVar2) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "c1");
            y8.k.e(lVar2, "c2");
            if (!(lVar instanceof t0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
            }
            if (lVar2 instanceof t0) {
                return y8.k.a(lVar, lVar2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar2 + ", " + y8.w.b(lVar2.getClass())).toString());
        }

        public static Collection<db.h> a0(c cVar, db.i iVar) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "receiver");
            db.l a10 = cVar.a(iVar);
            if (a10 instanceof pa.n) {
                return ((pa.n) a10).g();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
        }

        public static int b(c cVar, db.h hVar) {
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            if (hVar instanceof bb.b0) {
                return ((bb.b0) hVar).V0().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + y8.w.b(hVar.getClass())).toString());
        }

        public static int b0(c cVar, db.j jVar) {
            return p.a.d(cVar, jVar);
        }

        public static db.j c(c cVar, db.i iVar) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "receiver");
            if (iVar instanceof i0) {
                return (db.j) iVar;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
        }

        public static Collection<db.h> c0(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                Collection<bb.b0> x10 = ((t0) lVar).x();
                y8.k.d(x10, "this.supertypes");
                return x10;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static db.c d(c cVar, db.i iVar) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "receiver");
            if (iVar instanceof i0) {
                if (iVar instanceof i) {
                    return (i) iVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
        }

        public static db.l d0(c cVar, db.h hVar) {
            return p.a.e(cVar, hVar);
        }

        public static db.d e(c cVar, db.i iVar) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "receiver");
            if (iVar instanceof i0) {
                if (iVar instanceof bb.k) {
                    return (bb.k) iVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
        }

        public static db.l e0(c cVar, db.i iVar) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "receiver");
            if (iVar instanceof i0) {
                return ((i0) iVar).W0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
        }

        public static db.e f(c cVar, db.f fVar) {
            y8.k.e(cVar, "this");
            y8.k.e(fVar, "receiver");
            if (fVar instanceof bb.v) {
                if (fVar instanceof bb.q) {
                    return (bb.q) fVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + fVar + ", " + y8.w.b(fVar.getClass())).toString());
        }

        public static db.i f0(c cVar, db.f fVar) {
            y8.k.e(cVar, "this");
            y8.k.e(fVar, "receiver");
            if (fVar instanceof bb.v) {
                return ((bb.v) fVar).f1();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + fVar + ", " + y8.w.b(fVar.getClass())).toString());
        }

        public static db.f g(c cVar, db.h hVar) {
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            if (hVar instanceof bb.b0) {
                g1 Z0 = ((bb.b0) hVar).Z0();
                if (Z0 instanceof bb.v) {
                    return (bb.v) Z0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + y8.w.b(hVar.getClass())).toString());
        }

        public static db.i g0(c cVar, db.h hVar) {
            return p.a.f(cVar, hVar);
        }

        public static db.i h(c cVar, db.h hVar) {
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            if (hVar instanceof bb.b0) {
                g1 Z0 = ((bb.b0) hVar).Z0();
                if (Z0 instanceof i0) {
                    return (i0) Z0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + y8.w.b(hVar.getClass())).toString());
        }

        public static db.h h0(c cVar, db.h hVar, boolean z10) {
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            if (hVar instanceof db.i) {
                return cVar.d((db.i) hVar, z10);
            }
            if (!(hVar instanceof db.f)) {
                throw new IllegalStateException("sealed".toString());
            }
            db.f fVar = (db.f) hVar;
            return cVar.s(cVar.d(cVar.c(fVar), z10), cVar.d(cVar.e(fVar), z10));
        }

        public static db.k i(c cVar, db.h hVar) {
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            if (hVar instanceof bb.b0) {
                return eb.a.a((bb.b0) hVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + y8.w.b(hVar.getClass())).toString());
        }

        public static db.i i0(c cVar, db.i iVar, boolean z10) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "receiver");
            if (iVar instanceof i0) {
                return ((i0) iVar).a1(z10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
        }

        public static db.i j(c cVar, db.i iVar, db.b bVar) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "type");
            y8.k.e(bVar, "status");
            if (iVar instanceof i0) {
                return k.b((i0) iVar, bVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
        }

        public static db.h k(c cVar, db.i iVar, db.i iVar2) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "lowerBound");
            y8.k.e(iVar2, "upperBound");
            if (!(iVar instanceof i0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar + ", " + y8.w.b(cVar.getClass())).toString());
            }
            if (iVar2 instanceof i0) {
                c0 c0Var = c0.f4165a;
                return c0.d((i0) iVar, (i0) iVar2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar + ", " + y8.w.b(cVar.getClass())).toString());
        }

        public static db.k l(c cVar, db.j jVar, int i10) {
            return p.a.a(cVar, jVar, i10);
        }

        public static db.k m(c cVar, db.h hVar, int i10) {
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            if (hVar instanceof bb.b0) {
                return ((bb.b0) hVar).V0().get(i10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + y8.w.b(hVar.getClass())).toString());
        }

        public static la.c n(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                n9.h o10 = ((t0) lVar).o();
                Objects.requireNonNull(o10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return ra.a.j((n9.e) o10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static db.m o(c cVar, db.l lVar, int i10) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                a1 a1Var = ((t0) lVar).B().get(i10);
                y8.k.d(a1Var, "this.parameters[index]");
                return a1Var;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static k9.i p(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                n9.h o10 = ((t0) lVar).o();
                Objects.requireNonNull(o10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return k9.h.O((n9.e) o10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static k9.i q(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                n9.h o10 = ((t0) lVar).o();
                Objects.requireNonNull(o10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return k9.h.R((n9.e) o10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static db.h r(c cVar, db.m mVar) {
            y8.k.e(cVar, "this");
            y8.k.e(mVar, "receiver");
            if (mVar instanceof a1) {
                return eb.a.f((a1) mVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + y8.w.b(mVar.getClass())).toString());
        }

        public static db.h s(c cVar, db.h hVar) {
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            if (hVar instanceof bb.b0) {
                return na.f.e((bb.b0) hVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + y8.w.b(hVar.getClass())).toString());
        }

        public static db.h t(c cVar, db.k kVar) {
            y8.k.e(cVar, "this");
            y8.k.e(kVar, "receiver");
            if (kVar instanceof v0) {
                return ((v0) kVar).b().Z0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + y8.w.b(kVar.getClass())).toString());
        }

        public static db.m u(c cVar, db.l lVar) {
            y8.k.e(cVar, "this");
            y8.k.e(lVar, "receiver");
            if (lVar instanceof t0) {
                n9.h o10 = ((t0) lVar).o();
                if (o10 instanceof a1) {
                    return (a1) o10;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + y8.w.b(lVar.getClass())).toString());
        }

        public static db.r v(c cVar, db.k kVar) {
            y8.k.e(cVar, "this");
            y8.k.e(kVar, "receiver");
            if (kVar instanceof v0) {
                h1 c10 = ((v0) kVar).c();
                y8.k.d(c10, "this.projectionKind");
                return db.o.a(c10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kVar + ", " + y8.w.b(kVar.getClass())).toString());
        }

        public static db.r w(c cVar, db.m mVar) {
            y8.k.e(cVar, "this");
            y8.k.e(mVar, "receiver");
            if (mVar instanceof a1) {
                h1 v10 = ((a1) mVar).v();
                y8.k.d(v10, "this.variance");
                return db.o.a(v10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + y8.w.b(mVar.getClass())).toString());
        }

        public static boolean x(c cVar, db.h hVar, la.b bVar) {
            y8.k.e(cVar, "this");
            y8.k.e(hVar, "receiver");
            y8.k.e(bVar, "fqName");
            if (hVar instanceof bb.b0) {
                return ((bb.b0) hVar).u().r(bVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + hVar + ", " + y8.w.b(hVar.getClass())).toString());
        }

        public static boolean y(c cVar, db.i iVar, db.i iVar2) {
            y8.k.e(cVar, "this");
            y8.k.e(iVar, "a");
            y8.k.e(iVar2, "b");
            if (!(iVar instanceof i0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + y8.w.b(iVar.getClass())).toString());
            }
            if (iVar2 instanceof i0) {
                return ((i0) iVar).V0() == ((i0) iVar2).V0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar2 + ", " + y8.w.b(iVar2.getClass())).toString());
        }

        public static db.h z(c cVar, List<? extends db.h> list) {
            y8.k.e(cVar, "this");
            y8.k.e(list, "types");
            return e.a(list);
        }
    }

    db.l a(db.i iVar);

    db.i b(db.h hVar);

    db.i c(db.f fVar);

    db.i d(db.i iVar, boolean z10);

    db.i e(db.f fVar);

    db.h s(db.i iVar, db.i iVar2);
}
