package s0;

import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class z {

    /* renamed from: a, reason: collision with root package name */
    private static Method f14000a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f14001b;

    private static void a() {
        if (f14001b) {
            return;
        }
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            f14000a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        f14001b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ViewGroup viewGroup, boolean z10) {
        a();
        Method method = f14000a;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z10));
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
