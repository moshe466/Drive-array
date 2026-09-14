package J;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class g0 extends f0 {

    /* renamed from: n, reason: collision with root package name */
    public A.c f994n;

    public g0(p0 p0Var, WindowInsets windowInsets) {
        super(p0Var, windowInsets);
        this.f994n = null;
    }

    @Override // J.m0
    public p0 b() {
        return p0.c(this.f987c.consumeStableInsets(), null);
    }

    @Override // J.m0
    public p0 c() {
        return p0.c(this.f987c.consumeSystemWindowInsets(), null);
    }

    @Override // J.m0
    public final A.c g() {
        if (this.f994n == null) {
            WindowInsets windowInsets = this.f987c;
            this.f994n = A.c.a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f994n;
    }

    @Override // J.m0
    public boolean l() {
        return this.f987c.isConsumed();
    }

    @Override // J.m0
    public void q(A.c cVar) {
        this.f994n = cVar;
    }
}
