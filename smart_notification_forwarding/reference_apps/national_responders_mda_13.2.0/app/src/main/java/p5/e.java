package p5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static e f13087b;

    /* renamed from: a, reason: collision with root package name */
    private f f13088a;

    private e() {
    }

    public static e a() {
        if (f13087b == null) {
            f13087b = new e();
        }
        return f13087b;
    }

    private f b() {
        if (this.f13088a == null) {
            this.f13088a = new f();
        }
        return this.f13088a;
    }

    private void d(Method method) {
        StringBuilder sb2;
        String str;
        try {
            method.invoke(b(), new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException unused) {
            sb2 = new StringBuilder();
            str = "invokeJob: couldn't invoke the job '";
            sb2.append(str);
            sb2.append(method.getName());
            sb2.append("'. Error: ");
        } catch (InvocationTargetException unused2) {
            sb2 = new StringBuilder();
            str = "invokeJob: an error was thrown by the job '";
            sb2.append(str);
            sb2.append(method.getName());
            sb2.append("'. Error: ");
        }
    }

    private void e(String str) {
        try {
            d(b().getClass().getMethod(str, new Class[0]));
        } catch (NoSuchMethodException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("parseJob: no such job '");
            sb2.append(str);
            sb2.append("'. Error: ");
        } catch (SecurityException unused2) {
        }
    }

    public void c(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        e(str);
    }
}
