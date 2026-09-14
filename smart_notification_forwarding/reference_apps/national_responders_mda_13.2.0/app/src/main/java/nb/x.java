package nb;

import java.util.Iterator;
import java.util.List;
import l8.o;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private static final List<v> f12435a;

    static {
        lb.h a10;
        List<v> w10;
        a10 = lb.l.a(w.a());
        w10 = lb.n.w(a10);
        f12435a = w10;
    }

    public static final void a(p8.f fVar, Throwable th) {
        Iterator<v> it = f12435a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(fVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, y.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            o.a aVar = l8.o.f11812f;
            l8.b.a(th, new i0(fVar));
            l8.o.a(l8.w.f11824a);
        } catch (Throwable th3) {
            o.a aVar2 = l8.o.f11812f;
            l8.o.a(l8.p.a(th3));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
