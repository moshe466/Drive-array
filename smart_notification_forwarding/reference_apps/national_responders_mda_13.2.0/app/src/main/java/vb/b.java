package vb;

import bc.l;
import bc.r;
import java.net.ProtocolException;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.s;
import okhttp3.y;

/* loaded from: classes.dex */
public final class b implements s {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f14851a;

    /* loaded from: classes.dex */
    static final class a extends bc.g {

        /* renamed from: g, reason: collision with root package name */
        long f14852g;

        a(r rVar) {
            super(rVar);
        }

        @Override // bc.g, bc.r
        public void l(bc.c cVar, long j10) {
            super.l(cVar, j10);
            this.f14852g += j10;
        }
    }

    public b(boolean z10) {
        this.f14851a = z10;
    }

    @Override // okhttp3.s
    public a0 a(s.a aVar) {
        a0.a M;
        b0 c10;
        g gVar = (g) aVar;
        c i10 = gVar.i();
        ub.g k10 = gVar.k();
        ub.c cVar = (ub.c) gVar.g();
        y e10 = gVar.e();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.h().o(gVar.f());
        i10.b(e10);
        gVar.h().n(gVar.f(), e10);
        a0.a aVar2 = null;
        if (f.b(e10.f()) && e10.a() != null) {
            if ("100-continue".equalsIgnoreCase(e10.c("Expect"))) {
                i10.d();
                gVar.h().s(gVar.f());
                aVar2 = i10.f(true);
            }
            if (aVar2 == null) {
                gVar.h().m(gVar.f());
                a aVar3 = new a(i10.e(e10, e10.a().a()));
                bc.d a10 = l.a(aVar3);
                e10.a().g(a10);
                a10.close();
                gVar.h().l(gVar.f(), aVar3.f14852g);
            } else if (!cVar.n()) {
                k10.j();
            }
        }
        i10.a();
        if (aVar2 == null) {
            gVar.h().s(gVar.f());
            aVar2 = i10.f(false);
        }
        a0 c11 = aVar2.p(e10).h(k10.d().k()).q(currentTimeMillis).o(System.currentTimeMillis()).c();
        int f10 = c11.f();
        if (f10 == 100) {
            c11 = i10.f(false).p(e10).h(k10.d().k()).q(currentTimeMillis).o(System.currentTimeMillis()).c();
            f10 = c11.f();
        }
        gVar.h().r(gVar.f(), c11);
        if (this.f14851a && f10 == 101) {
            M = c11.M();
            c10 = sb.c.f14198c;
        } else {
            M = c11.M();
            c10 = i10.c(c11);
        }
        a0 c12 = M.b(c10).c();
        if ("close".equalsIgnoreCase(c12.a0().c("Connection")) || "close".equalsIgnoreCase(c12.j("Connection"))) {
            k10.j();
        }
        if ((f10 != 204 && f10 != 205) || c12.c().d() <= 0) {
            return c12;
        }
        throw new ProtocolException("HTTP " + f10 + " had non-zero Content-Length: " + c12.c().d());
    }
}
