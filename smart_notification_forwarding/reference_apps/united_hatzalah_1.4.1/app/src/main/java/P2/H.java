package P2;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class H extends Y implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: m, reason: collision with root package name */
    public static final H f1614m;

    /* renamed from: n, reason: collision with root package name */
    public static final long f1615n;

    /* JADX WARN: Type inference failed for: r0v0, types: [P2.Y, P2.H, P2.Z] */
    static {
        Long l3;
        ?? y = new Y();
        f1614m = y;
        y.h(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l3 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l3 = 1000L;
        }
        f1615n = timeUnit.toNanos(l3.longValue());
    }

    @Override // P2.Y, P2.L
    public final Q a(long j2, G0 g02, InterfaceC0768i interfaceC0768i) {
        long j3 = 0;
        if (j2 > 0) {
            if (j2 >= 9223372036854L) {
                j3 = Long.MAX_VALUE;
            } else {
                j3 = 1000000 * j2;
            }
        }
        if (j3 < 4611686018427387903L) {
            long nanoTime = System.nanoTime();
            V v2 = new V(j3 + nanoTime, g02);
            o(nanoTime, v2);
            return v2;
        }
        return z0.f1718a;
    }

    @Override // P2.Z
    public final Thread g() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setContextClassLoader(H.class.getClassLoader());
                    thread.setDaemon(true);
                    thread.start();
                }
            }
            return thread;
        }
        return thread2;
    }

    @Override // P2.Z
    public final void k(long j2, W w3) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // P2.Y
    public final void l(Runnable runnable) {
        if (debugStatus != 4) {
            super.l(runnable);
            return;
        }
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void p() {
        boolean z3;
        int i = debugStatus;
        if (i != 2 && i != 3) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            return;
        }
        debugStatus = 3;
        Y.f1634j.set(this, null);
        Y.f1635k.set(this, null);
        notifyAll();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z3;
        boolean z4;
        boolean n4;
        F0.f1603a.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i != 2 && i != 3) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    if (!n4) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j2 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long i3 = i();
                    if (i3 == Long.MAX_VALUE) {
                        long nanoTime = System.nanoTime();
                        if (j2 == Long.MAX_VALUE) {
                            j2 = f1615n + nanoTime;
                        }
                        long j3 = j2 - nanoTime;
                        if (j3 <= 0) {
                            _thread = null;
                            p();
                            if (!n()) {
                                g();
                                return;
                            }
                            return;
                        }
                        if (i3 > j3) {
                            i3 = j3;
                        }
                    } else {
                        j2 = Long.MAX_VALUE;
                    }
                    if (i3 > 0) {
                        int i4 = debugStatus;
                        if (i4 != 2 && i4 != 3) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            _thread = null;
                            p();
                            if (!n()) {
                                g();
                                return;
                            }
                            return;
                        }
                        LockSupport.parkNanos(this, i3);
                    }
                }
            }
        } finally {
            _thread = null;
            p();
            if (!n()) {
                g();
            }
        }
    }

    @Override // P2.Y, P2.Z
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
