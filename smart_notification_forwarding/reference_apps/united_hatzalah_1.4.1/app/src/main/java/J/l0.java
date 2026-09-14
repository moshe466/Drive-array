package J;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public final class l0 extends k0 {

    /* renamed from: s, reason: collision with root package name */
    public static final p0 f1010s;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f1010s = p0.c(windowInsets, null);
    }

    public l0(p0 p0Var, WindowInsets windowInsets) {
        super(p0Var, windowInsets);
    }

    @Override // J.j0, J.f0, J.m0
    public boolean n(int i) {
        boolean isVisible;
        isVisible = this.f987c.isVisible(o0.a(i));
        return isVisible;
    }
}
