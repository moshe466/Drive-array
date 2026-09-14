package J;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class H {
    public static WindowInsets a(View view, WindowInsets windowInsets) {
        int i = U.f960a;
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    public static WindowInsets b(View view, WindowInsets windowInsets) {
        return view.onApplyWindowInsets(windowInsets);
    }

    public static void c(View view) {
        view.requestApplyInsets();
    }
}
