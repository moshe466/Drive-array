package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements d {

    /* renamed from: f, reason: collision with root package name */
    final v f12881f;

    /* renamed from: g, reason: collision with root package name */
    final vb.j f12882g;

    /* renamed from: h, reason: collision with root package name */
    final bc.a f12883h;

    /* renamed from: i, reason: collision with root package name */
    private o f12884i;

    /* renamed from: j, reason: collision with root package name */
    final y f12885j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f12886k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f12887l;

    /* loaded from: classes.dex */
    class a extends bc.a {
        a() {
        }

        @Override // bc.a
        protected void t() {
            x.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b extends sb.b {

        /* renamed from: g, reason: collision with root package name */
        private final e f12889g;

        b(e eVar) {
            super("OkHttp %s", x.this.l());
            this.f12889g = eVar;
        }

        @Override // sb.b
        protected void k() {
            IOException e10;
            a0 h10;
            x.this.f12883h.k();
            boolean z10 = true;
            try {
                try {
                    h10 = x.this.h();
                } catch (IOException e11) {
                    e10 = e11;
                    z10 = false;
                }
                try {
                    if (x.this.f12882g.e()) {
                        this.f12889g.b(x.this, new IOException("Canceled"));
                    } else {
                        this.f12889g.a(x.this, h10);
                    }
                } catch (IOException e12) {
                    e10 = e12;
                    IOException m10 = x.this.m(e10);
                    if (z10) {
                        yb.f.j().p(4, "Callback failure for " + x.this.n(), m10);
                    } else {
                        x.this.f12884i.b(x.this, m10);
                        this.f12889g.b(x.this, m10);
                    }
                }
            } finally {
                x.this.f12881f.l().e(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void l(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    x.this.f12884i.b(x.this, interruptedIOException);
                    this.f12889g.b(x.this, interruptedIOException);
                    x.this.f12881f.l().e(this);
                }
            } catch (Throwable th) {
                x.this.f12881f.l().e(this);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public x m() {
            return x.this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String n() {
            return x.this.f12885j.h().l();
        }
    }

    private x(v vVar, y yVar, boolean z10) {
        this.f12881f = vVar;
        this.f12885j = yVar;
        this.f12886k = z10;
        this.f12882g = new vb.j(vVar, z10);
        a aVar = new a();
        this.f12883h = aVar;
        aVar.g(vVar.b(), TimeUnit.MILLISECONDS);
    }

    private void d() {
        this.f12882g.j(yb.f.j().m("response.body().close()"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x k(v vVar, y yVar, boolean z10) {
        x xVar = new x(vVar, yVar, z10);
        xVar.f12884i = vVar.n().a(xVar);
        return xVar;
    }

    public void b() {
        this.f12882g.b();
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public x clone() {
        return k(this.f12881f, this.f12885j, this.f12886k);
    }

    @Override // okhttp3.d
    public a0 f() {
        synchronized (this) {
            if (this.f12887l) {
                throw new IllegalStateException("Already Executed");
            }
            this.f12887l = true;
        }
        d();
        this.f12883h.k();
        this.f12884i.c(this);
        try {
            try {
                this.f12881f.l().b(this);
                a0 h10 = h();
                if (h10 != null) {
                    return h10;
                }
                throw new IOException("Canceled");
            } catch (IOException e10) {
                IOException m10 = m(e10);
                this.f12884i.b(this, m10);
                throw m10;
            }
        } finally {
            this.f12881f.l().f(this);
        }
    }

    a0 h() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f12881f.r());
        arrayList.add(this.f12882g);
        arrayList.add(new vb.a(this.f12881f.k()));
        arrayList.add(new tb.a(this.f12881f.s()));
        arrayList.add(new ub.a(this.f12881f));
        if (!this.f12886k) {
            arrayList.addAll(this.f12881f.t());
        }
        arrayList.add(new vb.b(this.f12886k));
        return new vb.g(arrayList, null, null, null, 0, this.f12885j, this, this.f12884i, this.f12881f.e(), this.f12881f.E(), this.f12881f.J()).d(this.f12885j);
    }

    public boolean i() {
        return this.f12882g.e();
    }

    String l() {
        return this.f12885j.h().A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IOException m(IOException iOException) {
        if (!this.f12883h.n()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    String n() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i() ? "canceled " : "");
        sb2.append(this.f12886k ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(l());
        return sb2.toString();
    }

    @Override // okhttp3.d
    public void v(e eVar) {
        synchronized (this) {
            if (this.f12887l) {
                throw new IllegalStateException("Already Executed");
            }
            this.f12887l = true;
        }
        d();
        this.f12884i.c(this);
        this.f12881f.l().a(new b(eVar));
    }
}
