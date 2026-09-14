package bb;

/* loaded from: classes.dex */
public final class x extends v implements d1 {

    /* renamed from: i, reason: collision with root package name */
    private final v f4277i;

    /* renamed from: j, reason: collision with root package name */
    private final b0 f4278j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(v vVar, b0 b0Var) {
        super(vVar.e1(), vVar.f1());
        y8.k.e(vVar, "origin");
        y8.k.e(b0Var, "enhancement");
        this.f4277i = vVar;
        this.f4278j = b0Var;
    }

    @Override // bb.g1
    public g1 a1(boolean z10) {
        return e1.d(I0().a1(z10), e0().Z0().a1(z10));
    }

    @Override // bb.g1
    public g1 c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        return e1.d(I0().c1(gVar), e0());
    }

    @Override // bb.v
    public i0 d1() {
        return I0().d1();
    }

    @Override // bb.d1
    public b0 e0() {
        return this.f4278j;
    }

    @Override // bb.v
    public String g1(kotlin.reflect.jvm.internal.impl.renderer.c cVar, kotlin.reflect.jvm.internal.impl.renderer.f fVar) {
        y8.k.e(cVar, "renderer");
        y8.k.e(fVar, "options");
        return fVar.k() ? cVar.x(e0()) : I0().g1(cVar, fVar);
    }

    @Override // bb.d1
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public v I0() {
        return this.f4277i;
    }

    @Override // bb.g1
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public x g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return new x((v) gVar.g(I0()), gVar.g(e0()));
    }
}
