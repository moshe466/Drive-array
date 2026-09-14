package bb;

/* loaded from: classes.dex */
public final class k0 extends m implements d1 {

    /* renamed from: g, reason: collision with root package name */
    private final i0 f4231g;

    /* renamed from: h, reason: collision with root package name */
    private final b0 f4232h;

    public k0(i0 i0Var, b0 b0Var) {
        y8.k.e(i0Var, "delegate");
        y8.k.e(b0Var, "enhancement");
        this.f4231g = i0Var;
        this.f4232h = b0Var;
    }

    @Override // bb.d1
    public g1 I0() {
        return f1();
    }

    @Override // bb.g1
    /* renamed from: d1 */
    public i0 a1(boolean z10) {
        return (i0) e1.d(I0().a1(z10), e0().Z0().a1(z10));
    }

    @Override // bb.d1
    public b0 e0() {
        return this.f4232h;
    }

    @Override // bb.g1
    /* renamed from: e1 */
    public i0 c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        return (i0) e1.d(I0().c1(gVar), e0());
    }

    @Override // bb.m
    protected i0 f1() {
        return this.f4231g;
    }

    @Override // bb.m
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public k0 g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return new k0((i0) gVar.g(f1()), gVar.g(e0()));
    }

    @Override // bb.m
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public k0 h1(i0 i0Var) {
        y8.k.e(i0Var, "delegate");
        return new k0(i0Var, e0());
    }
}
