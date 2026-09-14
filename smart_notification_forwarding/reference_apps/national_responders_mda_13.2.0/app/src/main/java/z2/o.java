package z2;

import com.google.android.gms.tasks.Task;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class o {
    public static <TResult> TResult a(l<TResult> lVar) {
        b2.p.i();
        b2.p.l(lVar, "Task must not be null");
        if (lVar.o()) {
            return (TResult) h(lVar);
        }
        r rVar = new r(null);
        i(lVar, rVar);
        rVar.c();
        return (TResult) h(lVar);
    }

    public static <TResult> TResult b(l<TResult> lVar, long j10, TimeUnit timeUnit) {
        b2.p.i();
        b2.p.l(lVar, "Task must not be null");
        b2.p.l(timeUnit, "TimeUnit must not be null");
        if (lVar.o()) {
            return (TResult) h(lVar);
        }
        r rVar = new r(null);
        i(lVar, rVar);
        if (rVar.e(j10, timeUnit)) {
            return (TResult) h(lVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @Deprecated
    public static <TResult> l<TResult> c(Executor executor, Callable<TResult> callable) {
        b2.p.l(executor, "Executor must not be null");
        b2.p.l(callable, "Callback must not be null");
        o0 o0Var = new o0();
        executor.execute(new p0(o0Var, callable));
        return o0Var;
    }

    public static <TResult> l<TResult> d(Exception exc) {
        o0 o0Var = new o0();
        o0Var.s(exc);
        return o0Var;
    }

    public static <TResult> l<TResult> e(TResult tresult) {
        o0 o0Var = new o0();
        o0Var.t(tresult);
        return o0Var;
    }

    public static l<Void> f(Collection<? extends l<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return e(null);
        }
        Iterator<? extends l<?>> it = collection.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next(), "null tasks are not accepted");
        }
        o0 o0Var = new o0();
        t tVar = new t(collection.size(), o0Var);
        Iterator<? extends l<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            i(it2.next(), tVar);
        }
        return o0Var;
    }

    public static l<Void> g(Task<?>... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? e(null) : f(Arrays.asList(taskArr));
    }

    private static Object h(l lVar) {
        if (lVar.p()) {
            return lVar.l();
        }
        if (lVar.n()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(lVar.k());
    }

    private static void i(l lVar, s sVar) {
        Executor executor = n.f16109b;
        lVar.f(executor, sVar);
        lVar.d(executor, sVar);
        lVar.a(executor, sVar);
    }
}
