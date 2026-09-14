package androidx.core.app;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class f {

    /* loaded from: classes.dex */
    static class a {
        static IBinder a(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        static void b(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private static Method f2201a;

        /* renamed from: b, reason: collision with root package name */
        private static boolean f2202b;

        public static IBinder a(Bundle bundle, String str) {
            if (!f2202b) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", String.class);
                    f2201a = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f2202b = true;
            }
            Method method2 = f2201a;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    f2201a = null;
                }
            }
            return null;
        }
    }

    public static IBinder a(Bundle bundle, String str) {
        return Build.VERSION.SDK_INT >= 18 ? a.a(bundle, str) : b.a(bundle, str);
    }
}
