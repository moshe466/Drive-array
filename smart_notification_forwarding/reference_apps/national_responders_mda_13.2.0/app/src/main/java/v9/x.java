package v9;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f14811a = new x();

    /* renamed from: b, reason: collision with root package name */
    public static final la.b f14812b = new la.b("kotlin.jvm.JvmField");

    static {
        y8.k.d(la.a.m(new la.b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl")), "topLevel(FqName(\"kotlin.reflect.jvm.internal.ReflectionFactoryImpl\"))");
    }

    private x() {
    }

    public static final String a(String str) {
        y8.k.e(str, "propertyName");
        return e(str) ? str : y8.k.j("get", hb.a.a(str));
    }

    public static final boolean b(String str) {
        boolean w10;
        boolean w11;
        y8.k.e(str, "name");
        w10 = mb.r.w(str, "get", false, 2, null);
        if (!w10) {
            w11 = mb.r.w(str, "is", false, 2, null);
            if (!w11) {
                return false;
            }
        }
        return true;
    }

    public static final boolean c(String str) {
        boolean w10;
        y8.k.e(str, "name");
        w10 = mb.r.w(str, "set", false, 2, null);
        return w10;
    }

    public static final String d(String str) {
        String a10;
        y8.k.e(str, "propertyName");
        if (e(str)) {
            a10 = str.substring(2);
            y8.k.d(a10, "(this as java.lang.String).substring(startIndex)");
        } else {
            a10 = hb.a.a(str);
        }
        return y8.k.j("set", a10);
    }

    public static final boolean e(String str) {
        boolean w10;
        y8.k.e(str, "name");
        w10 = mb.r.w(str, "is", false, 2, null);
        if (!w10 || str.length() == 2) {
            return false;
        }
        char charAt = str.charAt(2);
        return y8.k.f(97, charAt) > 0 || y8.k.f(charAt, 122) > 0;
    }
}
