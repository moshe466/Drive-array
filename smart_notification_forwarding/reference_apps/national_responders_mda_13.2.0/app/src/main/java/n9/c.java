package n9;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements a1 {

    /* renamed from: f, reason: collision with root package name */
    private final a1 f12264f;

    /* renamed from: g, reason: collision with root package name */
    private final m f12265g;

    /* renamed from: h, reason: collision with root package name */
    private final int f12266h;

    public c(a1 a1Var, m mVar, int i10) {
        y8.k.e(a1Var, "originalDescriptor");
        y8.k.e(mVar, "declarationDescriptor");
        this.f12264f = a1Var;
        this.f12265g = mVar;
        this.f12266h = i10;
    }

    @Override // n9.m
    public <R, D> R J0(o<R, D> oVar, D d10) {
        return (R) this.f12264f.J0(oVar, d10);
    }

    @Override // n9.a1
    public ab.n M() {
        return this.f12264f.M();
    }

    @Override // n9.a1
    public boolean Z() {
        return true;
    }

    @Override // n9.m
    public a1 a() {
        a1 a10 = this.f12264f.a();
        y8.k.d(a10, "originalDescriptor.original");
        return a10;
    }

    @Override // n9.a1
    public boolean a0() {
        return this.f12264f.a0();
    }

    @Override // n9.e0
    public la.e c() {
        return this.f12264f.c();
    }

    @Override // n9.n, n9.m
    public m d() {
        return this.f12265g;
    }

    @Override // n9.a1
    public List<bb.b0> getUpperBounds() {
        return this.f12264f.getUpperBounds();
    }

    @Override // n9.a1
    public int j() {
        return this.f12266h + this.f12264f.j();
    }

    @Override // n9.p
    public v0 k() {
        return this.f12264f.k();
    }

    @Override // n9.a1, n9.h
    public bb.t0 o() {
        return this.f12264f.o();
    }

    @Override // n9.h
    public bb.i0 s() {
        return this.f12264f.s();
    }

    public String toString() {
        return this.f12264f + "[inner-copy]";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return this.f12264f.u();
    }

    @Override // n9.a1
    public bb.h1 v() {
        return this.f12264f.v();
    }
}
