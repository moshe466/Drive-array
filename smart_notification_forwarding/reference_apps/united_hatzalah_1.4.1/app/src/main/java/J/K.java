package J;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class K {
    public static p0 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        p0 c4 = p0.c(rootWindowInsets, null);
        m0 m0Var = c4.f1022a;
        m0Var.p(c4);
        m0Var.d(view.getRootView());
        return c4;
    }

    public static void b(View view, int i, int i3) {
        view.setScrollIndicators(i, i3);
    }
}
