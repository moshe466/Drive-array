package t6;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;

/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14311a;

        static {
            int[] iArr = new int[b.values().length];
            f14311a = iArr;
            try {
                iArr[b.LARGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14311a[b.XLARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        SMALL(1.0f, 1.0f, 1.0f, 1.0f),
        NORMAL(1.0f, 1.0f, 1.0f, 1.0f),
        LARGE(0.6f, 0.9f, 0.6f, 0.9f),
        XLARGE(0.6f, 0.9f, 0.5f, 0.7f),
        UNDEFINED(1.0f, 1.0f, 1.0f, 1.0f);

        public final float fixedHeightMajor;
        public final float fixedHeightMinor;
        public final float fixedWidthMajor;
        public final float fixedWidthMinor;

        b(float f10, float f11, float f12, float f13) {
            this.fixedHeightMajor = f10;
            this.fixedHeightMinor = f11;
            this.fixedWidthMajor = f12;
            this.fixedWidthMinor = f13;
        }

        public static b getCurrent(Context context) {
            int i10 = context.getResources().getConfiguration().screenLayout & 15;
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? UNDEFINED : XLARGE : LARGE : NORMAL : SMALL;
        }
    }

    public static void a(Window window) {
        if (window.isFloating()) {
            b current = b.getCurrent(window.getContext());
            int i10 = a.f14311a[current.ordinal()];
            if (i10 == 1 || i10 == 2) {
                DisplayMetrics displayMetrics = window.getContext().getResources().getDisplayMetrics();
                int i11 = displayMetrics.widthPixels;
                int i12 = displayMetrics.heightPixels;
                boolean z10 = i11 < i12;
                window.setLayout((int) (i11 * (z10 ? current.fixedWidthMinor : current.fixedWidthMajor)), (int) (i12 * (z10 ? current.fixedHeightMajor : current.fixedHeightMinor)));
            }
        }
    }

    public static int b(Context context, int i10) {
        return c(context, i10, 0);
    }

    public static int c(Context context, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(i10, typedValue, true) ? typedValue.resourceId : i11;
    }
}
