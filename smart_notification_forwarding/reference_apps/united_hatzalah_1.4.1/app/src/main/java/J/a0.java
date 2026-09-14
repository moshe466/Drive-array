package J;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class a0 extends e0 {

    /* renamed from: a, reason: collision with root package name */
    public final WindowInsets.Builder f972a;

    public a0() {
        this.f972a = A.e.i();
    }

    @Override // J.e0
    public p0 b() {
        WindowInsets build;
        a();
        build = this.f972a.build();
        p0 c4 = p0.c(build, null);
        c4.f1022a.o(null);
        return c4;
    }

    @Override // J.e0
    public void c(A.c cVar) {
        this.f972a.setStableInsets(cVar.c());
    }

    @Override // J.e0
    public void d(A.c cVar) {
        this.f972a.setSystemWindowInsets(cVar.c());
    }

    public a0(p0 p0Var) {
        super(p0Var);
        WindowInsets.Builder i;
        WindowInsets b4 = p0Var.b();
        if (b4 != null) {
            i = A.e.j(b4);
        } else {
            i = A.e.i();
        }
        this.f972a = i;
    }
}
