package yb;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: c, reason: collision with root package name */
    private final e<Socket> f16006c;

    /* renamed from: d, reason: collision with root package name */
    private final e<Socket> f16007d;

    /* renamed from: e, reason: collision with root package name */
    private final e<Socket> f16008e;

    /* renamed from: f, reason: collision with root package name */
    private final e<Socket> f16009f;

    /* renamed from: g, reason: collision with root package name */
    private final c f16010g = c.b();

    /* renamed from: yb.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0339a extends ac.c {

        /* renamed from: a, reason: collision with root package name */
        private final Object f16011a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f16012b;

        C0339a(Object obj, Method method) {
            this.f16011a = obj;
            this.f16012b = method;
        }

        @Override // ac.c
        public List<Certificate> a(List<Certificate> list, String str) {
            try {
                return (List) this.f16012b.invoke(this.f16011a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e11.getMessage());
                sSLPeerUnverifiedException.initCause(e11);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0339a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    static final class b implements ac.e {

        /* renamed from: a, reason: collision with root package name */
        private final X509TrustManager f16013a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f16014b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f16014b = method;
            this.f16013a = x509TrustManager;
        }

        @Override // ac.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f16014b.invoke(this.f16013a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e10) {
                throw sb.c.b("unable to get issues and signature", e10);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f16013a.equals(bVar.f16013a) && this.f16014b.equals(bVar.f16014b);
        }

        public int hashCode() {
            return this.f16013a.hashCode() + (this.f16014b.hashCode() * 31);
        }
    }

    /* loaded from: classes.dex */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Method f16015a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f16016b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f16017c;

        c(Method method, Method method2, Method method3) {
            this.f16015a = method;
            this.f16016b = method2;
            this.f16017c = method3;
        }

        static c b() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }

        Object a(String str) {
            Method method = this.f16015a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f16016b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean c(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f16017c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    a(Class<?> cls, e<Socket> eVar, e<Socket> eVar2, e<Socket> eVar3, e<Socket> eVar4) {
        this.f16006c = eVar;
        this.f16007d = eVar2;
        this.f16008e = eVar3;
        this.f16009f = eVar4;
    }

    private boolean r(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.n(str);
        }
    }

    private boolean s(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return r(str, cls, obj);
        }
    }

    public static f t() {
        Class<?> cls;
        e eVar;
        e eVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            e eVar3 = new e(null, "setUseSessionTickets", Boolean.TYPE);
            e eVar4 = new e(null, "setHostname", String.class);
            if (u()) {
                e eVar5 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                eVar2 = new e(null, "setAlpnProtocols", byte[].class);
                eVar = eVar5;
            } else {
                eVar = null;
                eVar2 = null;
            }
            return new a(cls2, eVar3, eVar4, eVar, eVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    private static boolean u() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // yb.f
    public ac.c c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0339a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // yb.f
    public ac.e d(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    @Override // yb.f
    public void g(SSLSocket sSLSocket, String str, List<w> list) {
        if (str != null) {
            this.f16006c.e(sSLSocket, Boolean.TRUE);
            this.f16007d.e(sSLSocket, str);
        }
        e<Socket> eVar = this.f16009f;
        if (eVar == null || !eVar.g(sSLSocket)) {
            return;
        }
        this.f16009f.f(sSLSocket, f.e(list));
    }

    @Override // yb.f
    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i10) {
        try {
            socket.connect(inetSocketAddress, i10);
        } catch (AssertionError e10) {
            if (!sb.c.A(e10)) {
                throw e10;
            }
            throw new IOException(e10);
        } catch (ClassCastException e11) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e11;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e11);
            throw iOException;
        } catch (SecurityException e12) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e12);
            throw iOException2;
        }
    }

    @Override // yb.f
    public SSLContext k() {
        boolean z10 = true;
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 16 || i10 >= 22) {
                z10 = false;
            }
        } catch (NoClassDefFoundError unused) {
        }
        if (z10) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("No TLS provider", e10);
        }
    }

    @Override // yb.f
    public String l(SSLSocket sSLSocket) {
        byte[] bArr;
        e<Socket> eVar = this.f16008e;
        if (eVar == null || !eVar.g(sSLSocket) || (bArr = (byte[]) this.f16008e.f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, sb.c.f14204i);
    }

    @Override // yb.f
    public Object m(String str) {
        return this.f16010g.a(str);
    }

    @Override // yb.f
    public boolean n(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return s(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.n(str);
        } catch (IllegalAccessException e10) {
            e = e10;
            throw sb.c.b("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e11) {
            e = e11;
            throw sb.c.b("unable to determine cleartext support", e);
        } catch (InvocationTargetException e12) {
            e = e12;
            throw sb.c.b("unable to determine cleartext support", e);
        }
    }

    @Override // yb.f
    public void p(int i10, String str, Throwable th) {
        int min;
        int i11 = i10 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i12 = 0;
        int length = str.length();
        while (i12 < length) {
            int indexOf = str.indexOf(10, i12);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i12 + 4000);
                Log.println(i11, "OkHttp", str.substring(i12, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i12 = min;
                }
            }
            i12 = min + 1;
        }
    }

    @Override // yb.f
    public void q(String str, Object obj) {
        if (this.f16010g.c(obj)) {
            return;
        }
        p(5, str, null);
    }
}
