package P2;

import F0.RunnableC0091v;
import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import w2.InterfaceC0768i;

/* renamed from: P2.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0143b0 extends AbstractC0141a0 implements L {

    /* renamed from: c, reason: collision with root package name */
    public final Executor f1643c;

    public C0143b0(Executor executor) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        Method method;
        this.f1643c = executor;
        Method method2 = U2.c.f2344a;
        try {
            if (executor instanceof ScheduledThreadPoolExecutor) {
                scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) executor;
            } else {
                scheduledThreadPoolExecutor = null;
            }
            if (scheduledThreadPoolExecutor != null && (method = U2.c.f2344a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // P2.L
    public final Q a(long j2, G0 g02, InterfaceC0768i interfaceC0768i) {
        ScheduledExecutorService scheduledExecutorService;
        Executor executor = this.f1643c;
        ScheduledFuture<?> scheduledFuture = null;
        if (executor instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) executor;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            try {
                scheduledFuture = scheduledExecutorService.schedule(g02, j2, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e4) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e4);
                InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) interfaceC0768i.get(B.f1595b);
                if (interfaceC0157i0 != null) {
                    interfaceC0157i0.cancel(cancellationException);
                }
            }
        }
        if (scheduledFuture != null) {
            return new P(scheduledFuture);
        }
        return H.f1614m.a(j2, g02, interfaceC0768i);
    }

    @Override // P2.L
    public final void b(long j2, C0163m c0163m) {
        ScheduledExecutorService scheduledExecutorService;
        Executor executor = this.f1643c;
        ScheduledFuture<?> scheduledFuture = null;
        if (executor instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) executor;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            RunnableC0091v runnableC0091v = new RunnableC0091v(3, this, c0163m);
            InterfaceC0768i interfaceC0768i = c0163m.f1674e;
            try {
                scheduledFuture = scheduledExecutorService.schedule(runnableC0091v, j2, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e4) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e4);
                InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) interfaceC0768i.get(B.f1595b);
                if (interfaceC0157i0 != null) {
                    interfaceC0157i0.cancel(cancellationException);
                }
            }
        }
        if (scheduledFuture != null) {
            c0163m.t(new C0158j(scheduledFuture, 0));
        } else {
            H.f1614m.b(j2, c0163m);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ExecutorService executorService;
        Executor executor = this.f1643c;
        if (executor instanceof ExecutorService) {
            executorService = (ExecutorService) executor;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // P2.A
    public final void d(InterfaceC0768i interfaceC0768i, Runnable runnable) {
        try {
            this.f1643c.execute(runnable);
        } catch (RejectedExecutionException e4) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e4);
            InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) interfaceC0768i.get(B.f1595b);
            if (interfaceC0157i0 != null) {
                interfaceC0157i0.cancel(cancellationException);
            }
            O.f1623b.d(interfaceC0768i, runnable);
        }
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof C0143b0) && ((C0143b0) obj).f1643c == this.f1643c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f1643c);
    }

    @Override // P2.A
    public final String toString() {
        return this.f1643c.toString();
    }
}
