package p9;

import bb.a1;
import bb.h1;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.KProperty;
import n9.b;
import n9.d1;
import n9.s0;
import n9.v0;
import n9.z0;

/* loaded from: classes.dex */
public final class i0 extends p implements h0 {
    public static final a L = new a(null);
    static final /* synthetic */ KProperty<Object>[] M = {y8.w.g(new y8.t(y8.w.b(i0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    private final ab.n I;
    private final z0 J;
    private n9.d K;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final a1 c(z0 z0Var) {
            if (z0Var.n() == null) {
                return null;
            }
            return a1.f(z0Var.D0());
        }

        public final h0 b(ab.n nVar, z0 z0Var, n9.d dVar) {
            n9.d e10;
            y8.k.e(nVar, "storageManager");
            y8.k.e(z0Var, "typeAliasDescriptor");
            y8.k.e(dVar, "constructor");
            a1 c10 = c(z0Var);
            if (c10 == null || (e10 = dVar.e(c10)) == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = dVar.u();
            b.a r10 = dVar.r();
            y8.k.d(r10, "constructor.kind");
            v0 k10 = z0Var.k();
            y8.k.d(k10, "typeAliasDescriptor.source");
            i0 i0Var = new i0(nVar, z0Var, e10, null, u10, r10, k10, null);
            List<d1> Z0 = p.Z0(i0Var, dVar.l(), c10);
            if (Z0 == null) {
                return null;
            }
            bb.i0 c11 = bb.y.c(e10.i().Z0());
            bb.i0 s10 = z0Var.s();
            y8.k.d(s10, "typeAliasDescriptor.defaultType");
            bb.i0 j10 = bb.l0.j(c11, s10);
            s0 K = dVar.K();
            i0Var.c1(K != null ? na.c.f(i0Var, c10.n(K.b(), h1.INVARIANT), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b()) : null, null, z0Var.B(), Z0, j10, n9.a0.FINAL, z0Var.h());
            return i0Var;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<i0> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n9.d f13212g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(n9.d dVar) {
            super(0);
            this.f13212g = dVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 b() {
            ab.n M = i0.this.M();
            z0 z12 = i0.this.z1();
            n9.d dVar = this.f13212g;
            i0 i0Var = i0.this;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = dVar.u();
            b.a r10 = this.f13212g.r();
            y8.k.d(r10, "underlyingConstructorDescriptor.kind");
            v0 k10 = i0.this.z1().k();
            y8.k.d(k10, "typeAliasDescriptor.source");
            i0 i0Var2 = new i0(M, z12, dVar, i0Var, u10, r10, k10, null);
            i0 i0Var3 = i0.this;
            n9.d dVar2 = this.f13212g;
            a1 c10 = i0.L.c(i0Var3.z1());
            if (c10 == null) {
                return null;
            }
            s0 K = dVar2.K();
            i0Var2.c1(null, K == null ? null : K.e(c10), i0Var3.z1().B(), i0Var3.l(), i0Var3.i(), n9.a0.FINAL, i0Var3.z1().h());
            return i0Var2;
        }
    }

    private i0(ab.n nVar, z0 z0Var, n9.d dVar, h0 h0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, b.a aVar, v0 v0Var) {
        super(z0Var, h0Var, gVar, la.e.u("<init>"), aVar, v0Var);
        this.I = nVar;
        this.J = z0Var;
        g1(z1().H0());
        nVar.h(new b(dVar));
        this.K = dVar;
    }

    public /* synthetic */ i0(ab.n nVar, z0 z0Var, n9.d dVar, h0 h0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, b.a aVar, v0 v0Var, y8.g gVar2) {
        this(nVar, z0Var, dVar, h0Var, gVar, aVar, v0Var);
    }

    @Override // p9.p, n9.x, n9.x0
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public h0 e(a1 a1Var) {
        y8.k.e(a1Var, "substitutor");
        n9.x e10 = super.e(a1Var);
        Objects.requireNonNull(e10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        i0 i0Var = (i0) e10;
        a1 f10 = a1.f(i0Var.i());
        y8.k.d(f10, "create(substitutedTypeAliasConstructor.returnType)");
        n9.d e11 = b0().a().e(f10);
        if (e11 == null) {
            return null;
        }
        i0Var.K = e11;
        return i0Var;
    }

    public final ab.n M() {
        return this.I;
    }

    @Override // n9.l
    public boolean S() {
        return b0().S();
    }

    @Override // n9.l
    public n9.e T() {
        n9.e T = b0().T();
        y8.k.d(T, "underlyingConstructorDescriptor.constructedClass");
        return T;
    }

    @Override // p9.h0
    public n9.d b0() {
        return this.K;
    }

    @Override // p9.p, n9.a
    public bb.b0 i() {
        bb.b0 i10 = super.i();
        y8.k.b(i10);
        return i10;
    }

    @Override // p9.p
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public h0 V0(n9.m mVar, n9.a0 a0Var, n9.u uVar, b.a aVar, boolean z10) {
        y8.k.e(mVar, "newOwner");
        y8.k.e(a0Var, "modality");
        y8.k.e(uVar, "visibility");
        y8.k.e(aVar, "kind");
        n9.x c10 = y().l(mVar).i(a0Var).d(uVar).q(aVar).s(z10).c();
        Objects.requireNonNull(c10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (h0) c10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.p
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public i0 W0(n9.m mVar, n9.x xVar, b.a aVar, la.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var) {
        y8.k.e(mVar, "newOwner");
        y8.k.e(aVar, "kind");
        y8.k.e(gVar, "annotations");
        y8.k.e(v0Var, "source");
        b.a aVar2 = b.a.DECLARATION;
        if (aVar != aVar2) {
            b.a aVar3 = b.a.SYNTHESIZED;
        }
        return new i0(this.I, z1(), b0(), this, gVar, aVar2, v0Var);
    }

    @Override // p9.k, n9.m
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public z0 d() {
        return z1();
    }

    @Override // p9.p, p9.k, p9.j, n9.m
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public h0 a() {
        return (h0) super.a();
    }

    public z0 z1() {
        return this.J;
    }
}
