package nb;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import nb.q0;

/* loaded from: classes.dex */
public final class f0 extends q0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: l, reason: collision with root package name */
    public static final f0 f12371l;

    /* renamed from: m, reason: collision with root package name */
    private static final long f12372m;

    static {
        Long l10;
        f0 f0Var = new f0();
        f12371l = f0Var;
        p0.h0(f0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f12372m = timeUnit.toNanos(l10.longValue());
    }

    private f0() {
    }

    private final synchronized void D0() {
        if (G0()) {
            debugStatus = 3;
            y0();
            notifyAll();
        }
    }

    private final synchronized Thread E0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean F0() {
        return debugStatus == 4;
    }

    private final boolean G0() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    private final synchronized boolean H0() {
        if (G0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void I0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // nb.q0, nb.p0
    public void l0() {
        debugStatus = 4;
        super.l0();
    }

    @Override // nb.r0
    protected Thread m0() {
        Thread thread = _thread;
        return thread == null ? E0() : thread;
    }

    @Override // nb.r0
    protected void n0(long j10, q0.a aVar) {
        I0();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean v02;
        o1.f12412a.c(this);
        c.a();
        try {
            if (!H0()) {
                if (v02) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long w02 = w0();
                if (w02 == Long.MAX_VALUE) {
                    c.a();
                    long nanoTime = System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f12372m + nanoTime;
                    }
                    long j11 = j10 - nanoTime;
                    if (j11 <= 0) {
                        _thread = null;
                        D0();
                        c.a();
                        if (v0()) {
                            return;
                        }
                        m0();
                        return;
                    }
                    w02 = d9.f.d(w02, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (w02 > 0) {
                    if (G0()) {
                        _thread = null;
                        D0();
                        c.a();
                        if (v0()) {
                            return;
                        }
                        m0();
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, w02);
                }
            }
        } finally {
            _thread = null;
            D0();
            c.a();
            if (!v0()) {
                m0();
            }
        }
    }

    @Override // nb.q0
    public void s0(Runnable runnable) {
        if (F0()) {
            I0();
        }
        super.s0(runnable);
    }
}
