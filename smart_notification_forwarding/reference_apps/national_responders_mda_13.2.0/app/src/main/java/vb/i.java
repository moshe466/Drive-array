package vb;

import java.net.Proxy;
import okhttp3.r;
import okhttp3.y;

/* loaded from: classes.dex */
public final class i {
    public static String a(y yVar, Proxy.Type type) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(yVar.f());
        sb2.append(' ');
        boolean b10 = b(yVar, type);
        r h10 = yVar.h();
        if (b10) {
            sb2.append(h10);
        } else {
            sb2.append(c(h10));
        }
        sb2.append(" HTTP/1.1");
        return sb2.toString();
    }

    private static boolean b(y yVar, Proxy.Type type) {
        return !yVar.e() && type == Proxy.Type.HTTP;
    }

    public static String c(r rVar) {
        String g10 = rVar.g();
        String i10 = rVar.i();
        if (i10 == null) {
            return g10;
        }
        return g10 + '?' + i10;
    }
}
