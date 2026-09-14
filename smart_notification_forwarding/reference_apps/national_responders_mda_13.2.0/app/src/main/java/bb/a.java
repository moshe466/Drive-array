package bb;

/* loaded from: classes.dex */
public final class a extends m {

    /* renamed from: g, reason: collision with root package name */
    private final i0 f4153g;

    /* renamed from: h, reason: collision with root package name */
    private final i0 f4154h;

    public a(i0 i0Var, i0 i0Var2) {
        y8.k.e(i0Var, "delegate");
        y8.k.e(i0Var2, "abbreviation");
        this.f4153g = i0Var;
        this.f4154h = i0Var2;
    }

    public final i0 D0() {
        return f1();
    }

    @Override // bb.m
    protected i0 f1() {
        return this.f4153g;
    }

    public final i0 i1() {
        return this.f4154h;
    }

    @Override // bb.i0
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public a a1(boolean z10) {
        return new a(f1().a1(z10), this.f4154h.a1(z10));
    }

    @Override // bb.m
    /* renamed from: k1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return new a((i0) gVar.g(f1()), (i0) gVar.g(this.f4154h));
    }

    @Override // bb.i0
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public a c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        return new a(f1().c1(gVar), this.f4154h);
    }

    @Override // bb.m
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public a h1(i0 i0Var) {
        y8.k.e(i0Var, "delegate");
        return new a(i0Var, this.f4154h);
    }
}
