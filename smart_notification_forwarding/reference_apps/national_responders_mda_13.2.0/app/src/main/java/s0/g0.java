package s0;

import android.annotation.SuppressLint;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class g0 extends f0 {

    /* renamed from: i, reason: collision with root package name */
    private static Method f13916i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f13917j;

    @SuppressLint({"PrivateApi"})
    private void l() {
        if (f13917j) {
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = View.class.getDeclaredMethod("setLeftTopRightBottom", cls, cls, cls, cls);
            f13916i = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        f13917j = true;
    }

    @Override // s0.h0
    public void d(View view, int i10, int i11, int i12, int i13) {
        l();
        Method method = f13916i;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
    }
}
