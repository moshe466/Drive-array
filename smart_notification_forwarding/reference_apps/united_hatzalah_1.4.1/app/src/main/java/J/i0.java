package J;

import android.graphics.Insets;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class i0 extends h0 {

    /* renamed from: o, reason: collision with root package name */
    public A.c f1004o;
    public A.c p;

    /* renamed from: q, reason: collision with root package name */
    public A.c f1005q;

    public i0(p0 p0Var, WindowInsets windowInsets) {
        super(p0Var, windowInsets);
        this.f1004o = null;
        this.p = null;
        this.f1005q = null;
    }

    @Override // J.m0
    public A.c f() {
        Insets mandatorySystemGestureInsets;
        if (this.p == null) {
            mandatorySystemGestureInsets = this.f987c.getMandatorySystemGestureInsets();
            this.p = A.c.b(mandatorySystemGestureInsets);
        }
        return this.p;
    }

    @Override // J.m0
    public A.c h() {
        Insets systemGestureInsets;
        if (this.f1004o == null) {
            systemGestureInsets = this.f987c.getSystemGestureInsets();
            this.f1004o = A.c.b(systemGestureInsets);
        }
        return this.f1004o;
    }

    @Override // J.m0
    public A.c j() {
        Insets tappableElementInsets;
        if (this.f1005q == null) {
            tappableElementInsets = this.f987c.getTappableElementInsets();
            this.f1005q = A.c.b(tappableElementInsets);
        }
        return this.f1005q;
    }

    @Override // J.f0, J.m0
    public p0 k(int i, int i3, int i4, int i5) {
        WindowInsets inset;
        inset = this.f987c.inset(i, i3, i4, i5);
        return p0.c(inset, null);
    }

    @Override // J.g0, J.m0
    public void q(A.c cVar) {
    }
}
