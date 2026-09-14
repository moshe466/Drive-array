package xb;

import bc.r;
import bc.t;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.q;
import okhttp3.s;
import okhttp3.v;
import okhttp3.w;
import okhttp3.y;

/* loaded from: classes.dex */
public final class f implements vb.c {

    /* renamed from: f, reason: collision with root package name */
    private static final List<String> f15705f = sb.c.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: g, reason: collision with root package name */
    private static final List<String> f15706g = sb.c.u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    private final s.a f15707a;

    /* renamed from: b, reason: collision with root package name */
    final ub.g f15708b;

    /* renamed from: c, reason: collision with root package name */
    private final g f15709c;

    /* renamed from: d, reason: collision with root package name */
    private i f15710d;

    /* renamed from: e, reason: collision with root package name */
    private final w f15711e;

    /* loaded from: classes.dex */
    class a extends bc.h {

        /* renamed from: g, reason: collision with root package name */
        boolean f15712g;

        /* renamed from: h, reason: collision with root package name */
        long f15713h;

        a(bc.s sVar) {
            super(sVar);
            this.f15712g = false;
            this.f15713h = 0L;
        }

        private void d(IOException iOException) {
            if (this.f15712g) {
                return;
            }
            this.f15712g = true;
            f fVar = f.this;
            fVar.f15708b.r(false, fVar, this.f15713h, iOException);
        }

        @Override // bc.s
        public long G(bc.c cVar, long j10) {
            try {
                long G = c().G(cVar, j10);
                if (G > 0) {
                    this.f15713h += G;
                }
                return G;
            } catch (IOException e10) {
                d(e10);
                throw e10;
            }
        }

        @Override // bc.h, bc.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            d(null);
        }
    }

    public f(v vVar, s.a aVar, ub.g gVar, g gVar2) {
        this.f15707a = aVar;
        this.f15708b = gVar;
        this.f15709c = gVar2;
        List<w> z10 = vVar.z();
        w wVar = w.H2_PRIOR_KNOWLEDGE;
        this.f15711e = z10.contains(wVar) ? wVar : w.HTTP_2;
    }

    public static List<c> g(y yVar) {
        q d10 = yVar.d();
        ArrayList arrayList = new ArrayList(d10.h() + 4);
        arrayList.add(new c(c.f15675f, yVar.f()));
        arrayList.add(new c(c.f15676g, vb.i.c(yVar.h())));
        String c10 = yVar.c("Host");
        if (c10 != null) {
            arrayList.add(new c(c.f15678i, c10));
        }
        arrayList.add(new c(c.f15677h, yVar.h().C()));
        int h10 = d10.h();
        for (int i10 = 0; i10 < h10; i10++) {
            bc.f t10 = bc.f.t(d10.e(i10).toLowerCase(Locale.US));
            if (!f15705f.contains(t10.G())) {
                arrayList.add(new c(t10, d10.i(i10)));
            }
        }
        return arrayList;
    }

    public static a0.a h(q qVar, w wVar) {
        q.a aVar = new q.a();
        int h10 = qVar.h();
        vb.k kVar = null;
        for (int i10 = 0; i10 < h10; i10++) {
            String e10 = qVar.e(i10);
            String i11 = qVar.i(i10);
            if (e10.equals(":status")) {
                kVar = vb.k.a("HTTP/1.1 " + i11);
            } else if (!f15706g.contains(e10)) {
                sb.a.f14194a.b(aVar, e10, i11);
            }
        }
        if (kVar != null) {
            return new a0.a().n(wVar).g(kVar.f14876b).k(kVar.f14877c).j(aVar.d());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // vb.c
    public void a() {
        this.f15710d.j().close();
    }

    @Override // vb.c
    public void b(y yVar) {
        if (this.f15710d != null) {
            return;
        }
        i O = this.f15709c.O(g(yVar), yVar.a() != null);
        this.f15710d = O;
        t n10 = O.n();
        long b10 = this.f15707a.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        n10.g(b10, timeUnit);
        this.f15710d.u().g(this.f15707a.c(), timeUnit);
    }

    @Override // vb.c
    public b0 c(a0 a0Var) {
        ub.g gVar = this.f15708b;
        gVar.f14593f.q(gVar.f14592e);
        return new vb.h(a0Var.j("Content-Type"), vb.e.b(a0Var), bc.l.b(new a(this.f15710d.k())));
    }

    @Override // vb.c
    public void cancel() {
        i iVar = this.f15710d;
        if (iVar != null) {
            iVar.h(b.CANCEL);
        }
    }

    @Override // vb.c
    public void d() {
        this.f15709c.flush();
    }

    @Override // vb.c
    public r e(y yVar, long j10) {
        return this.f15710d.j();
    }

    @Override // vb.c
    public a0.a f(boolean z10) {
        a0.a h10 = h(this.f15710d.s(), this.f15711e);
        if (z10 && sb.a.f14194a.d(h10) == 100) {
            return null;
        }
        return h10;
    }
}
