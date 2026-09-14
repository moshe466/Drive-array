package bb;

/* loaded from: classes.dex */
public abstract class n extends m {

    /* renamed from: g, reason: collision with root package name */
    private final i0 f4235g;

    public n(i0 i0Var) {
        y8.k.e(i0Var, "delegate");
        this.f4235g = i0Var;
    }

    @Override // bb.g1
    /* renamed from: d1 */
    public i0 a1(boolean z10) {
        return z10 == X0() ? this : f1().a1(z10).c1(u());
    }

    @Override // bb.m
    protected i0 f1() {
        return this.f4235g;
    }

    @Override // bb.i0
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public n c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        return gVar != u() ? new h(this, gVar) : this;
    }
}
