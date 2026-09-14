package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.a1;
import bb.b0;
import bb.f;
import bb.g1;
import bb.h1;
import bb.i0;
import bb.t0;
import bb.u0;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.checker.g;

/* loaded from: classes.dex */
public class a extends bb.f implements c {

    /* renamed from: i, reason: collision with root package name */
    public static final C0240a f11558i = new C0240a(null);

    /* renamed from: e, reason: collision with root package name */
    private final boolean f11559e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f11560f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f11561g;

    /* renamed from: h, reason: collision with root package name */
    private final g f11562h;

    /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0240a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0241a extends f.b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f11563a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a1 f11564b;

            C0241a(c cVar, a1 a1Var) {
                this.f11563a = cVar;
                this.f11564b = a1Var;
            }

            @Override // bb.f.b
            public db.i a(bb.f fVar, db.h hVar) {
                y8.k.e(fVar, "context");
                y8.k.e(hVar, "type");
                c cVar = this.f11563a;
                b0 n10 = this.f11564b.n((b0) cVar.C(hVar), h1.INVARIANT);
                y8.k.d(n10, "substitutor.safeSubstitute(\n                        type.lowerBoundIfFlexible() as KotlinType,\n                        Variance.INVARIANT\n                    )");
                db.i b10 = cVar.b(n10);
                y8.k.b(b10);
                return b10;
            }
        }

        private C0240a() {
        }

        public /* synthetic */ C0240a(y8.g gVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final f.b.a a(c cVar, db.i iVar) {
            String b10;
            y8.k.e(cVar, "<this>");
            y8.k.e(iVar, "type");
            if (iVar instanceof i0) {
                return new C0241a(cVar, u0.f4270b.a((b0) iVar).c());
            }
            b10 = b.b(iVar);
            throw new IllegalArgumentException(b10.toString());
        }
    }

    public a(boolean z10, boolean z11, boolean z12, g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        this.f11559e = z10;
        this.f11560f = z11;
        this.f11561g = z12;
        this.f11562h = gVar;
    }

    public /* synthetic */ a(boolean z10, boolean z11, boolean z12, g gVar, int i10, y8.g gVar2) {
        this(z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? true : z12, (i10 & 8) != 0 ? g.a.f11566a : gVar);
    }

    @Override // db.n
    public db.j A(db.i iVar) {
        return c.a.c(this, iVar);
    }

    @Override // db.n
    public Collection<db.h> B(db.i iVar) {
        return c.a.a0(this, iVar);
    }

    @Override // bb.f
    public boolean C0() {
        return this.f11560f;
    }

    @Override // db.n
    public int D(db.l lVar) {
        return c.a.Z(this, lVar);
    }

    @Override // bb.f
    public db.h D0(db.h hVar) {
        String b10;
        y8.k.e(hVar, "type");
        if (hVar instanceof b0) {
            return l.f11584b.a().h(((b0) hVar).Z0());
        }
        b10 = b.b(hVar);
        throw new IllegalArgumentException(b10.toString());
    }

    @Override // db.n
    public boolean E(db.l lVar) {
        return c.a.G(this, lVar);
    }

    @Override // bb.f
    public db.h E0(db.h hVar) {
        String b10;
        y8.k.e(hVar, "type");
        if (hVar instanceof b0) {
            return this.f11562h.g((b0) hVar);
        }
        b10 = b.b(hVar);
        throw new IllegalArgumentException(b10.toString());
    }

    @Override // db.n
    public db.i F(db.d dVar) {
        return c.a.Y(this, dVar);
    }

    @Override // db.n
    public db.h G(db.c cVar) {
        return c.a.U(this, cVar);
    }

    public boolean G0(t0 t0Var, t0 t0Var2) {
        y8.k.e(t0Var, "a");
        y8.k.e(t0Var2, "b");
        return t0Var instanceof pa.n ? ((pa.n) t0Var).f(t0Var2) : t0Var2 instanceof pa.n ? ((pa.n) t0Var2).f(t0Var) : y8.k.a(t0Var, t0Var2);
    }

    @Override // db.n
    public boolean H(db.i iVar) {
        return c.a.Q(this, iVar);
    }

    @Override // bb.f
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public f.b.a F0(db.i iVar) {
        y8.k.e(iVar, "type");
        return f11558i.a(this, iVar);
    }

    @Override // db.n
    public boolean I(db.l lVar) {
        return c.a.K(this, lVar);
    }

    @Override // bb.b1
    public db.h K(db.m mVar) {
        return c.a.r(this, mVar);
    }

    @Override // db.n
    public db.d L(db.i iVar) {
        return c.a.e(this, iVar);
    }

    @Override // db.n
    public boolean M(db.h hVar) {
        return c.a.L(this, hVar);
    }

    @Override // bb.b1
    public k9.i N(db.l lVar) {
        return c.a.q(this, lVar);
    }

    @Override // bb.b1
    public la.c O(db.l lVar) {
        return c.a.n(this, lVar);
    }

    @Override // bb.b1
    public db.m P(db.l lVar) {
        return c.a.u(this, lVar);
    }

    @Override // db.n
    public db.r Q(db.m mVar) {
        return c.a.w(this, mVar);
    }

    @Override // db.n
    public db.f R(db.h hVar) {
        return c.a.g(this, hVar);
    }

    @Override // db.n
    public db.i S(db.i iVar, db.b bVar) {
        return c.a.j(this, iVar, bVar);
    }

    @Override // db.n
    public Collection<db.h> T(db.l lVar) {
        return c.a.c0(this, lVar);
    }

    @Override // db.n
    public boolean U(db.c cVar) {
        return c.a.N(this, cVar);
    }

    @Override // db.n
    public boolean W(db.l lVar, db.l lVar2) {
        String b10;
        String b11;
        y8.k.e(lVar, "c1");
        y8.k.e(lVar2, "c2");
        if (!(lVar instanceof t0)) {
            b10 = b.b(lVar);
            throw new IllegalArgumentException(b10.toString());
        }
        if (lVar2 instanceof t0) {
            return G0((t0) lVar, (t0) lVar2);
        }
        b11 = b.b(lVar2);
        throw new IllegalArgumentException(b11.toString());
    }

    @Override // db.n
    public db.h X(List<? extends db.h> list) {
        return c.a.z(this, list);
    }

    @Override // db.n
    public boolean Y(db.l lVar) {
        return c.a.C(this, lVar);
    }

    @Override // db.q
    public boolean Z(db.i iVar, db.i iVar2) {
        return c.a.y(this, iVar, iVar2);
    }

    @Override // db.n, kotlin.reflect.jvm.internal.impl.types.checker.c
    public db.l a(db.i iVar) {
        return c.a.e0(this, iVar);
    }

    @Override // db.n
    public boolean a0(db.l lVar) {
        return c.a.A(this, lVar);
    }

    @Override // db.n, kotlin.reflect.jvm.internal.impl.types.checker.c
    public db.i b(db.h hVar) {
        return c.a.h(this, hVar);
    }

    @Override // bb.b1
    public db.h b0(db.h hVar) {
        return c.a.W(this, hVar);
    }

    @Override // db.n, kotlin.reflect.jvm.internal.impl.types.checker.c
    public db.i c(db.f fVar) {
        return c.a.S(this, fVar);
    }

    @Override // db.n, kotlin.reflect.jvm.internal.impl.types.checker.c
    public db.i d(db.i iVar, boolean z10) {
        return c.a.i0(this, iVar, z10);
    }

    @Override // bb.b1
    public boolean d0(db.h hVar, la.b bVar) {
        return c.a.x(this, hVar, bVar);
    }

    @Override // db.n, kotlin.reflect.jvm.internal.impl.types.checker.c
    public db.i e(db.f fVar) {
        return c.a.f0(this, fVar);
    }

    @Override // bb.b1
    public boolean e0(db.l lVar) {
        return c.a.R(this, lVar);
    }

    @Override // db.n
    public db.k f(db.h hVar, int i10) {
        return c.a.m(this, hVar, i10);
    }

    @Override // db.n
    public boolean f0(db.i iVar) {
        return c.a.M(this, iVar);
    }

    @Override // db.n
    public db.h g(db.k kVar) {
        return c.a.t(this, kVar);
    }

    @Override // db.n
    public boolean g0(db.l lVar) {
        return c.a.D(this, lVar);
    }

    @Override // db.n
    public boolean h(db.l lVar) {
        return c.a.B(this, lVar);
    }

    @Override // db.n
    public boolean h0(db.i iVar) {
        return c.a.O(this, iVar);
    }

    @Override // db.n
    public db.c j(db.i iVar) {
        return c.a.d(this, iVar);
    }

    @Override // db.n
    public boolean k(db.h hVar) {
        return c.a.E(this, hVar);
    }

    @Override // db.n
    public boolean m(db.i iVar) {
        return c.a.J(this, iVar);
    }

    @Override // db.n
    public db.e n(db.f fVar) {
        return c.a.f(this, fVar);
    }

    @Override // db.n
    public db.r o(db.k kVar) {
        return c.a.v(this, kVar);
    }

    @Override // bb.b1
    public k9.i p(db.l lVar) {
        return c.a.p(this, lVar);
    }

    @Override // db.n
    public db.h q(db.h hVar) {
        return c.a.V(this, hVar);
    }

    @Override // db.n
    public db.m r(db.l lVar, int i10) {
        return c.a.o(this, lVar, i10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.c
    public db.h s(db.i iVar, db.i iVar2) {
        return c.a.k(this, iVar, iVar2);
    }

    @Override // bb.b1
    public db.h t(db.h hVar) {
        return c.a.s(this, hVar);
    }

    @Override // db.n
    public boolean u(db.l lVar) {
        return c.a.H(this, lVar);
    }

    @Override // db.n
    public db.k v(db.h hVar) {
        return c.a.i(this, hVar);
    }

    @Override // bb.f
    public boolean v0(db.h hVar) {
        y8.k.e(hVar, "<this>");
        if (!(hVar instanceof g1) || !this.f11561g) {
            return false;
        }
        ((g1) hVar).W0();
        return false;
    }

    @Override // bb.b1
    public boolean w(db.l lVar) {
        return c.a.F(this, lVar);
    }

    @Override // db.n
    public boolean x(db.k kVar) {
        return c.a.P(this, kVar);
    }

    @Override // db.n
    public int y(db.h hVar) {
        return c.a.b(this, hVar);
    }

    @Override // db.n
    public db.h z(db.h hVar, boolean z10) {
        return c.a.h0(this, hVar, z10);
    }

    @Override // bb.f
    public boolean z0() {
        return this.f11559e;
    }
}
