package ub;

import bc.l;
import bc.s;
import bc.t;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.a0;
import okhttp3.c0;
import okhttp3.h;
import okhttp3.i;
import okhttp3.j;
import okhttp3.o;
import okhttp3.p;
import okhttp3.r;
import okhttp3.s;
import okhttp3.v;
import okhttp3.w;
import okhttp3.y;
import xb.g;

/* loaded from: classes.dex */
public final class c extends g.h implements h {

    /* renamed from: b, reason: collision with root package name */
    private final i f14561b;

    /* renamed from: c, reason: collision with root package name */
    private final c0 f14562c;

    /* renamed from: d, reason: collision with root package name */
    private Socket f14563d;

    /* renamed from: e, reason: collision with root package name */
    private Socket f14564e;

    /* renamed from: f, reason: collision with root package name */
    private p f14565f;

    /* renamed from: g, reason: collision with root package name */
    private w f14566g;

    /* renamed from: h, reason: collision with root package name */
    private xb.g f14567h;

    /* renamed from: i, reason: collision with root package name */
    private bc.e f14568i;

    /* renamed from: j, reason: collision with root package name */
    private bc.d f14569j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14570k;

    /* renamed from: l, reason: collision with root package name */
    public int f14571l;

    /* renamed from: m, reason: collision with root package name */
    public int f14572m = 1;

    /* renamed from: n, reason: collision with root package name */
    public final List<Reference<g>> f14573n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public long f14574o = Long.MAX_VALUE;

    public c(i iVar, c0 c0Var) {
        this.f14561b = iVar;
        this.f14562c = c0Var;
    }

    private void e(int i10, int i11, okhttp3.d dVar, o oVar) {
        Proxy b10 = this.f14562c.b();
        this.f14563d = (b10.type() == Proxy.Type.DIRECT || b10.type() == Proxy.Type.HTTP) ? this.f14562c.a().j().createSocket() : new Socket(b10);
        oVar.f(dVar, this.f14562c.d(), b10);
        this.f14563d.setSoTimeout(i11);
        try {
            yb.f.j().h(this.f14563d, this.f14562c.d(), i10);
            try {
                this.f14568i = l.b(l.i(this.f14563d));
                this.f14569j = l.a(l.e(this.f14563d));
            } catch (NullPointerException e10) {
                if ("throw with null exception".equals(e10.getMessage())) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f14562c.d());
            connectException.initCause(e11);
            throw connectException;
        }
    }

    private void f(b bVar) {
        SSLSocket sSLSocket;
        okhttp3.a a10 = this.f14562c.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) a10.k().createSocket(this.f14563d, a10.l().l(), a10.l().x(), true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (AssertionError e10) {
            e = e10;
        }
        try {
            j a11 = bVar.a(sSLSocket);
            if (a11.f()) {
                yb.f.j().g(sSLSocket, a10.l().l(), a10.f());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            p b10 = p.b(session);
            if (a10.e().verify(a10.l().l(), session)) {
                a10.a().a(a10.l().l(), b10.c());
                String l10 = a11.f() ? yb.f.j().l(sSLSocket) : null;
                this.f14564e = sSLSocket;
                this.f14568i = l.b(l.i(sSLSocket));
                this.f14569j = l.a(l.e(this.f14564e));
                this.f14565f = b10;
                this.f14566g = l10 != null ? w.get(l10) : w.HTTP_1_1;
                yb.f.j().a(sSLSocket);
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) b10.c().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + a10.l().l() + " not verified:\n    certificate: " + okhttp3.f.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + ac.d.a(x509Certificate));
        } catch (AssertionError e11) {
            e = e11;
            if (!sb.c.A(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                yb.f.j().a(sSLSocket2);
            }
            sb.c.h(sSLSocket2);
            throw th;
        }
    }

    private void g(int i10, int i11, int i12, okhttp3.d dVar, o oVar) {
        y i13 = i();
        r h10 = i13.h();
        for (int i14 = 0; i14 < 21; i14++) {
            e(i10, i11, dVar, oVar);
            i13 = h(i11, i12, i13, h10);
            if (i13 == null) {
                return;
            }
            sb.c.h(this.f14563d);
            this.f14563d = null;
            this.f14569j = null;
            this.f14568i = null;
            oVar.d(dVar, this.f14562c.d(), this.f14562c.b(), null);
        }
    }

    private y h(int i10, int i11, y yVar, r rVar) {
        String str = "CONNECT " + sb.c.s(rVar, true) + " HTTP/1.1";
        while (true) {
            wb.a aVar = new wb.a(null, null, this.f14568i, this.f14569j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f14568i.e().g(i10, timeUnit);
            this.f14569j.e().g(i11, timeUnit);
            aVar.o(yVar.d(), str);
            aVar.a();
            a0 c10 = aVar.f(false).p(yVar).c();
            long b10 = vb.e.b(c10);
            if (b10 == -1) {
                b10 = 0;
            }
            s k10 = aVar.k(b10);
            sb.c.D(k10, Integer.MAX_VALUE, timeUnit);
            k10.close();
            int f10 = c10.f();
            if (f10 == 200) {
                if (this.f14568i.a().z() && this.f14569j.a().z()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (f10 != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + c10.f());
            }
            y a10 = this.f14562c.a().h().a(this.f14562c, c10);
            if (a10 == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(c10.j("Connection"))) {
                return a10;
            }
            yVar = a10;
        }
    }

    private y i() {
        y a10 = new y.a().j(this.f14562c.a().l()).e("CONNECT", null).c("Host", sb.c.s(this.f14562c.a().l(), true)).c("Proxy-Connection", "Keep-Alive").c("User-Agent", sb.d.a()).a();
        y a11 = this.f14562c.a().h().a(this.f14562c, new a0.a().p(a10).n(w.HTTP_1_1).g(407).k("Preemptive Authenticate").b(sb.c.f14198c).q(-1L).o(-1L).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return a11 != null ? a11 : a10;
    }

    private void j(b bVar, int i10, okhttp3.d dVar, o oVar) {
        if (this.f14562c.a().k() != null) {
            oVar.u(dVar);
            f(bVar);
            oVar.t(dVar, this.f14565f);
            if (this.f14566g == w.HTTP_2) {
                r(i10);
                return;
            }
            return;
        }
        List<w> f10 = this.f14562c.a().f();
        w wVar = w.H2_PRIOR_KNOWLEDGE;
        if (!f10.contains(wVar)) {
            this.f14564e = this.f14563d;
            this.f14566g = w.HTTP_1_1;
        } else {
            this.f14564e = this.f14563d;
            this.f14566g = wVar;
            r(i10);
        }
    }

    private void r(int i10) {
        this.f14564e.setSoTimeout(0);
        xb.g a10 = new g.C0334g(true).d(this.f14564e, this.f14562c.a().l().l(), this.f14568i, this.f14569j).b(this).c(i10).a();
        this.f14567h = a10;
        a10.i0();
    }

    @Override // xb.g.h
    public void a(xb.g gVar) {
        synchronized (this.f14561b) {
            this.f14572m = gVar.M();
        }
    }

    @Override // xb.g.h
    public void b(xb.i iVar) {
        iVar.f(xb.b.REFUSED_STREAM);
    }

    public void c() {
        sb.c.h(this.f14563d);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(int r17, int r18, int r19, int r20, boolean r21, okhttp3.d r22, okhttp3.o r23) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.c.d(int, int, int, int, boolean, okhttp3.d, okhttp3.o):void");
    }

    public p k() {
        return this.f14565f;
    }

    public boolean l(okhttp3.a aVar, c0 c0Var) {
        if (this.f14573n.size() >= this.f14572m || this.f14570k || !sb.a.f14194a.g(this.f14562c.a(), aVar)) {
            return false;
        }
        if (aVar.l().l().equals(p().a().l().l())) {
            return true;
        }
        if (this.f14567h == null || c0Var == null || c0Var.b().type() != Proxy.Type.DIRECT || this.f14562c.b().type() != Proxy.Type.DIRECT || !this.f14562c.d().equals(c0Var.d()) || c0Var.a().e() != ac.d.f384a || !s(aVar.l())) {
            return false;
        }
        try {
            aVar.a().a(aVar.l().l(), k().c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean m(boolean z10) {
        if (this.f14564e.isClosed() || this.f14564e.isInputShutdown() || this.f14564e.isOutputShutdown()) {
            return false;
        }
        if (this.f14567h != null) {
            return !r0.H();
        }
        if (z10) {
            try {
                int soTimeout = this.f14564e.getSoTimeout();
                try {
                    this.f14564e.setSoTimeout(1);
                    return !this.f14568i.z();
                } finally {
                    this.f14564e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean n() {
        return this.f14567h != null;
    }

    public vb.c o(v vVar, s.a aVar, g gVar) {
        if (this.f14567h != null) {
            return new xb.f(vVar, aVar, gVar, this.f14567h);
        }
        this.f14564e.setSoTimeout(aVar.b());
        t e10 = this.f14568i.e();
        long b10 = aVar.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        e10.g(b10, timeUnit);
        this.f14569j.e().g(aVar.c(), timeUnit);
        return new wb.a(vVar, gVar, this.f14568i, this.f14569j);
    }

    public c0 p() {
        return this.f14562c;
    }

    public Socket q() {
        return this.f14564e;
    }

    public boolean s(r rVar) {
        if (rVar.x() != this.f14562c.a().l().x()) {
            return false;
        }
        if (rVar.l().equals(this.f14562c.a().l().l())) {
            return true;
        }
        return this.f14565f != null && ac.d.f384a.c(rVar.l(), (X509Certificate) this.f14565f.c().get(0));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f14562c.a().l().l());
        sb2.append(":");
        sb2.append(this.f14562c.a().l().x());
        sb2.append(", proxy=");
        sb2.append(this.f14562c.b());
        sb2.append(" hostAddress=");
        sb2.append(this.f14562c.d());
        sb2.append(" cipherSuite=");
        p pVar = this.f14565f;
        sb2.append(pVar != null ? pVar.a() : "none");
        sb2.append(" protocol=");
        sb2.append(this.f14566g);
        sb2.append('}');
        return sb2.toString();
    }
}
