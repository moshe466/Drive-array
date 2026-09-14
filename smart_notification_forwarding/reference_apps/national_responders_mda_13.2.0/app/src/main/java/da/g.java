package da;

import bb.b0;
import bb.c0;
import bb.c1;
import bb.e1;
import bb.g1;
import bb.i0;
import bb.v;

/* loaded from: classes.dex */
public final class g extends bb.m implements bb.j {

    /* renamed from: g, reason: collision with root package name */
    private final i0 f8770g;

    public g(i0 i0Var) {
        y8.k.e(i0Var, "delegate");
        this.f8770g = i0Var;
    }

    private final i0 i1(i0 i0Var) {
        i0 a12 = i0Var.a1(false);
        return !eb.a.i(i0Var) ? a12 : new g(a12);
    }

    @Override // bb.m, bb.b0
    public boolean X0() {
        return false;
    }

    @Override // bb.j
    public boolean c() {
        return true;
    }

    @Override // bb.g1
    /* renamed from: d1 */
    public i0 a1(boolean z10) {
        return z10 ? f1().a1(true) : this;
    }

    @Override // bb.m
    protected i0 f1() {
        return this.f8770g;
    }

    @Override // bb.i0
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public g c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        return new g(f1().c1(gVar));
    }

    @Override // bb.m
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public g h1(i0 i0Var) {
        y8.k.e(i0Var, "delegate");
        return new g(i0Var);
    }

    @Override // bb.j
    public b0 v0(b0 b0Var) {
        y8.k.e(b0Var, "replacement");
        g1 Z0 = b0Var.Z0();
        if (!eb.a.i(Z0) && !c1.l(Z0)) {
            return Z0;
        }
        if (Z0 instanceof i0) {
            return i1((i0) Z0);
        }
        if (!(Z0 instanceof v)) {
            throw new IllegalStateException(y8.k.j("Incorrect type: ", Z0).toString());
        }
        c0 c0Var = c0.f4165a;
        v vVar = (v) Z0;
        return e1.d(c0.d(i1(vVar.e1()), i1(vVar.f1())), e1.a(Z0));
    }
}
