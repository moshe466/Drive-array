package J;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class j0 extends i0 {

    /* renamed from: r, reason: collision with root package name */
    public static final p0 f1006r;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f1006r = p0.c(windowInsets, null);
    }

    public j0(p0 p0Var, WindowInsets windowInsets) {
        super(p0Var, windowInsets);
    }

    @Override // J.f0, J.m0
    public boolean n(int i) {
        boolean isVisible;
        isVisible = this.f987c.isVisible(n0.a(i));
        return isVisible;
    }

    @Override // J.f0, J.m0
    public final void d(View view) {
    }
}
