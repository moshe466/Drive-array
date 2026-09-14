package bb;

/* loaded from: classes.dex */
public final class q extends v implements db.e {

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f4246i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q(k9.h r3, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r4) {
        /*
            r2 = this;
            java.lang.String r0 = "builtIns"
            y8.k.e(r3, r0)
            java.lang.String r0 = "annotations"
            y8.k.e(r4, r0)
            bb.i0 r0 = r3.H()
            java.lang.String r1 = "builtIns.nothingType"
            y8.k.d(r0, r1)
            bb.i0 r3 = r3.I()
            java.lang.String r1 = "builtIns.nullableAnyType"
            y8.k.d(r3, r1)
            r2.<init>(r0, r3)
            r2.f4246i = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.q.<init>(k9.h, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g):void");
    }

    @Override // bb.v, bb.b0
    public boolean X0() {
        return false;
    }

    @Override // bb.v
    public i0 d1() {
        return f1();
    }

    @Override // bb.v
    public String g1(kotlin.reflect.jvm.internal.impl.renderer.c cVar, kotlin.reflect.jvm.internal.impl.renderer.f fVar) {
        y8.k.e(cVar, "renderer");
        y8.k.e(fVar, "options");
        return "dynamic";
    }

    @Override // bb.g1
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public q a1(boolean z10) {
        return this;
    }

    @Override // bb.g1
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public q g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // bb.g1
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public q c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        return new q(eb.a.e(d1()), gVar);
    }

    @Override // bb.v, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return this.f4246i;
    }
}
