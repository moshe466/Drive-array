package A2;

import java.lang.reflect.Method;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f67a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        j.b(methods);
        int length = methods.length;
        int i = 0;
        while (true) {
            method = null;
            Class<?> cls = null;
            if (i >= length) {
                break;
            }
            Method method2 = methods[i];
            if (j.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                j.d(parameterTypes, "getParameterTypes(...)");
                if (parameterTypes.length == 1) {
                    cls = parameterTypes[0];
                }
                if (j.a(cls, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i++;
        }
        f67a = method;
        int length2 = methods.length;
        for (int i3 = 0; i3 < length2 && !j.a(methods[i3].getName(), "getSuppressed"); i3++) {
        }
    }
}
