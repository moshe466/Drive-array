package a8;

import d8.b;
import e8.d;
import java.util.Objects;
import java.util.concurrent.Callable;
import y7.e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d<Callable<e>, e> f329a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile d<e, e> f330b;

    static <T, R> R a(d<T, R> dVar, T t10) {
        try {
            return dVar.apply(t10);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    static e b(d<Callable<e>, e> dVar, Callable<e> callable) {
        e eVar = (e) a(dVar, callable);
        Objects.requireNonNull(eVar, "Scheduler Callable returned null");
        return eVar;
    }

    static e c(Callable<e> callable) {
        try {
            e call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    public static e d(Callable<e> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        d<Callable<e>, e> dVar = f329a;
        return dVar == null ? c(callable) : b(dVar, callable);
    }

    public static e e(e eVar) {
        Objects.requireNonNull(eVar, "scheduler == null");
        d<e, e> dVar = f330b;
        return dVar == null ? eVar : (e) a(dVar, eVar);
    }
}
