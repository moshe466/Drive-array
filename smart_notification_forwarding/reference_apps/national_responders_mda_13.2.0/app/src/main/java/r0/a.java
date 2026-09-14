package r0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f13642a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f13643b;

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.b();
        }
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to call ");
        sb2.append(str);
        sb2.append(" via reflection");
    }

    @SuppressLint({"NewApi"})
    public static boolean d() {
        try {
            if (f13643b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f13643b == null) {
                    f13642a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    f13643b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) f13643b.invoke(null, Long.valueOf(f13642a))).booleanValue();
            } catch (Exception e10) {
                c("isTagEnabled", e10);
            }
        }
        return false;
    }
}
