package yb;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.v;
import okhttp3.w;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final f f16031a = i();

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f16032b = Logger.getLogger(v.class.getName());

    public static List<String> b(List<w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            w wVar = list.get(i10);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] e(List<w> list) {
        bc.c cVar = new bc.c();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            w wVar = list.get(i10);
            if (wVar != w.HTTP_1_0) {
                cVar.A(wVar.toString().length());
                cVar.S(wVar.toString());
            }
        }
        return cVar.h0();
    }

    private static f i() {
        b r10;
        f t10 = a.t();
        if (t10 != null) {
            return t10;
        }
        if (o() && (r10 = b.r()) != null) {
            return r10;
        }
        c r11 = c.r();
        if (r11 != null) {
            return r11;
        }
        f r12 = d.r();
        return r12 != null ? r12 : new f();
    }

    public static f j() {
        return f16031a;
    }

    public static boolean o() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public void a(SSLSocket sSLSocket) {
    }

    public ac.c c(X509TrustManager x509TrustManager) {
        return new ac.a(d(x509TrustManager));
    }

    public ac.e d(X509TrustManager x509TrustManager) {
        return new ac.b(x509TrustManager.getAcceptedIssuers());
    }

    public void f(SSLSocketFactory sSLSocketFactory) {
    }

    public void g(SSLSocket sSLSocket, String str, List<w> list) {
    }

    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i10) {
        socket.connect(inetSocketAddress, i10);
    }

    public SSLContext k() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("No TLS provider", e10);
        }
    }

    public String l(SSLSocket sSLSocket) {
        return null;
    }

    public Object m(String str) {
        if (f16032b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean n(String str) {
        return true;
    }

    public void p(int i10, String str, Throwable th) {
        f16032b.log(i10 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void q(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        p(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
