package v7;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static u7.e f14711a;

    public static void a(String str, String str2) {
        u7.e eVar = f14711a;
        if (eVar == null) {
            return;
        }
        eVar.c(str, str2);
    }

    public static void b(String str, Throwable th) {
        u7.e eVar = f14711a;
        if (eVar == null) {
            return;
        }
        eVar.a(str, th);
    }

    public static void c(String str, String str2) {
        u7.e eVar = f14711a;
        if (eVar == null) {
            return;
        }
        eVar.b(str, str2);
    }

    public static void d(String str, String str2, Object... objArr) {
        c(str, String.format(str2, objArr));
    }

    public static void e(u7.e eVar) {
        f14711a = eVar;
    }
}
