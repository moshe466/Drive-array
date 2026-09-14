package m;

import a.AbstractC0228a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import g.AbstractC0424a;

/* loaded from: classes.dex */
public abstract class i1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f5689a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5690b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f5691c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f5692d = {R.attr.state_pressed};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f5693e = {R.attr.state_checked};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f5694f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f5695g = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(AbstractC0424a.f4635j);
        try {
            if (!obtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i) {
        ColorStateList d2 = d(context, i);
        if (d2 != null && d2.isStateful()) {
            return d2.getColorForState(f5690b, d2.getDefaultColor());
        }
        ThreadLocal threadLocal = f5689a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f4 = typedValue.getFloat();
        int c4 = c(context, i);
        int round = Math.round(Color.alpha(c4) * f4);
        int i3 = A.a.f0a;
        if (round >= 0 && round <= 255) {
            return (c4 & 16777215) | (round << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    public static int c(Context context, int i) {
        int[] iArr = f5695g;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList d(Context context, int i) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = f5695g;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = AbstractC0228a.o(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
