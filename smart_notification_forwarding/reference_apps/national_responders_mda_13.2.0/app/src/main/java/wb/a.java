package wb;

import bc.i;
import bc.l;
import bc.r;
import bc.s;
import bc.t;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.q;
import okhttp3.v;
import okhttp3.y;
import vb.h;
import vb.k;

/* loaded from: classes.dex */
public final class a implements vb.c {

    /* renamed from: a, reason: collision with root package name */
    final v f15350a;

    /* renamed from: b, reason: collision with root package name */
    final ub.g f15351b;

    /* renamed from: c, reason: collision with root package name */
    final bc.e f15352c;

    /* renamed from: d, reason: collision with root package name */
    final bc.d f15353d;

    /* renamed from: e, reason: collision with root package name */
    int f15354e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f15355f = 262144;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class b implements s {

        /* renamed from: f, reason: collision with root package name */
        protected final i f15356f;

        /* renamed from: g, reason: collision with root package name */
        protected boolean f15357g;

        /* renamed from: h, reason: collision with root package name */
        protected long f15358h;

        private b() {
            this.f15356f = new i(a.this.f15352c.e());
            this.f15358h = 0L;
        }

        @Override // bc.s
        public long G(bc.c cVar, long j10) {
            try {
                long G = a.this.f15352c.G(cVar, j10);
                if (G > 0) {
                    this.f15358h += G;
                }
                return G;
            } catch (IOException e10) {
                c(false, e10);
                throw e10;
            }
        }

        protected final void c(boolean z10, IOException iOException) {
            a aVar = a.this;
            int i10 = aVar.f15354e;
            if (i10 == 6) {
                return;
            }
            if (i10 != 5) {
                throw new IllegalStateException("state: " + a.this.f15354e);
            }
            aVar.g(this.f15356f);
            a aVar2 = a.this;
            aVar2.f15354e = 6;
            ub.g gVar = aVar2.f15351b;
            if (gVar != null) {
                gVar.r(!z10, aVar2, this.f15358h, iOException);
            }
        }

        @Override // bc.s
        public t e() {
            return this.f15356f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements r {

        /* renamed from: f, reason: collision with root package name */
        private final i f15360f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f15361g;

        c() {
            this.f15360f = new i(a.this.f15353d.e());
        }

        @Override // bc.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f15361g) {
                return;
            }
            this.f15361g = true;
            a.this.f15353d.S("0\r\n\r\n");
            a.this.g(this.f15360f);
            a.this.f15354e = 3;
        }

        @Override // bc.r
        public t e() {
            return this.f15360f;
        }

        @Override // bc.r, java.io.Flushable
        public synchronized void flush() {
            if (this.f15361g) {
                return;
            }
            a.this.f15353d.flush();
        }

        @Override // bc.r
        public void l(bc.c cVar, long j10) {
            if (this.f15361g) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return;
            }
            a.this.f15353d.o(j10);
            a.this.f15353d.S("\r\n");
            a.this.f15353d.l(cVar, j10);
            a.this.f15353d.S("\r\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends b {

        /* renamed from: j, reason: collision with root package name */
        private final okhttp3.r f15363j;

        /* renamed from: k, reason: collision with root package name */
        private long f15364k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f15365l;

        d(okhttp3.r rVar) {
            super();
            this.f15364k = -1L;
            this.f15365l = true;
            this.f15363j = rVar;
        }

        private void d() {
            if (this.f15364k != -1) {
                a.this.f15352c.x();
            }
            try {
                this.f15364k = a.this.f15352c.W();
                String trim = a.this.f15352c.x().trim();
                if (this.f15364k < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f15364k + trim + "\"");
                }
                if (this.f15364k == 0) {
                    this.f15365l = false;
                    vb.e.e(a.this.f15350a.k(), this.f15363j, a.this.n());
                    c(true, null);
                }
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        @Override // wb.a.b, bc.s
        public long G(bc.c cVar, long j10) {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f15357g) {
                throw new IllegalStateException("closed");
            }
            if (!this.f15365l) {
                return -1L;
            }
            long j11 = this.f15364k;
            if (j11 == 0 || j11 == -1) {
                d();
                if (!this.f15365l) {
                    return -1L;
                }
            }
            long G = super.G(cVar, Math.min(j10, this.f15364k));
            if (G != -1) {
                this.f15364k -= G;
                return G;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            c(false, protocolException);
            throw protocolException;
        }

        @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f15357g) {
                return;
            }
            if (this.f15365l && !sb.c.p(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, null);
            }
            this.f15357g = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class e implements r {

        /* renamed from: f, reason: collision with root package name */
        private final i f15367f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f15368g;

        /* renamed from: h, reason: collision with root package name */
        private long f15369h;

        e(long j10) {
            this.f15367f = new i(a.this.f15353d.e());
            this.f15369h = j10;
        }

        @Override // bc.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f15368g) {
                return;
            }
            this.f15368g = true;
            if (this.f15369h > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.g(this.f15367f);
            a.this.f15354e = 3;
        }

        @Override // bc.r
        public t e() {
            return this.f15367f;
        }

        @Override // bc.r, java.io.Flushable
        public void flush() {
            if (this.f15368g) {
                return;
            }
            a.this.f15353d.flush();
        }

        @Override // bc.r
        public void l(bc.c cVar, long j10) {
            if (this.f15368g) {
                throw new IllegalStateException("closed");
            }
            sb.c.f(cVar.n0(), 0L, j10);
            if (j10 <= this.f15369h) {
                a.this.f15353d.l(cVar, j10);
                this.f15369h -= j10;
                return;
            }
            throw new ProtocolException("expected " + this.f15369h + " bytes but received " + j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends b {

        /* renamed from: j, reason: collision with root package name */
        private long f15371j;

        f(a aVar, long j10) {
            super();
            this.f15371j = j10;
            if (j10 == 0) {
                c(true, null);
            }
        }

        @Override // wb.a.b, bc.s
        public long G(bc.c cVar, long j10) {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f15357g) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f15371j;
            if (j11 == 0) {
                return -1L;
            }
            long G = super.G(cVar, Math.min(j11, j10));
            if (G == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                c(false, protocolException);
                throw protocolException;
            }
            long j12 = this.f15371j - G;
            this.f15371j = j12;
            if (j12 == 0) {
                c(true, null);
            }
            return G;
        }

        @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f15357g) {
                return;
            }
            if (this.f15371j != 0 && !sb.c.p(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, null);
            }
            this.f15357g = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends b {

        /* renamed from: j, reason: collision with root package name */
        private boolean f15372j;

        g(a aVar) {
            super();
        }

        @Override // wb.a.b, bc.s
        public long G(bc.c cVar, long j10) {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f15357g) {
                throw new IllegalStateException("closed");
            }
            if (this.f15372j) {
                return -1L;
            }
            long G = super.G(cVar, j10);
            if (G != -1) {
                return G;
            }
            this.f15372j = true;
            c(true, null);
            return -1L;
        }

        @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f15357g) {
                return;
            }
            if (!this.f15372j) {
                c(false, null);
            }
            this.f15357g = true;
        }
    }

    public a(v vVar, ub.g gVar, bc.e eVar, bc.d dVar) {
        this.f15350a = vVar;
        this.f15351b = gVar;
        this.f15352c = eVar;
        this.f15353d = dVar;
    }

    private String m() {
        String J = this.f15352c.J(this.f15355f);
        this.f15355f -= J.length();
        return J;
    }

    @Override // vb.c
    public void a() {
        this.f15353d.flush();
    }

    @Override // vb.c
    public void b(y yVar) {
        o(yVar.d(), vb.i.a(yVar, this.f15351b.d().p().b().type()));
    }

    @Override // vb.c
    public b0 c(a0 a0Var) {
        ub.g gVar = this.f15351b;
        gVar.f14593f.q(gVar.f14592e);
        String j10 = a0Var.j("Content-Type");
        if (!vb.e.c(a0Var)) {
            return new h(j10, 0L, l.b(k(0L)));
        }
        if ("chunked".equalsIgnoreCase(a0Var.j("Transfer-Encoding"))) {
            return new h(j10, -1L, l.b(i(a0Var.a0().h())));
        }
        long b10 = vb.e.b(a0Var);
        return b10 != -1 ? new h(j10, b10, l.b(k(b10))) : new h(j10, -1L, l.b(l()));
    }

    @Override // vb.c
    public void cancel() {
        ub.c d10 = this.f15351b.d();
        if (d10 != null) {
            d10.c();
        }
    }

    @Override // vb.c
    public void d() {
        this.f15353d.flush();
    }

    @Override // vb.c
    public r e(y yVar, long j10) {
        if ("chunked".equalsIgnoreCase(yVar.c("Transfer-Encoding"))) {
            return h();
        }
        if (j10 != -1) {
            return j(j10);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // vb.c
    public a0.a f(boolean z10) {
        int i10 = this.f15354e;
        if (i10 != 1 && i10 != 3) {
            throw new IllegalStateException("state: " + this.f15354e);
        }
        try {
            k a10 = k.a(m());
            a0.a j10 = new a0.a().n(a10.f14875a).g(a10.f14876b).k(a10.f14877c).j(n());
            if (z10 && a10.f14876b == 100) {
                return null;
            }
            if (a10.f14876b == 100) {
                this.f15354e = 3;
                return j10;
            }
            this.f15354e = 4;
            return j10;
        } catch (EOFException e10) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f15351b);
            iOException.initCause(e10);
            throw iOException;
        }
    }

    void g(i iVar) {
        t i10 = iVar.i();
        iVar.j(t.f4339d);
        i10.a();
        i10.b();
    }

    public r h() {
        if (this.f15354e == 1) {
            this.f15354e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f15354e);
    }

    public s i(okhttp3.r rVar) {
        if (this.f15354e == 4) {
            this.f15354e = 5;
            return new d(rVar);
        }
        throw new IllegalStateException("state: " + this.f15354e);
    }

    public r j(long j10) {
        if (this.f15354e == 1) {
            this.f15354e = 2;
            return new e(j10);
        }
        throw new IllegalStateException("state: " + this.f15354e);
    }

    public s k(long j10) {
        if (this.f15354e == 4) {
            this.f15354e = 5;
            return new f(this, j10);
        }
        throw new IllegalStateException("state: " + this.f15354e);
    }

    public s l() {
        if (this.f15354e != 4) {
            throw new IllegalStateException("state: " + this.f15354e);
        }
        ub.g gVar = this.f15351b;
        if (gVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f15354e = 5;
        gVar.j();
        return new g(this);
    }

    public q n() {
        q.a aVar = new q.a();
        while (true) {
            String m10 = m();
            if (m10.length() == 0) {
                return aVar.d();
            }
            sb.a.f14194a.a(aVar, m10);
        }
    }

    public void o(q qVar, String str) {
        if (this.f15354e != 0) {
            throw new IllegalStateException("state: " + this.f15354e);
        }
        this.f15353d.S(str).S("\r\n");
        int h10 = qVar.h();
        for (int i10 = 0; i10 < h10; i10++) {
            this.f15353d.S(qVar.e(i10)).S(": ").S(qVar.i(i10)).S("\r\n");
        }
        this.f15353d.S("\r\n");
        this.f15354e = 1;
    }
}
