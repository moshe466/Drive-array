package p9;

import n9.v0;

/* loaded from: classes.dex */
public abstract class z extends k implements n9.g0 {

    /* renamed from: j, reason: collision with root package name */
    private final la.b f13324j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(n9.d0 d0Var, la.b bVar) {
        super(d0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), bVar.h(), v0.f12324a);
        y8.k.e(d0Var, "module");
        y8.k.e(bVar, "fqName");
        this.f13324j = bVar;
    }

    @Override // n9.m
    public <R, D> R J0(n9.o<R, D> oVar, D d10) {
        y8.k.e(oVar, "visitor");
        return oVar.h(this, d10);
    }

    @Override // p9.k, n9.m
    public n9.d0 d() {
        return (n9.d0) super.d();
    }

    @Override // n9.g0
    public final la.b f() {
        return this.f13324j;
    }

    @Override // p9.k, n9.p
    public v0 k() {
        v0 v0Var = v0.f12324a;
        y8.k.d(v0Var, "NO_SOURCE");
        return v0Var;
    }

    @Override // p9.j
    public String toString() {
        return y8.k.j("package ", this.f13324j);
    }
}
