package r9;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f13820a = new n();

    private n() {
    }

    public final String a(Constructor<?> constructor) {
        y8.k.e(constructor, "constructor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        y8.k.d(parameterTypes, "constructor.parameterTypes");
        int length = parameterTypes.length;
        int i10 = 0;
        while (i10 < length) {
            Class<?> cls = parameterTypes[i10];
            i10++;
            y8.k.d(cls, "parameterType");
            sb2.append(s9.b.c(cls));
        }
        sb2.append(")V");
        String sb3 = sb2.toString();
        y8.k.d(sb3, "sb.toString()");
        return sb3;
    }

    public final String b(Field field) {
        y8.k.e(field, "field");
        Class<?> type = field.getType();
        y8.k.d(type, "field.type");
        return s9.b.c(type);
    }

    public final String c(Method method) {
        y8.k.e(method, "method");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        y8.k.d(parameterTypes, "method.parameterTypes");
        int length = parameterTypes.length;
        int i10 = 0;
        while (i10 < length) {
            Class<?> cls = parameterTypes[i10];
            i10++;
            y8.k.d(cls, "parameterType");
            sb2.append(s9.b.c(cls));
        }
        sb2.append(")");
        Class<?> returnType = method.getReturnType();
        y8.k.d(returnType, "method.returnType");
        sb2.append(s9.b.c(returnType));
        String sb3 = sb2.toString();
        y8.k.d(sb3, "sb.toString()");
        return sb3;
    }
}
