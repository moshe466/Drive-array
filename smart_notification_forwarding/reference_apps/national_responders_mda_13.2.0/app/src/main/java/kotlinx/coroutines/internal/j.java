package kotlinx.coroutines.internal;

import l8.o;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f11633a;

    static {
        Object a10;
        try {
            o.a aVar = l8.o.f11812f;
            a10 = l8.o.a(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            o.a aVar2 = l8.o.f11812f;
            a10 = l8.o.a(l8.p.a(th));
        }
        f11633a = l8.o.d(a10);
    }

    public static final boolean a() {
        return f11633a;
    }
}
