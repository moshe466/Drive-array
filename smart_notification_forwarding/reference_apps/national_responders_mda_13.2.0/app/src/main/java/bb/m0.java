package bb;

/* loaded from: classes.dex */
public final class m0 extends w0 {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f4234a;

    public m0(k9.h hVar) {
        y8.k.e(hVar, "kotlinBuiltIns");
        i0 I = hVar.I();
        y8.k.d(I, "kotlinBuiltIns.nullableAnyType");
        this.f4234a = I;
    }

    @Override // bb.v0
    public b0 b() {
        return this.f4234a;
    }

    @Override // bb.v0
    public h1 c() {
        return h1.OUT_VARIANCE;
    }

    @Override // bb.v0
    public boolean d() {
        return true;
    }

    @Override // bb.v0
    public v0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return this;
    }
}
