package oa;

import bb.i0;
import bb.t;
import bb.v0;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import m8.q;
import ua.h;
import y8.k;

/* loaded from: classes.dex */
public final class a extends i0 implements db.c {

    /* renamed from: g, reason: collision with root package name */
    private final v0 f12634g;

    /* renamed from: h, reason: collision with root package name */
    private final b f12635h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f12636i;

    /* renamed from: j, reason: collision with root package name */
    private final g f12637j;

    public a(v0 v0Var, b bVar, boolean z10, g gVar) {
        k.e(v0Var, "typeProjection");
        k.e(bVar, "constructor");
        k.e(gVar, "annotations");
        this.f12634g = v0Var;
        this.f12635h = bVar;
        this.f12636i = z10;
        this.f12637j = gVar;
    }

    public /* synthetic */ a(v0 v0Var, b bVar, boolean z10, g gVar, int i10, y8.g gVar2) {
        this(v0Var, (i10 & 2) != 0 ? new c(v0Var) : bVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? g.f11362b.b() : gVar);
    }

    @Override // bb.b0
    public h A() {
        h i10 = t.i("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        k.d(i10, "createErrorScope(\n            \"No member resolution should be done on captured type, it used only during constraint system resolution\", true\n        )");
        return i10;
    }

    @Override // bb.b0
    public List<v0> V0() {
        List<v0> d10;
        d10 = q.d();
        return d10;
    }

    @Override // bb.b0
    public boolean X0() {
        return this.f12636i;
    }

    @Override // bb.b0
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public b W0() {
        return this.f12635h;
    }

    @Override // bb.i0
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public a a1(boolean z10) {
        return z10 == X0() ? this : new a(this.f12634g, W0(), z10, u());
    }

    @Override // bb.g1
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public a g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        k.e(gVar, "kotlinTypeRefiner");
        v0 y10 = this.f12634g.y(gVar);
        k.d(y10, "typeProjection.refine(kotlinTypeRefiner)");
        return new a(y10, W0(), X0(), u());
    }

    @Override // bb.i0
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public a c1(g gVar) {
        k.e(gVar, "newAnnotations");
        return new a(this.f12634g, W0(), X0(), gVar);
    }

    @Override // bb.i0
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Captured(");
        sb2.append(this.f12634g);
        sb2.append(')');
        sb2.append(X0() ? "?" : "");
        return sb2.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public g u() {
        return this.f12637j;
    }
}
