package g7;

/* loaded from: classes.dex */
public class p {
    private static String a(b7.b bVar) {
        int i10 = 0;
        String str = "";
        while (str.length() == 0) {
            int i11 = i10 + 1;
            if (i10 >= 10) {
                break;
            }
            str = f7.b.a("appl.name", bVar);
            i10 = i11;
        }
        String a10 = f7.b.a("appl.name", bVar);
        return a10.length() > 0 ? a10 : str;
    }

    public static f7.d b(b7.b bVar) {
        return d(i7.a.f10743a, bVar);
    }

    public static f7.d c(f7.a aVar, b7.b bVar) {
        return f(bVar, aVar);
    }

    public static f7.d d(String[] strArr, b7.b bVar) {
        return c(e(bVar, strArr), bVar);
    }

    private static f7.a e(b7.b bVar, String[] strArr) {
        f7.a aVar = f7.a.ZPL;
        b7.b a10 = h7.a.a(bVar);
        if (!a10.a()) {
            throw new b7.e("Connection is not open.");
        }
        String a11 = a(a10);
        if (a11.length() != 0) {
            return i7.d.a(strArr, a11) ? f7.a.CPCL : aVar;
        }
        throw new f7.f("");
    }

    private static f7.d f(b7.b bVar, f7.a aVar) {
        return (aVar == f7.a.CPCL || aVar == f7.a.LINE_PRINT) ? new o(bVar, aVar) : new q(bVar);
    }
}
