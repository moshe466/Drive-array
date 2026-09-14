package za;

import bb.b0;
import java.util.List;
import java.util.Map;
import n9.a;
import n9.a0;
import n9.a1;
import n9.b;
import n9.d1;
import n9.s0;
import n9.u;
import n9.u0;
import n9.v0;
import n9.x;
import p9.f0;
import p9.p;
import za.b;
import za.g;

/* loaded from: classes.dex */
public final class k extends f0 implements b {
    private final ga.i I;
    private final ia.c J;
    private final ia.g K;
    private final ia.i L;
    private final f M;
    private g.a N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(n9.m mVar, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, b.a aVar, ga.i iVar, ia.c cVar, ia.g gVar2, ia.i iVar2, f fVar, v0 v0Var) {
        super(mVar, u0Var, gVar, eVar, aVar, v0Var == null ? v0.f12324a : v0Var);
        y8.k.e(mVar, "containingDeclaration");
        y8.k.e(gVar, "annotations");
        y8.k.e(eVar, "name");
        y8.k.e(aVar, "kind");
        y8.k.e(iVar, "proto");
        y8.k.e(cVar, "nameResolver");
        y8.k.e(gVar2, "typeTable");
        y8.k.e(iVar2, "versionRequirementTable");
        this.I = iVar;
        this.J = cVar;
        this.K = gVar2;
        this.L = iVar2;
        this.M = fVar;
        this.N = g.a.COMPATIBLE;
    }

    public /* synthetic */ k(n9.m mVar, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, la.e eVar, b.a aVar, ga.i iVar, ia.c cVar, ia.g gVar2, ia.i iVar2, f fVar, v0 v0Var, int i10, y8.g gVar3) {
        this(mVar, u0Var, gVar, eVar, aVar, iVar, cVar, gVar2, iVar2, fVar, (i10 & 1024) != 0 ? null : v0Var);
    }

    public g.a A1() {
        return this.N;
    }

    @Override // za.g
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public ga.i Y() {
        return this.I;
    }

    public final f0 C1(s0 s0Var, s0 s0Var2, List<? extends a1> list, List<? extends d1> list2, b0 b0Var, a0 a0Var, u uVar, Map<? extends a.InterfaceC0257a<?>, ?> map, g.a aVar) {
        y8.k.e(list, "typeParameters");
        y8.k.e(list2, "unsubstitutedValueParameters");
        y8.k.e(uVar, "visibility");
        y8.k.e(map, "userDataMap");
        y8.k.e(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        f0 z12 = super.z1(s0Var, s0Var2, list, list2, b0Var, a0Var, uVar, map);
        y8.k.d(z12, "super.initialize(\n            extensionReceiverParameter,\n            dispatchReceiverParameter,\n            typeParameters,\n            unsubstitutedValueParameters,\n            unsubstitutedReturnType,\n            modality,\n            visibility,\n            userDataMap\n        )");
        this.N = aVar;
        return z12;
    }

    @Override // za.g
    public f F() {
        return this.M;
    }

    @Override // za.g
    public ia.i L0() {
        return this.L;
    }

    @Override // za.g
    public ia.c O0() {
        return this.J;
    }

    @Override // za.g
    public List<ia.h> S0() {
        return b.a.a(this);
    }

    @Override // p9.f0, p9.p
    protected p W0(n9.m mVar, x xVar, b.a aVar, la.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var) {
        la.e eVar2;
        y8.k.e(mVar, "newOwner");
        y8.k.e(aVar, "kind");
        y8.k.e(gVar, "annotations");
        y8.k.e(v0Var, "source");
        u0 u0Var = (u0) xVar;
        if (eVar == null) {
            la.e c10 = c();
            y8.k.d(c10, "name");
            eVar2 = c10;
        } else {
            eVar2 = eVar;
        }
        k kVar = new k(mVar, u0Var, gVar, eVar2, aVar, Y(), O0(), z0(), L0(), F(), v0Var);
        kVar.j1(b1());
        kVar.N = A1();
        return kVar;
    }

    @Override // za.g
    public ia.g z0() {
        return this.K;
    }
}
