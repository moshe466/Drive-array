package ea;

import n9.w0;

/* loaded from: classes.dex */
public final class q implements za.f {

    /* renamed from: b, reason: collision with root package name */
    private final o f9326b;

    public q(o oVar, xa.r<ka.f> rVar, boolean z10, za.e eVar) {
        y8.k.e(oVar, "binaryClass");
        y8.k.e(eVar, "abiStability");
        this.f9326b = oVar;
    }

    @Override // n9.v0
    public w0 a() {
        w0 w0Var = w0.f12327a;
        y8.k.d(w0Var, "NO_SOURCE_FILE");
        return w0Var;
    }

    @Override // za.f
    public String c() {
        return "Class '" + this.f9326b.d().b().b() + '\'';
    }

    public final o d() {
        return this.f9326b;
    }

    public String toString() {
        return ((Object) q.class.getSimpleName()) + ": " + this.f9326b;
    }
}
