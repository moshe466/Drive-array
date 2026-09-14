package nb;

import l8.o;

/* loaded from: classes.dex */
public final class r {
    public static final <T> Object a(Object obj, p8.d<? super T> dVar) {
        if (obj instanceof n) {
            o.a aVar = l8.o.f11812f;
            Throwable th = ((n) obj).f12408a;
            if (d0.c() && (dVar instanceof r8.d)) {
                th = kotlinx.coroutines.internal.a0.j(th, (r8.d) dVar);
            }
            obj = l8.p.a(th);
        } else {
            o.a aVar2 = l8.o.f11812f;
        }
        return l8.o.a(obj);
    }

    public static final <T> Object b(Object obj, g<?> gVar) {
        Throwable b10 = l8.o.b(obj);
        if (b10 != null) {
            if (d0.c() && (gVar instanceof r8.d)) {
                b10 = kotlinx.coroutines.internal.a0.j(b10, (r8.d) gVar);
            }
            obj = new n(b10, false, 2, null);
        }
        return obj;
    }

    public static final <T> Object c(Object obj, x8.l<? super Throwable, l8.w> lVar) {
        Throwable b10 = l8.o.b(obj);
        return b10 == null ? lVar != null ? new o(obj, lVar) : obj : new n(b10, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, x8.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return c(obj, lVar);
    }
}
