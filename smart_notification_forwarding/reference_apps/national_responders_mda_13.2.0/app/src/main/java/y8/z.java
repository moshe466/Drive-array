package y8;

import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public class z {
    public static Collection a(Object obj) {
        if ((obj instanceof z8.a) && !(obj instanceof z8.b)) {
            g(obj, "kotlin.collections.MutableCollection");
        }
        return c(obj);
    }

    public static Set b(Object obj) {
        if ((obj instanceof z8.a) && !(obj instanceof z8.c)) {
            g(obj, "kotlin.collections.MutableSet");
        }
        return d(obj);
    }

    public static Collection c(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e10) {
            throw f(e10);
        }
    }

    public static Set d(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e10) {
            throw f(e10);
        }
    }

    private static <T extends Throwable> T e(T t10) {
        return (T) k.i(t10, z.class.getName());
    }

    public static ClassCastException f(ClassCastException classCastException) {
        throw ((ClassCastException) e(classCastException));
    }

    public static void g(Object obj, String str) {
        h((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void h(String str) {
        throw f(new ClassCastException(str));
    }
}
