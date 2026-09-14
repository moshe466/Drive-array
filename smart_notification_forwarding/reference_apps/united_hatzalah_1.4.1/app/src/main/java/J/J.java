package J;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.uh.sf.R;

/* loaded from: classes.dex */
public abstract class J {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static p0 b(View view, p0 p0Var, Rect rect) {
        WindowInsets b4 = p0Var.b();
        if (b4 != null) {
            return p0.c(view.computeSystemWindowInsets(b4, rect), view);
        }
        rect.setEmpty();
        return p0Var;
    }

    public static ColorStateList c(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode d(View view) {
        return view.getBackgroundTintMode();
    }

    public static String e(View view) {
        return view.getTransitionName();
    }

    public static boolean f(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void g(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void h(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void i(View view, float f4) {
        view.setElevation(f4);
    }

    public static void j(View view, InterfaceC0132u interfaceC0132u) {
        I i;
        if (interfaceC0132u != null) {
            i = new I(view, interfaceC0132u);
        } else {
            i = null;
        }
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, i);
        }
        if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
            return;
        }
        if (i != null) {
            view.setOnApplyWindowInsetsListener(i);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        }
    }

    public static void k(View view, String str) {
        view.setTransitionName(str);
    }

    public static void l(View view) {
        view.stopNestedScroll();
    }
}
