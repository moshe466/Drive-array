package tb;

import bc.e;
import bc.l;
import bc.r;
import bc.t;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.a0;
import okhttp3.q;
import okhttp3.s;
import okhttp3.w;
import okhttp3.y;
import tb.c;
import vb.f;
import vb.h;

/* loaded from: classes.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    final d f14313a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tb.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0293a implements bc.s {

        /* renamed from: f, reason: collision with root package name */
        boolean f14314f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f14315g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f14316h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ bc.d f14317i;

        C0293a(a aVar, e eVar, b bVar, bc.d dVar) {
            this.f14315g = eVar;
            this.f14316h = bVar;
            this.f14317i = dVar;
        }

        @Override // bc.s
        public long G(bc.c cVar, long j10) {
            try {
                long G = this.f14315g.G(cVar, j10);
                if (G != -1) {
                    cVar.b0(this.f14317i.a(), cVar.n0() - G, G);
                    this.f14317i.F();
                    return G;
                }
                if (!this.f14314f) {
                    this.f14314f = true;
                    this.f14317i.close();
                }
                return -1L;
            } catch (IOException e10) {
                if (!this.f14314f) {
                    this.f14314f = true;
                    this.f14316h.b();
                }
                throw e10;
            }
        }

        @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f14314f && !sb.c.p(this, 100, TimeUnit.MILLISECONDS)) {
                this.f14314f = true;
                this.f14316h.b();
            }
            this.f14315g.close();
        }

        @Override // bc.s
        public t e() {
            return this.f14315g.e();
        }
    }

    public a(d dVar) {
        this.f14313a = dVar;
    }

    private a0 b(b bVar, a0 a0Var) {
        r a10;
        if (bVar == null || (a10 = bVar.a()) == null) {
            return a0Var;
        }
        return a0Var.M().b(new h(a0Var.j("Content-Type"), a0Var.c().d(), l.b(new C0293a(this, a0Var.c().v(), bVar, l.a(a10))))).c();
    }

    private static q c(q qVar, q qVar2) {
        q.a aVar = new q.a();
        int h10 = qVar.h();
        for (int i10 = 0; i10 < h10; i10++) {
            String e10 = qVar.e(i10);
            String i11 = qVar.i(i10);
            if ((!"Warning".equalsIgnoreCase(e10) || !i11.startsWith("1")) && (d(e10) || !e(e10) || qVar2.c(e10) == null)) {
                sb.a.f14194a.b(aVar, e10, i11);
            }
        }
        int h11 = qVar2.h();
        for (int i12 = 0; i12 < h11; i12++) {
            String e11 = qVar2.e(i12);
            if (!d(e11) && e(e11)) {
                sb.a.f14194a.b(aVar, e11, qVar2.i(i12));
            }
        }
        return aVar.d();
    }

    static boolean d(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    static boolean e(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static a0 f(a0 a0Var) {
        return (a0Var == null || a0Var.c() == null) ? a0Var : a0Var.M().b(null).c();
    }

    @Override // okhttp3.s
    public a0 a(s.a aVar) {
        d dVar = this.f14313a;
        a0 a10 = dVar != null ? dVar.a(aVar.e()) : null;
        c c10 = new c.a(System.currentTimeMillis(), aVar.e(), a10).c();
        y yVar = c10.f14318a;
        a0 a0Var = c10.f14319b;
        d dVar2 = this.f14313a;
        if (dVar2 != null) {
            dVar2.d(c10);
        }
        if (a10 != null && a0Var == null) {
            sb.c.g(a10.c());
        }
        if (yVar == null && a0Var == null) {
            return new a0.a().p(aVar.e()).n(w.HTTP_1_1).g(504).k("Unsatisfiable Request (only-if-cached)").b(sb.c.f14198c).q(-1L).o(System.currentTimeMillis()).c();
        }
        if (yVar == null) {
            return a0Var.M().d(f(a0Var)).c();
        }
        try {
            a0 d10 = aVar.d(yVar);
            if (d10 == null && a10 != null) {
            }
            if (a0Var != null) {
                if (d10.f() == 304) {
                    a0 c11 = a0Var.M().j(c(a0Var.D(), d10.D())).q(d10.b0()).o(d10.O()).d(f(a0Var)).l(f(d10)).c();
                    d10.c().close();
                    this.f14313a.b();
                    this.f14313a.c(a0Var, c11);
                    return c11;
                }
                sb.c.g(a0Var.c());
            }
            a0 c12 = d10.M().d(f(a0Var)).l(f(d10)).c();
            if (this.f14313a != null) {
                if (vb.e.c(c12) && c.a(c12, yVar)) {
                    return b(this.f14313a.f(c12), c12);
                }
                if (f.a(yVar.f())) {
                    try {
                        this.f14313a.e(yVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return c12;
        } finally {
            if (a10 != null) {
                sb.c.g(a10.c());
            }
        }
    }
}
