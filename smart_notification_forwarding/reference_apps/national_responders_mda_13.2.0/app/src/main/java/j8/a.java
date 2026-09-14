package j8;

import e8.b;
import e8.c;
import e8.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static volatile c<Throwable> f10968a;

    /* renamed from: b, reason: collision with root package name */
    static volatile d<Runnable, Runnable> f10969b;

    /* renamed from: c, reason: collision with root package name */
    static volatile b<y7.c, y7.d, y7.d> f10970c;

    static <T, U, R> R a(b<T, U, R> bVar, T t10, U u10) {
        try {
            return bVar.a(t10, u10);
        } catch (Throwable th) {
            throw i8.a.a(th);
        }
    }

    static <T, R> R b(d<T, R> dVar, T t10) {
        try {
            return dVar.apply(t10);
        } catch (Throwable th) {
            throw i8.a.a(th);
        }
    }

    public static void c(Throwable th) {
        c<Throwable> cVar = f10968a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (cVar != null) {
            try {
                cVar.a(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                f(th2);
            }
        }
        th.printStackTrace();
        f(th);
    }

    public static Runnable d(Runnable runnable) {
        d<Runnable, Runnable> dVar = f10969b;
        return dVar == null ? runnable : (Runnable) b(dVar, runnable);
    }

    public static <T> y7.d<? super T> e(y7.c<T> cVar, y7.d<? super T> dVar) {
        b<y7.c, y7.d, y7.d> bVar = f10970c;
        return bVar != null ? (y7.d) a(bVar, cVar, dVar) : dVar;
    }

    static void f(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
