package q0;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class z extends m3.b {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f6141d = true;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f6142e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f6143f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f6144g = true;

    @Override // m3.b
    public void P(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.P(view, i);
        } else if (f6144g) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                f6144g = false;
            }
        }
    }

    public void Y(View view, int i, int i3, int i4, int i5) {
        if (f6143f) {
            try {
                view.setLeftTopRightBottom(i, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                f6143f = false;
            }
        }
    }

    public void Z(View view, Matrix matrix) {
        if (f6141d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f6141d = false;
            }
        }
    }

    public void a0(View view, Matrix matrix) {
        if (f6142e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f6142e = false;
            }
        }
    }
}
