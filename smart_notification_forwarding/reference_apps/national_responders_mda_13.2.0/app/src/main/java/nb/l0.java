package nb;

import l8.o;

/* loaded from: classes.dex */
public final class l0 {
    public static final <T> void a(k0<? super T> k0Var, int i10) {
        if (d0.a()) {
            if (!(i10 != -1)) {
                throw new AssertionError();
            }
        }
        p8.d<? super T> f10 = k0Var.f();
        boolean z10 = i10 == 4;
        if (z10 || !(f10 instanceof kotlinx.coroutines.internal.f) || b(i10) != b(k0Var.f12399h)) {
            d(k0Var, f10, z10);
            return;
        }
        u uVar = ((kotlinx.coroutines.internal.f) f10).f11607i;
        p8.f c10 = f10.c();
        if (uVar.a0(c10)) {
            uVar.c(c10, k0Var);
        } else {
            e(k0Var);
        }
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final <T> void d(k0<? super T> k0Var, p8.d<? super T> dVar, boolean z10) {
        Object h10;
        Object j10 = k0Var.j();
        Throwable g10 = k0Var.g(j10);
        if (g10 != null) {
            o.a aVar = l8.o.f11812f;
            h10 = l8.p.a(g10);
        } else {
            o.a aVar2 = l8.o.f11812f;
            h10 = k0Var.h(j10);
        }
        Object a10 = l8.o.a(h10);
        if (!z10) {
            dVar.b(a10);
            return;
        }
        kotlinx.coroutines.internal.f fVar = (kotlinx.coroutines.internal.f) dVar;
        p8.d<T> dVar2 = fVar.f11608j;
        Object obj = fVar.f11610l;
        p8.f c10 = dVar2.c();
        Object c11 = kotlinx.coroutines.internal.f0.c(c10, obj);
        q1<?> c12 = c11 != kotlinx.coroutines.internal.f0.f11611a ? t.c(dVar2, c10, c11) : null;
        try {
            fVar.f11608j.b(a10);
            l8.w wVar = l8.w.f11824a;
        } finally {
            if (c12 == null || c12.n0()) {
                kotlinx.coroutines.internal.f0.a(c10, c11);
            }
        }
    }

    private static final void e(k0<?> k0Var) {
        p0 a10 = o1.f12412a.a();
        if (a10.i0()) {
            a10.e0(k0Var);
            return;
        }
        a10.g0(true);
        try {
            d(k0Var, k0Var.f(), true);
            do {
            } while (a10.k0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
