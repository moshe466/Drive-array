package s0;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class f0 extends e0 {

    /* renamed from: e, reason: collision with root package name */
    private static Method f13912e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f13913f;

    /* renamed from: g, reason: collision with root package name */
    private static Method f13914g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f13915h;

    private void j() {
        if (f13913f) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            f13912e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        f13913f = true;
    }

    private void k() {
        if (f13915h) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            f13914g = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        f13915h = true;
    }

    @Override // s0.h0
    public void f(View view, Matrix matrix) {
        j();
        Method method = f13912e;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
    }

    @Override // s0.h0
    public void g(View view, Matrix matrix) {
        k();
        Method method = f13914g;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
    }
}
