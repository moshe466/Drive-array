package n1;

/* loaded from: classes.dex */
public final class a {
    public static void a(String str, String str2, Object obj) {
        d(str);
        String.format(str2, obj);
    }

    public static void b(String str, String str2, Object... objArr) {
        d(str);
        String.format(str2, objArr);
    }

    public static void c(String str, String str2, Throwable th) {
        d(str);
    }

    private static String d(String str) {
        return "TransportRuntime." + str;
    }

    public static void e(String str, String str2) {
        d(str);
    }

    public static void f(String str, String str2, Object obj) {
        d(str);
        String.format(str2, obj);
    }
}
