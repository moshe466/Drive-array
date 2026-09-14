package vb;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.a0;
import okhttp3.c0;
import okhttp3.o;
import okhttp3.r;
import okhttp3.s;
import okhttp3.v;
import okhttp3.y;

/* loaded from: classes.dex */
public final class j implements s {

    /* renamed from: a, reason: collision with root package name */
    private final v f14871a;

    /* renamed from: b, reason: collision with root package name */
    private volatile ub.g f14872b;

    /* renamed from: c, reason: collision with root package name */
    private Object f14873c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f14874d;

    public j(v vVar, boolean z10) {
        this.f14871a = vVar;
    }

    private okhttp3.a c(r rVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        okhttp3.f fVar;
        if (rVar.m()) {
            SSLSocketFactory I = this.f14871a.I();
            hostnameVerifier = this.f14871a.q();
            sSLSocketFactory = I;
            fVar = this.f14871a.d();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            fVar = null;
        }
        return new okhttp3.a(rVar.l(), rVar.x(), this.f14871a.m(), this.f14871a.G(), sSLSocketFactory, hostnameVerifier, fVar, this.f14871a.B(), this.f14871a.A(), this.f14871a.z(), this.f14871a.i(), this.f14871a.C());
    }

    private y d(a0 a0Var, c0 c0Var) {
        String j10;
        r B;
        if (a0Var == null) {
            throw new IllegalStateException();
        }
        int f10 = a0Var.f();
        String f11 = a0Var.a0().f();
        if (f10 == 307 || f10 == 308) {
            if (!f11.equals("GET") && !f11.equals("HEAD")) {
                return null;
            }
        } else {
            if (f10 == 401) {
                return this.f14871a.a().a(c0Var, a0Var);
            }
            if (f10 == 503) {
                if ((a0Var.N() == null || a0Var.N().f() != 503) && h(a0Var, Integer.MAX_VALUE) == 0) {
                    return a0Var.a0();
                }
                return null;
            }
            if (f10 == 407) {
                if ((c0Var != null ? c0Var.b() : this.f14871a.A()).type() == Proxy.Type.HTTP) {
                    return this.f14871a.B().a(c0Var, a0Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (f10 == 408) {
                if (!this.f14871a.F()) {
                    return null;
                }
                a0Var.a0().a();
                if ((a0Var.N() == null || a0Var.N().f() != 408) && h(a0Var, 0) <= 0) {
                    return a0Var.a0();
                }
                return null;
            }
            switch (f10) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f14871a.o() || (j10 = a0Var.j("Location")) == null || (B = a0Var.a0().h().B(j10)) == null) {
            return null;
        }
        if (!B.C().equals(a0Var.a0().h().C()) && !this.f14871a.p()) {
            return null;
        }
        y.a g10 = a0Var.a0().g();
        if (f.b(f11)) {
            boolean d10 = f.d(f11);
            if (f.c(f11)) {
                g10.e("GET", null);
            } else {
                g10.e(f11, d10 ? a0Var.a0().a() : null);
            }
            if (!d10) {
                g10.g("Transfer-Encoding");
                g10.g("Content-Length");
                g10.g("Content-Type");
            }
        }
        if (!i(a0Var, B)) {
            g10.g("Authorization");
        }
        return g10.j(B).a();
    }

    private boolean f(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean g(IOException iOException, ub.g gVar, boolean z10, y yVar) {
        gVar.q(iOException);
        if (!this.f14871a.F()) {
            return false;
        }
        if (z10) {
            yVar.a();
        }
        return f(iOException, z10) && gVar.h();
    }

    private int h(a0 a0Var, int i10) {
        String j10 = a0Var.j("Retry-After");
        if (j10 == null) {
            return i10;
        }
        if (j10.matches("\\d+")) {
            return Integer.valueOf(j10).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean i(a0 a0Var, r rVar) {
        r h10 = a0Var.a0().h();
        return h10.l().equals(rVar.l()) && h10.x() == rVar.x() && h10.C().equals(rVar.C());
    }

    @Override // okhttp3.s
    public a0 a(s.a aVar) {
        a0 j10;
        y d10;
        y e10 = aVar.e();
        g gVar = (g) aVar;
        okhttp3.d f10 = gVar.f();
        o h10 = gVar.h();
        ub.g gVar2 = new ub.g(this.f14871a.h(), c(e10.h()), f10, h10, this.f14873c);
        this.f14872b = gVar2;
        a0 a0Var = null;
        int i10 = 0;
        while (!this.f14874d) {
            try {
                try {
                    j10 = gVar.j(e10, gVar2, null, null);
                    if (a0Var != null) {
                        j10 = j10.M().m(a0Var.M().b(null).c()).c();
                    }
                    try {
                        d10 = d(j10, gVar2.o());
                    } catch (IOException e11) {
                        gVar2.k();
                        throw e11;
                    }
                } catch (IOException e12) {
                    if (!g(e12, gVar2, !(e12 instanceof xb.a), e10)) {
                        throw e12;
                    }
                } catch (ub.e e13) {
                    if (!g(e13.c(), gVar2, false, e10)) {
                        throw e13.b();
                    }
                }
                if (d10 == null) {
                    gVar2.k();
                    return j10;
                }
                sb.c.g(j10.c());
                int i11 = i10 + 1;
                if (i11 > 20) {
                    gVar2.k();
                    throw new ProtocolException("Too many follow-up requests: " + i11);
                }
                d10.a();
                if (!i(j10, d10.h())) {
                    gVar2.k();
                    gVar2 = new ub.g(this.f14871a.h(), c(d10.h()), f10, h10, this.f14873c);
                    this.f14872b = gVar2;
                } else if (gVar2.c() != null) {
                    throw new IllegalStateException("Closing the body of " + j10 + " didn't close its backing stream. Bad interceptor?");
                }
                a0Var = j10;
                e10 = d10;
                i10 = i11;
            } catch (Throwable th) {
                gVar2.q(null);
                gVar2.k();
                throw th;
            }
        }
        gVar2.k();
        throw new IOException("Canceled");
    }

    public void b() {
        this.f14874d = true;
        ub.g gVar = this.f14872b;
        if (gVar != null) {
            gVar.b();
        }
    }

    public boolean e() {
        return this.f14874d;
    }

    public void j(Object obj) {
        this.f14873c = obj;
    }
}
