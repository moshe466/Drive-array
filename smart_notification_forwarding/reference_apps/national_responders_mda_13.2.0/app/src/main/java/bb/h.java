package bb;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends n {

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f4219h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i0 i0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        super(i0Var);
        y8.k.e(i0Var, "delegate");
        y8.k.e(gVar, "annotations");
        this.f4219h = gVar;
    }

    @Override // bb.m
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public h h1(i0 i0Var) {
        y8.k.e(i0Var, "delegate");
        return new h(i0Var, u());
    }

    @Override // bb.m, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return this.f4219h;
    }
}
