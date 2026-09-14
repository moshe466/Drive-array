package za;

import bb.b0;
import bb.d0;
import bb.h1;
import bb.i0;
import ga.r;
import java.util.Collection;
import java.util.List;
import n9.a1;
import n9.b1;
import n9.z0;
import p9.h0;
import za.g;

/* loaded from: classes.dex */
public final class l extends p9.d implements g {

    /* renamed from: m, reason: collision with root package name */
    private final ab.n f16480m;

    /* renamed from: n, reason: collision with root package name */
    private final r f16481n;

    /* renamed from: o, reason: collision with root package name */
    private final ia.c f16482o;

    /* renamed from: p, reason: collision with root package name */
    private final ia.g f16483p;

    /* renamed from: q, reason: collision with root package name */
    private final ia.i f16484q;

    /* renamed from: r, reason: collision with root package name */
    private final f f16485r;

    /* renamed from: s, reason: collision with root package name */
    private Collection<? extends h0> f16486s;

    /* renamed from: t, reason: collision with root package name */
    private i0 f16487t;

    /* renamed from: u, reason: collision with root package name */
    private i0 f16488u;

    /* renamed from: v, reason: collision with root package name */
    private List<? extends a1> f16489v;

    /* renamed from: w, reason: collision with root package name */
    private i0 f16490w;

    /* renamed from: x, reason: collision with root package name */
    private g.a f16491x;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l(ab.n r13, n9.m r14, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r15, la.e r16, n9.u r17, ga.r r18, ia.c r19, ia.g r20, ia.i r21, za.f r22) {
        /*
            r12 = this;
            r6 = r12
            r7 = r13
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            java.lang.String r0 = "storageManager"
            y8.k.e(r13, r0)
            java.lang.String r0 = "containingDeclaration"
            r1 = r14
            y8.k.e(r14, r0)
            java.lang.String r0 = "annotations"
            r2 = r15
            y8.k.e(r15, r0)
            java.lang.String r0 = "name"
            r3 = r16
            y8.k.e(r3, r0)
            java.lang.String r0 = "visibility"
            r5 = r17
            y8.k.e(r5, r0)
            java.lang.String r0 = "proto"
            y8.k.e(r8, r0)
            java.lang.String r0 = "nameResolver"
            y8.k.e(r9, r0)
            java.lang.String r0 = "typeTable"
            y8.k.e(r10, r0)
            java.lang.String r0 = "versionRequirementTable"
            y8.k.e(r11, r0)
            n9.v0 r4 = n9.v0.f12324a
            java.lang.String r0 = "NO_SOURCE"
            y8.k.d(r4, r0)
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f16480m = r7
            r6.f16481n = r8
            r6.f16482o = r9
            r6.f16483p = r10
            r6.f16484q = r11
            r0 = r22
            r6.f16485r = r0
            za.g$a r0 = za.g.a.COMPATIBLE
            r6.f16491x = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: za.l.<init>(ab.n, n9.m, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g, la.e, n9.u, ga.r, ia.c, ia.g, ia.i, za.f):void");
    }

    @Override // n9.z0
    public i0 D0() {
        i0 i0Var = this.f16488u;
        if (i0Var != null) {
            return i0Var;
        }
        y8.k.o("expandedType");
        throw null;
    }

    @Override // za.g
    public f F() {
        return this.f16485r;
    }

    @Override // n9.z0
    public i0 L() {
        i0 i0Var = this.f16487t;
        if (i0Var != null) {
            return i0Var;
        }
        y8.k.o("underlyingType");
        throw null;
    }

    @Override // za.g
    public ia.i L0() {
        return this.f16484q;
    }

    @Override // p9.d
    protected ab.n M() {
        return this.f16480m;
    }

    @Override // za.g
    public ia.c O0() {
        return this.f16482o;
    }

    @Override // za.g
    public List<ia.h> S0() {
        return g.b.a(this);
    }

    @Override // p9.d
    protected List<a1> X0() {
        List list = this.f16489v;
        if (list != null) {
            return list;
        }
        y8.k.o("typeConstructorParameters");
        throw null;
    }

    public g.a Z0() {
        return this.f16491x;
    }

    @Override // za.g
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public r Y() {
        return this.f16481n;
    }

    public final void b1(List<? extends a1> list, i0 i0Var, i0 i0Var2, g.a aVar) {
        y8.k.e(list, "declaredTypeParameters");
        y8.k.e(i0Var, "underlyingType");
        y8.k.e(i0Var2, "expandedType");
        y8.k.e(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        Y0(list);
        this.f16487t = i0Var;
        this.f16488u = i0Var2;
        this.f16489v = b1.d(this);
        this.f16490w = U0();
        this.f16486s = W0();
        this.f16491x = aVar;
    }

    @Override // n9.x0
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public z0 e(bb.a1 a1Var) {
        y8.k.e(a1Var, "substitutor");
        if (a1Var.k()) {
            return this;
        }
        ab.n M = M();
        n9.m d10 = d();
        y8.k.d(d10, "containingDeclaration");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u10 = u();
        y8.k.d(u10, "annotations");
        la.e c10 = c();
        y8.k.d(c10, "name");
        l lVar = new l(M, d10, u10, c10, h(), Y(), O0(), z0(), L0(), F());
        List<a1> B = B();
        i0 L = L();
        h1 h1Var = h1.INVARIANT;
        b0 n10 = a1Var.n(L, h1Var);
        y8.k.d(n10, "substitutor.safeSubstitute(underlyingType, Variance.INVARIANT)");
        i0 a10 = bb.z0.a(n10);
        b0 n11 = a1Var.n(D0(), h1Var);
        y8.k.d(n11, "substitutor.safeSubstitute(expandedType, Variance.INVARIANT)");
        lVar.b1(B, a10, bb.z0.a(n11), Z0());
        return lVar;
    }

    @Override // n9.z0
    public n9.e n() {
        if (d0.a(D0())) {
            return null;
        }
        n9.h o10 = D0().W0().o();
        if (o10 instanceof n9.e) {
            return (n9.e) o10;
        }
        return null;
    }

    @Override // n9.h
    public i0 s() {
        i0 i0Var = this.f16490w;
        if (i0Var != null) {
            return i0Var;
        }
        y8.k.o("defaultTypeImpl");
        throw null;
    }

    @Override // za.g
    public ia.g z0() {
        return this.f16483p;
    }
}
