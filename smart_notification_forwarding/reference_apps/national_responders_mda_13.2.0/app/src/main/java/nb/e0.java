package nb;

import l8.o;

/* loaded from: classes.dex */
public final class e0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(p8.d<?> dVar) {
        Object a10;
        if (dVar instanceof kotlinx.coroutines.internal.f) {
            return dVar.toString();
        }
        try {
            o.a aVar = l8.o.f11812f;
            a10 = l8.o.a(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            o.a aVar2 = l8.o.f11812f;
            a10 = l8.o.a(l8.p.a(th));
        }
        if (l8.o.b(a10) != null) {
            a10 = ((Object) dVar.getClass().getName()) + '@' + b(dVar);
        }
        return (String) a10;
    }
}
