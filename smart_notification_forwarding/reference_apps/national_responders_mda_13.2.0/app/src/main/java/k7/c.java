package k7;

import com.google.gson.e;
import com.google.gson.k;
import com.google.gson.n;
import com.google.gson.q;
import java.util.HashMap;

/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    static class a extends e5.a<HashMap<String, String[]>> {
        a() {
        }
    }

    static {
        new e();
        new a().e();
    }

    public static k a(n nVar, String str, boolean z10) {
        if (nVar.D(str)) {
            return nVar.B(str);
        }
        if (z10) {
            throw new k7.a(17, str);
        }
        return null;
    }

    public static Integer b(n nVar, String str, boolean z10) {
        return c(e(nVar, str, z10));
    }

    public static Integer c(q qVar) {
        if (qVar == null) {
            return null;
        }
        if (qVar.C()) {
            return Integer.valueOf(qVar.c());
        }
        throw new k7.a(18, qVar + " is not an Integer");
    }

    public static q d(k kVar) {
        if (kVar == null) {
            return null;
        }
        if (kVar.w()) {
            return kVar.j();
        }
        throw new k7.a(18, "json primitive");
    }

    public static q e(n nVar, String str, boolean z10) {
        return d(a(nVar, str, z10));
    }

    public static String f(n nVar, String str, boolean z10) {
        return g(e(nVar, str, z10));
    }

    public static String g(q qVar) {
        if (qVar == null) {
            return null;
        }
        if (qVar.D()) {
            return qVar.s();
        }
        throw new k7.a(18, "string");
    }
}
