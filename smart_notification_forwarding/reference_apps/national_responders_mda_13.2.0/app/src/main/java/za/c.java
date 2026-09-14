package za;

import java.util.List;
import n9.b;
import n9.v0;
import n9.x;
import za.b;
import za.g;

/* loaded from: classes.dex */
public final class c extends p9.f implements b {
    private final ga.d K;
    private final ia.c L;
    private final ia.g M;
    private final ia.i N;
    private final f O;
    private g.a P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(n9.e eVar, n9.l lVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, b.a aVar, ga.d dVar, ia.c cVar, ia.g gVar2, ia.i iVar, f fVar, v0 v0Var) {
        super(eVar, lVar, gVar, z10, aVar, v0Var == null ? v0.f12324a : v0Var);
        y8.k.e(eVar, "containingDeclaration");
        y8.k.e(gVar, "annotations");
        y8.k.e(aVar, "kind");
        y8.k.e(dVar, "proto");
        y8.k.e(cVar, "nameResolver");
        y8.k.e(gVar2, "typeTable");
        y8.k.e(iVar, "versionRequirementTable");
        this.K = dVar;
        this.L = cVar;
        this.M = gVar2;
        this.N = iVar;
        this.O = fVar;
        this.P = g.a.COMPATIBLE;
    }

    public /* synthetic */ c(n9.e eVar, n9.l lVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, b.a aVar, ga.d dVar, ia.c cVar, ia.g gVar2, ia.i iVar, f fVar, v0 v0Var, int i10, y8.g gVar3) {
        this(eVar, lVar, gVar, z10, aVar, dVar, cVar, gVar2, iVar, fVar, (i10 & 1024) != 0 ? null : v0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.f
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public c W0(n9.m mVar, x xVar, b.a aVar, la.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, v0 v0Var) {
        y8.k.e(mVar, "newOwner");
        y8.k.e(aVar, "kind");
        y8.k.e(gVar, "annotations");
        y8.k.e(v0Var, "source");
        c cVar = new c((n9.e) mVar, (n9.l) xVar, gVar, this.I, aVar, Y(), O0(), z0(), L0(), F(), v0Var);
        cVar.j1(b1());
        cVar.F1(D1());
        return cVar;
    }

    public g.a D1() {
        return this.P;
    }

    @Override // za.g
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public ga.d Y() {
        return this.K;
    }

    @Override // za.g
    public f F() {
        return this.O;
    }

    public void F1(g.a aVar) {
        y8.k.e(aVar, "<set-?>");
        this.P = aVar;
    }

    @Override // p9.p, n9.z
    public boolean I() {
        return false;
    }

    @Override // za.g
    public ia.i L0() {
        return this.N;
    }

    @Override // za.g
    public ia.c O0() {
        return this.L;
    }

    @Override // za.g
    public List<ia.h> S0() {
        return b.a.a(this);
    }

    @Override // p9.p, n9.x
    public boolean q0() {
        return false;
    }

    @Override // p9.p, n9.x
    public boolean s0() {
        return false;
    }

    @Override // p9.p, n9.x
    public boolean x() {
        return false;
    }

    @Override // za.g
    public ia.g z0() {
        return this.M;
    }
}
