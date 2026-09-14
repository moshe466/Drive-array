package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.g1;
import bb.i0;
import bb.v0;
import java.util.List;
import n9.a1;

/* loaded from: classes.dex */
public final class i extends i0 implements db.c {

    /* renamed from: g, reason: collision with root package name */
    private final db.b f11568g;

    /* renamed from: h, reason: collision with root package name */
    private final j f11569h;

    /* renamed from: i, reason: collision with root package name */
    private final g1 f11570i;

    /* renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f11571j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f11572k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f11573l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(db.b bVar, g1 g1Var, v0 v0Var, a1 a1Var) {
        this(bVar, new j(v0Var, null, null, a1Var, 6, null), g1Var, null, false, false, 56, null);
        y8.k.e(bVar, "captureStatus");
        y8.k.e(v0Var, "projection");
        y8.k.e(a1Var, "typeParameter");
    }

    public i(db.b bVar, j jVar, g1 g1Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, boolean z11) {
        y8.k.e(bVar, "captureStatus");
        y8.k.e(jVar, "constructor");
        y8.k.e(gVar, "annotations");
        this.f11568g = bVar;
        this.f11569h = jVar;
        this.f11570i = g1Var;
        this.f11571j = gVar;
        this.f11572k = z10;
        this.f11573l = z11;
    }

    public /* synthetic */ i(db.b bVar, j jVar, g1 g1Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, boolean z11, int i10, y8.g gVar2) {
        this(bVar, jVar, g1Var, (i10 & 8) != 0 ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b() : gVar, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11);
    }

    @Override // bb.b0
    public ua.h A() {
        ua.h i10 = bb.t.i("No member resolution should be done on captured type!", true);
        y8.k.d(i10, "createErrorScope(\"No member resolution should be done on captured type!\", true)");
        return i10;
    }

    @Override // bb.b0
    public List<v0> V0() {
        List<v0> d10;
        d10 = m8.q.d();
        return d10;
    }

    @Override // bb.b0
    public boolean X0() {
        return this.f11572k;
    }

    public final db.b f1() {
        return this.f11568g;
    }

    @Override // bb.b0
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public j W0() {
        return this.f11569h;
    }

    public final g1 h1() {
        return this.f11570i;
    }

    public final boolean i1() {
        return this.f11573l;
    }

    @Override // bb.i0
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public i a1(boolean z10) {
        return new i(this.f11568g, W0(), this.f11570i, u(), z10, false, 32, null);
    }

    @Override // bb.g1
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public i g1(g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        db.b bVar = this.f11568g;
        j y10 = W0().y(gVar);
        g1 g1Var = this.f11570i;
        return new i(bVar, y10, g1Var == null ? null : gVar.g(g1Var).Z0(), u(), X0(), false, 32, null);
    }

    @Override // bb.i0
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public i c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        return new i(this.f11568g, W0(), this.f11570i, gVar, X0(), false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return this.f11571j;
    }
}
