package m;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* renamed from: m.q0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0565q0 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f5752a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5753b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f5754c = new Rect();

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i = Build.VERSION.SDK_INT;
        if (i >= 29 && i < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state != null && state.length != 0) {
                drawable.setState(f5753b);
            } else {
                drawable.setState(f5752a);
            }
            drawable.setState(state);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Rect b(Drawable drawable) {
        int i;
        int i3;
        int i4;
        int i5;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            Insets a2 = AbstractC0563p0.a(drawable);
            i = a2.left;
            i3 = a2.top;
            i4 = a2.right;
            i5 = a2.bottom;
            return new Rect(i, i3, i4, i5);
        }
        boolean z3 = drawable instanceof B.d;
        Object obj = drawable;
        if (z3) {
            ((B.e) ((B.d) drawable)).getClass();
            obj = null;
        }
        if (i6 < 29) {
            if (AbstractC0561o0.f5736a) {
                try {
                    Object invoke = AbstractC0561o0.f5737b.invoke(obj, null);
                    if (invoke != null) {
                        return new Rect(AbstractC0561o0.f5738c.getInt(invoke), AbstractC0561o0.f5739d.getInt(invoke), AbstractC0561o0.f5740e.getInt(invoke), AbstractC0561o0.f5741f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
        } else {
            boolean z4 = AbstractC0561o0.f5736a;
        }
        return f5754c;
    }

    public static PorterDuff.Mode c(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
