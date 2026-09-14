package nb;

import l8.o;

/* loaded from: classes.dex */
public abstract class k0<T> extends kotlinx.coroutines.scheduling.h {

    /* renamed from: h, reason: collision with root package name */
    public int f12399h;

    public k0(int i10) {
        this.f12399h = i10;
    }

    public void d(Object obj, Throwable th) {
    }

    public abstract p8.d<T> f();

    public Throwable g(Object obj) {
        n nVar = obj instanceof n ? (n) obj : null;
        if (nVar == null) {
            return null;
        }
        return nVar.f12408a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T h(Object obj) {
        return obj;
    }

    public final void i(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            l8.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        y8.k.b(th);
        y.a(f().c(), new c0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object j();

    @Override // java.lang.Runnable
    public final void run() {
        Object a10;
        Object a11;
        Object a12;
        if (d0.a()) {
            if (!(this.f12399h != -1)) {
                throw new AssertionError();
            }
        }
        kotlinx.coroutines.scheduling.i iVar = this.f11696g;
        try {
            kotlinx.coroutines.internal.f fVar = (kotlinx.coroutines.internal.f) f();
            p8.d<T> dVar = fVar.f11608j;
            Object obj = fVar.f11610l;
            p8.f c10 = dVar.c();
            Object c11 = kotlinx.coroutines.internal.f0.c(c10, obj);
            q1<?> c12 = c11 != kotlinx.coroutines.internal.f0.f11611a ? t.c(dVar, c10, c11) : null;
            try {
                p8.f c13 = dVar.c();
                Object j10 = j();
                Throwable g10 = g(j10);
                a1 a1Var = (g10 == null && l0.b(this.f12399h)) ? (a1) c13.get(a1.f12361d) : null;
                if (a1Var != null && !a1Var.d()) {
                    Throwable H = a1Var.H();
                    d(j10, H);
                    o.a aVar = l8.o.f11812f;
                    if (d0.c() && (dVar instanceof r8.d)) {
                        H = kotlinx.coroutines.internal.a0.a(H, (r8.d) dVar);
                    }
                    a11 = l8.o.a(l8.p.a(H));
                } else if (g10 != null) {
                    o.a aVar2 = l8.o.f11812f;
                    a11 = l8.o.a(l8.p.a(g10));
                } else {
                    T h10 = h(j10);
                    o.a aVar3 = l8.o.f11812f;
                    a11 = l8.o.a(h10);
                }
                dVar.b(a11);
                l8.w wVar = l8.w.f11824a;
                try {
                    o.a aVar4 = l8.o.f11812f;
                    iVar.a();
                    a12 = l8.o.a(wVar);
                } catch (Throwable th) {
                    o.a aVar5 = l8.o.f11812f;
                    a12 = l8.o.a(l8.p.a(th));
                }
                i(null, l8.o.b(a12));
            } finally {
                if (c12 == null || c12.n0()) {
                    kotlinx.coroutines.internal.f0.a(c10, c11);
                }
            }
        } catch (Throwable th2) {
            try {
                o.a aVar6 = l8.o.f11812f;
                iVar.a();
                a10 = l8.o.a(l8.w.f11824a);
            } catch (Throwable th3) {
                o.a aVar7 = l8.o.f11812f;
                a10 = l8.o.a(l8.p.a(th3));
            }
            i(th2, l8.o.b(a10));
        }
    }
}
