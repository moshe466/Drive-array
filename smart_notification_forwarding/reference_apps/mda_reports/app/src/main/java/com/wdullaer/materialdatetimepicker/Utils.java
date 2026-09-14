package com.wdullaer.materialdatetimepicker;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.core.content.ContextCompat;
import java.util.Calendar;

/* loaded from: classes2.dex */
public class Utils {
    public static final int FULL_ALPHA = 255;
    public static final int PULSE_ANIMATOR_DURATION = 544;
    public static final int SELECTED_ALPHA = 255;
    public static final int SELECTED_ALPHA_THEME_DARK = 255;

    public static int darkenColor(int i) {
        Color.colorToHSV(i, r0);
        float[] fArr = {0.0f, 0.0f, fArr[2] * 0.8f};
        return Color.HSVToColor(fArr);
    }

    public static int dpToPx(float f, Resources resources) {
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public static int getAccentColorFromThemeIfAvailable(Context context) {
        TypedValue typedValue = new TypedValue();
        if (Build.VERSION.SDK_INT >= 21) {
            context.getTheme().resolveAttribute(android.R.attr.colorAccent, typedValue, true);
            return typedValue.data;
        }
        int identifier = context.getResources().getIdentifier("colorAccent", "attr", context.getPackageName());
        return (identifier == 0 || !context.getTheme().resolveAttribute(identifier, typedValue, true)) ? ContextCompat.getColor(context, R.color.mdtp_accent_color) : typedValue.data;
    }

    public static ObjectAnimator getPulseAnimator(View view, float f, float f2) {
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.275f, f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.69f, f2);
        Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4));
        ofPropertyValuesHolder.setDuration(544L);
        return ofPropertyValuesHolder;
    }

    public static boolean isDarkTheme(Context context, boolean z) {
        return resolveBoolean(context, R.attr.mdtp_theme_dark, z);
    }

    private static boolean resolveBoolean(Context context, @AttrRes int i, boolean z) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getBoolean(0, z);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static Calendar trimToMidnight(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static void tryAccessibilityAnnounce(View view, CharSequence charSequence) {
        if (view == null || charSequence == null) {
            return;
        }
        view.announceForAccessibility(charSequence);
    }
}
