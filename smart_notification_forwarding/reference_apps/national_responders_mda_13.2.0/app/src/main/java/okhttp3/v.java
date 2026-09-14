package okhttp3;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.a0;
import okhttp3.o;
import okhttp3.q;

/* loaded from: classes.dex */
public class v implements Cloneable {
    static final List<w> G = sb.c.u(w.HTTP_2, w.HTTP_1_1);
    static final List<j> H = sb.c.u(j.f12757g, j.f12758h);
    final boolean A;
    final int B;
    final int C;
    final int D;
    final int E;
    final int F;

    /* renamed from: f, reason: collision with root package name */
    final m f12834f;

    /* renamed from: g, reason: collision with root package name */
    final Proxy f12835g;

    /* renamed from: h, reason: collision with root package name */
    final List<w> f12836h;

    /* renamed from: i, reason: collision with root package name */
    final List<j> f12837i;

    /* renamed from: j, reason: collision with root package name */
    final List<s> f12838j;

    /* renamed from: k, reason: collision with root package name */
    final List<s> f12839k;

    /* renamed from: l, reason: collision with root package name */
    final o.c f12840l;

    /* renamed from: m, reason: collision with root package name */
    final ProxySelector f12841m;

    /* renamed from: n, reason: collision with root package name */
    final l f12842n;

    /* renamed from: o, reason: collision with root package name */
    final tb.d f12843o;

    /* renamed from: p, reason: collision with root package name */
    final SocketFactory f12844p;

    /* renamed from: q, reason: collision with root package name */
    final SSLSocketFactory f12845q;

    /* renamed from: r, reason: collision with root package name */
    final ac.c f12846r;

    /* renamed from: s, reason: collision with root package name */
    final HostnameVerifier f12847s;

    /* renamed from: t, reason: collision with root package name */
    final f f12848t;

    /* renamed from: u, reason: collision with root package name */
    final okhttp3.b f12849u;

    /* renamed from: v, reason: collision with root package name */
    final okhttp3.b f12850v;

    /* renamed from: w, reason: collision with root package name */
    final i f12851w;

    /* renamed from: x, reason: collision with root package name */
    final n f12852x;

    /* renamed from: y, reason: collision with root package name */
    final boolean f12853y;

    /* renamed from: z, reason: collision with root package name */
    final boolean f12854z;

    /* loaded from: classes.dex */
    class a extends sb.a {
        a() {
        }

        @Override // sb.a
        public void a(q.a aVar, String str) {
            aVar.b(str);
        }

        @Override // sb.a
        public void b(q.a aVar, String str, String str2) {
            aVar.c(str, str2);
        }

        @Override // sb.a
        public void c(j jVar, SSLSocket sSLSocket, boolean z10) {
            jVar.a(sSLSocket, z10);
        }

        @Override // sb.a
        public int d(a0.a aVar) {
            return aVar.f12672c;
        }

        @Override // sb.a
        public boolean e(i iVar, ub.c cVar) {
            return iVar.b(cVar);
        }

        @Override // sb.a
        public Socket f(i iVar, okhttp3.a aVar, ub.g gVar) {
            return iVar.c(aVar, gVar);
        }

        @Override // sb.a
        public boolean g(okhttp3.a aVar, okhttp3.a aVar2) {
            return aVar.d(aVar2);
        }

        @Override // sb.a
        public ub.c h(i iVar, okhttp3.a aVar, ub.g gVar, c0 c0Var) {
            return iVar.d(aVar, gVar, c0Var);
        }

        @Override // sb.a
        public void i(i iVar, ub.c cVar) {
            iVar.f(cVar);
        }

        @Override // sb.a
        public ub.d j(i iVar) {
            return iVar.f12744e;
        }

        @Override // sb.a
        public IOException k(d dVar, IOException iOException) {
            return ((x) dVar).m(iOException);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        int A;

        /* renamed from: a, reason: collision with root package name */
        m f12855a;

        /* renamed from: b, reason: collision with root package name */
        Proxy f12856b;

        /* renamed from: c, reason: collision with root package name */
        List<w> f12857c;

        /* renamed from: d, reason: collision with root package name */
        List<j> f12858d;

        /* renamed from: e, reason: collision with root package name */
        final List<s> f12859e;

        /* renamed from: f, reason: collision with root package name */
        final List<s> f12860f;

        /* renamed from: g, reason: collision with root package name */
        o.c f12861g;

        /* renamed from: h, reason: collision with root package name */
        ProxySelector f12862h;

        /* renamed from: i, reason: collision with root package name */
        l f12863i;

        /* renamed from: j, reason: collision with root package name */
        tb.d f12864j;

        /* renamed from: k, reason: collision with root package name */
        SocketFactory f12865k;

        /* renamed from: l, reason: collision with root package name */
        SSLSocketFactory f12866l;

        /* renamed from: m, reason: collision with root package name */
        ac.c f12867m;

        /* renamed from: n, reason: collision with root package name */
        HostnameVerifier f12868n;

        /* renamed from: o, reason: collision with root package name */
        f f12869o;

        /* renamed from: p, reason: collision with root package name */
        okhttp3.b f12870p;

        /* renamed from: q, reason: collision with root package name */
        okhttp3.b f12871q;

        /* renamed from: r, reason: collision with root package name */
        i f12872r;

        /* renamed from: s, reason: collision with root package name */
        n f12873s;

        /* renamed from: t, reason: collision with root package name */
        boolean f12874t;

        /* renamed from: u, reason: collision with root package name */
        boolean f12875u;

        /* renamed from: v, reason: collision with root package name */
        boolean f12876v;

        /* renamed from: w, reason: collision with root package name */
        int f12877w;

        /* renamed from: x, reason: collision with root package name */
        int f12878x;

        /* renamed from: y, reason: collision with root package name */
        int f12879y;

        /* renamed from: z, reason: collision with root package name */
        int f12880z;

        public b() {
            this.f12859e = new ArrayList();
            this.f12860f = new ArrayList();
            this.f12855a = new m();
            this.f12857c = v.G;
            this.f12858d = v.H;
            this.f12861g = o.k(o.f12789a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f12862h = proxySelector;
            if (proxySelector == null) {
                this.f12862h = new zb.a();
            }
            this.f12863i = l.f12780a;
            this.f12865k = SocketFactory.getDefault();
            this.f12868n = ac.d.f384a;
            this.f12869o = f.f12710c;
            okhttp3.b bVar = okhttp3.b.f12682a;
            this.f12870p = bVar;
            this.f12871q = bVar;
            this.f12872r = new i();
            this.f12873s = n.f12788a;
            this.f12874t = true;
            this.f12875u = true;
            this.f12876v = true;
            this.f12877w = 0;
            this.f12878x = 10000;
            this.f12879y = 10000;
            this.f12880z = 10000;
            this.A = 0;
        }

        b(v vVar) {
            ArrayList arrayList = new ArrayList();
            this.f12859e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f12860f = arrayList2;
            this.f12855a = vVar.f12834f;
            this.f12856b = vVar.f12835g;
            this.f12857c = vVar.f12836h;
            this.f12858d = vVar.f12837i;
            arrayList.addAll(vVar.f12838j);
            arrayList2.addAll(vVar.f12839k);
            this.f12861g = vVar.f12840l;
            this.f12862h = vVar.f12841m;
            this.f12863i = vVar.f12842n;
            this.f12864j = vVar.f12843o;
            this.f12865k = vVar.f12844p;
            this.f12866l = vVar.f12845q;
            this.f12867m = vVar.f12846r;
            this.f12868n = vVar.f12847s;
            this.f12869o = vVar.f12848t;
            this.f12870p = vVar.f12849u;
            this.f12871q = vVar.f12850v;
            this.f12872r = vVar.f12851w;
            this.f12873s = vVar.f12852x;
            this.f12874t = vVar.f12853y;
            this.f12875u = vVar.f12854z;
            this.f12876v = vVar.A;
            this.f12877w = vVar.B;
            this.f12878x = vVar.C;
            this.f12879y = vVar.D;
            this.f12880z = vVar.E;
            this.A = vVar.F;
        }

        public v a() {
            return new v(this);
        }

        public b b(long j10, TimeUnit timeUnit) {
            this.f12877w = sb.c.e("timeout", j10, timeUnit);
            return this;
        }

        public b c(f fVar) {
            Objects.requireNonNull(fVar, "certificatePinner == null");
            this.f12869o = fVar;
            return this;
        }
    }

    static {
        sb.a.f14194a = new a();
    }

    public v() {
        this(new b());
    }

    v(b bVar) {
        boolean z10;
        ac.c cVar;
        this.f12834f = bVar.f12855a;
        this.f12835g = bVar.f12856b;
        this.f12836h = bVar.f12857c;
        List<j> list = bVar.f12858d;
        this.f12837i = list;
        this.f12838j = sb.c.t(bVar.f12859e);
        this.f12839k = sb.c.t(bVar.f12860f);
        this.f12840l = bVar.f12861g;
        this.f12841m = bVar.f12862h;
        this.f12842n = bVar.f12863i;
        this.f12843o = bVar.f12864j;
        this.f12844p = bVar.f12865k;
        Iterator<j> it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z10 = z10 || it.next().d();
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f12866l;
        if (sSLSocketFactory == null && z10) {
            X509TrustManager C = sb.c.C();
            this.f12845q = x(C);
            cVar = ac.c.b(C);
        } else {
            this.f12845q = sSLSocketFactory;
            cVar = bVar.f12867m;
        }
        this.f12846r = cVar;
        if (this.f12845q != null) {
            yb.f.j().f(this.f12845q);
        }
        this.f12847s = bVar.f12868n;
        this.f12848t = bVar.f12869o.f(this.f12846r);
        this.f12849u = bVar.f12870p;
        this.f12850v = bVar.f12871q;
        this.f12851w = bVar.f12872r;
        this.f12852x = bVar.f12873s;
        this.f12853y = bVar.f12874t;
        this.f12854z = bVar.f12875u;
        this.A = bVar.f12876v;
        this.B = bVar.f12877w;
        this.C = bVar.f12878x;
        this.D = bVar.f12879y;
        this.E = bVar.f12880z;
        this.F = bVar.A;
        if (this.f12838j.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f12838j);
        }
        if (this.f12839k.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f12839k);
        }
    }

    private static SSLSocketFactory x(X509TrustManager x509TrustManager) {
        try {
            SSLContext k10 = yb.f.j().k();
            k10.init(null, new TrustManager[]{x509TrustManager}, null);
            return k10.getSocketFactory();
        } catch (GeneralSecurityException e10) {
            throw sb.c.b("No System TLS", e10);
        }
    }

    public Proxy A() {
        return this.f12835g;
    }

    public okhttp3.b B() {
        return this.f12849u;
    }

    public ProxySelector C() {
        return this.f12841m;
    }

    public int E() {
        return this.D;
    }

    public boolean F() {
        return this.A;
    }

    public SocketFactory G() {
        return this.f12844p;
    }

    public SSLSocketFactory I() {
        return this.f12845q;
    }

    public int J() {
        return this.E;
    }

    public okhttp3.b a() {
        return this.f12850v;
    }

    public int b() {
        return this.B;
    }

    public f d() {
        return this.f12848t;
    }

    public int e() {
        return this.C;
    }

    public i h() {
        return this.f12851w;
    }

    public List<j> i() {
        return this.f12837i;
    }

    public l k() {
        return this.f12842n;
    }

    public m l() {
        return this.f12834f;
    }

    public n m() {
        return this.f12852x;
    }

    public o.c n() {
        return this.f12840l;
    }

    public boolean o() {
        return this.f12854z;
    }

    public boolean p() {
        return this.f12853y;
    }

    public HostnameVerifier q() {
        return this.f12847s;
    }

    public List<s> r() {
        return this.f12838j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public tb.d s() {
        return this.f12843o;
    }

    public List<s> t() {
        return this.f12839k;
    }

    public b u() {
        return new b(this);
    }

    public d w(y yVar) {
        return x.k(this, yVar, false);
    }

    public int y() {
        return this.F;
    }

    public List<w> z() {
        return this.f12836h;
    }
}
