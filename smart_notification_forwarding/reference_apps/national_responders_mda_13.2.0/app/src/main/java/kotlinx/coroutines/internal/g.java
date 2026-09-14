package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import l8.o;
import nb.a1;
import nb.o1;
import nb.p0;
import nb.q1;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a */
    private static final b0 f11618a = new b0("UNDEFINED");

    /* renamed from: b */
    public static final b0 f11619b = new b0("REUSABLE_CLAIMED");

    public static final /* synthetic */ b0 a() {
        return f11618a;
    }

    /* JADX WARN: Finally extract failed */
    public static final <T> void b(p8.d<? super T> dVar, Object obj, x8.l<? super Throwable, l8.w> lVar) {
        boolean z10;
        if (!(dVar instanceof f)) {
            dVar.b(obj);
            return;
        }
        f fVar = (f) dVar;
        Object c10 = nb.r.c(obj, lVar);
        if (fVar.f11607i.a0(fVar.c())) {
            fVar.f11609k = c10;
            fVar.f12399h = 1;
            fVar.f11607i.c(fVar.c(), fVar);
            return;
        }
        nb.d0.a();
        p0 a10 = o1.f12412a.a();
        if (a10.i0()) {
            fVar.f11609k = c10;
            fVar.f12399h = 1;
            a10.e0(fVar);
            return;
        }
        a10.g0(true);
        try {
            a1 a1Var = (a1) fVar.c().get(a1.f12361d);
            if (a1Var == null || a1Var.d()) {
                z10 = false;
            } else {
                CancellationException H = a1Var.H();
                fVar.d(c10, H);
                o.a aVar = l8.o.f11812f;
                fVar.b(l8.o.a(l8.p.a(H)));
                z10 = true;
            }
            if (!z10) {
                p8.d<T> dVar2 = fVar.f11608j;
                Object obj2 = fVar.f11610l;
                p8.f c11 = dVar2.c();
                Object c12 = f0.c(c11, obj2);
                q1<?> c13 = c12 != f0.f11611a ? nb.t.c(dVar2, c11, c12) : null;
                try {
                    fVar.f11608j.b(obj);
                    l8.w wVar = l8.w.f11824a;
                    if (c13 == null || c13.n0()) {
                        f0.a(c11, c12);
                    }
                } catch (Throwable th) {
                    if (c13 == null || c13.n0()) {
                        f0.a(c11, c12);
                    }
                    throw th;
                }
            }
            do {
            } while (a10.k0());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(p8.d dVar, Object obj, x8.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        b(dVar, obj, lVar);
    }
}
