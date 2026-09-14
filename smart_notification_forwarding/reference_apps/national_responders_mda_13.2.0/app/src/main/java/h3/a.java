package h3;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f10447a;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f10448b;

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f10449c;

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f10450d;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f10451e;

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f10452f;

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f10453g;

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f10454h;

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f10455i;

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f10456j;

    static {
        f10447a = Build.VERSION.SDK_INT >= 21;
        f10448b = new int[]{R.attr.state_pressed};
        f10449c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        f10450d = new int[]{R.attr.state_focused};
        f10451e = new int[]{R.attr.state_hovered};
        f10452f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        f10453g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        f10454h = new int[]{R.attr.state_selected, R.attr.state_focused};
        f10455i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        f10456j = new int[]{R.attr.state_selected};
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f10447a) {
            return new ColorStateList(new int[][]{f10456j, StateSet.NOTHING}, new int[]{c(colorStateList, f10452f), c(colorStateList, f10448b)});
        }
        int[] iArr = f10452f;
        int[] iArr2 = f10453g;
        int[] iArr3 = f10454h;
        int[] iArr4 = f10455i;
        int[] iArr5 = f10448b;
        int[] iArr6 = f10449c;
        int[] iArr7 = f10450d;
        int[] iArr8 = f10451e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f10456j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @TargetApi(21)
    private static int b(int i10) {
        return androidx.core.graphics.a.f(i10, Math.min(Color.alpha(i10) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f10447a ? b(colorForState) : colorForState;
    }
}
