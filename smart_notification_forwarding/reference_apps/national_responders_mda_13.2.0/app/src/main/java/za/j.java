package za;

import java.util.List;
import l8.w;
import n9.a0;
import n9.b;
import n9.p0;
import n9.r0;
import n9.u;
import n9.v;
import n9.v0;
import p9.b0;
import p9.c0;
import za.b;
import za.g;

/* loaded from: classes.dex */
public final class j extends b0 implements b {
    private final ga.n F;
    private final ia.c G;
    private final ia.g H;
    private final ia.i I;
    private final f J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(n9.m mVar, p0 p0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, a0 a0Var, u uVar, boolean z10, la.e eVar, b.a aVar, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, ga.n nVar, ia.c cVar, ia.g gVar2, ia.i iVar, f fVar) {
        super(mVar, p0Var, gVar, a0Var, uVar, z10, eVar, aVar, v0.f12324a, z11, z12, z15, false, z13, z14);
        y8.k.e(mVar, "containingDeclaration");
        y8.k.e(gVar, "annotations");
        y8.k.e(a0Var, "modality");
        y8.k.e(uVar, "visibility");
        y8.k.e(eVar, "name");
        y8.k.e(aVar, "kind");
        y8.k.e(nVar, "proto");
        y8.k.e(cVar, "nameResolver");
        y8.k.e(gVar2, "typeTable");
        y8.k.e(iVar, "versionRequirementTable");
        this.F = nVar;
        this.G = cVar;
        this.H = gVar2;
        this.I = iVar;
        this.J = fVar;
        g.a aVar2 = g.a.COMPATIBLE;
    }

    @Override // za.g
    public f F() {
        return this.J;
    }

    @Override // p9.b0, n9.z
    public boolean I() {
        Boolean d10 = ia.b.C.d(Y().U());
        y8.k.d(d10, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return d10.booleanValue();
    }

    @Override // za.g
    public ia.i L0() {
        return this.I;
    }

    @Override // za.g
    public ia.c O0() {
        return this.G;
    }

    @Override // za.g
    public List<ia.h> S0() {
        return b.a.a(this);
    }

    @Override // p9.b0
    protected b0 Z0(n9.m mVar, a0 a0Var, u uVar, p0 p0Var, b.a aVar, la.e eVar, v0 v0Var) {
        y8.k.e(mVar, "newOwner");
        y8.k.e(a0Var, "newModality");
        y8.k.e(uVar, "newVisibility");
        y8.k.e(aVar, "kind");
        y8.k.e(eVar, "newName");
        y8.k.e(v0Var, "source");
        return new j(mVar, p0Var, u(), a0Var, uVar, P(), eVar, aVar, h0(), O(), I(), o0(), l0(), Y(), O0(), z0(), L0(), F());
    }

    @Override // za.g
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public ga.n Y() {
        return this.F;
    }

    public final void n1(c0 c0Var, r0 r0Var, v vVar, v vVar2, g.a aVar) {
        y8.k.e(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        super.f1(c0Var, r0Var, vVar, vVar2);
        w wVar = w.f11824a;
    }

    @Override // za.g
    public ia.g z0() {
        return this.H;
    }
}
