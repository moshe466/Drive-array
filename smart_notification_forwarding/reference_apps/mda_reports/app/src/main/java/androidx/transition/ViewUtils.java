package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewUtils {
    private static final ViewUtilsBase IMPL;
    private static final String TAG = "ViewUtils";
    private static final int VISIBILITY_MASK = 12;
    static final Property<View, Float> a;
    static final Property<View, Rect> b;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;

    static {
        int i = Build.VERSION.SDK_INT;
        IMPL = i >= 22 ? new ViewUtilsApi22() : i >= 21 ? new ViewUtilsApi21() : i >= 19 ? new ViewUtilsApi19() : new ViewUtilsBase();
        a = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ViewUtils.1
            @Override // android.util.Property
            public Float get(View view) {
                return Float.valueOf(ViewUtils.c(view));
            }

            @Override // android.util.Property
            public void set(View view, Float f) {
                ViewUtils.a(view, f.floatValue());
            }
        };
        b = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ViewUtils.2
            @Override // android.util.Property
            public Rect get(View view) {
                return ViewCompat.getClipBounds(view);
            }

            @Override // android.util.Property
            public void set(View view, Rect rect) {
                ViewCompat.setClipBounds(view, rect);
            }
        };
    }

    private ViewUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull View view, int i) {
        fetchViewFlagsField();
        Field field = sViewFlagsField;
        if (field != null) {
            try {
                sViewFlagsField.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull View view, @Nullable Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewOverlayImpl b(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 18 ? new ViewOverlayApi18(view) : ViewOverlayApi14.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(@NonNull View view) {
        return IMPL.getTransitionAlpha(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WindowIdImpl d(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 18 ? new WindowIdApi18(view) : new WindowIdApi14(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(@NonNull View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    private static void fetchViewFlagsField() {
        if (sViewFlagsFieldFetched) {
            return;
        }
        try {
            sViewFlagsField = View.class.getDeclaredField("mViewFlags");
            sViewFlagsField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i(TAG, "fetchViewFlagsField: ");
        }
        sViewFlagsFieldFetched = true;
    }
}
