package vb;

import java.util.List;
import okhttp3.a0;
import okhttp3.l;
import okhttp3.q;
import okhttp3.r;

/* loaded from: classes.dex */
public final class e {
    static {
        bc.f.t("\"\\");
        bc.f.t("\t ,=");
    }

    public static long a(q qVar) {
        return h(qVar.c("Content-Length"));
    }

    public static long b(a0 a0Var) {
        return a(a0Var.D());
    }

    public static boolean c(a0 a0Var) {
        if (a0Var.a0().f().equals("HEAD")) {
            return false;
        }
        int f10 = a0Var.f();
        return (((f10 >= 100 && f10 < 200) || f10 == 204 || f10 == 304) && b(a0Var) == -1 && !"chunked".equalsIgnoreCase(a0Var.j("Transfer-Encoding"))) ? false : true;
    }

    public static int d(String str, int i10) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public static void e(l lVar, r rVar, q qVar) {
        if (lVar == l.f12780a) {
            return;
        }
        List<okhttp3.k> f10 = okhttp3.k.f(rVar, qVar);
        if (f10.isEmpty()) {
            return;
        }
        lVar.b(rVar, f10);
    }

    public static int f(String str, int i10, String str2) {
        while (i10 < str.length() && str2.indexOf(str.charAt(i10)) == -1) {
            i10++;
        }
        return i10;
    }

    public static int g(String str, int i10) {
        char charAt;
        while (i10 < str.length() && ((charAt = str.charAt(i10)) == ' ' || charAt == '\t')) {
            i10++;
        }
        return i10;
    }

    private static long h(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }
}
