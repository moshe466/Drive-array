package com.google.android.gms.measurement.internal;

import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class q4 extends q5 {

    /* renamed from: l, reason: collision with root package name */
    private static final AtomicLong f6341l = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: c, reason: collision with root package name */
    private u4 f6342c;

    /* renamed from: d, reason: collision with root package name */
    private u4 f6343d;

    /* renamed from: e, reason: collision with root package name */
    private final PriorityBlockingQueue<r4<?>> f6344e;

    /* renamed from: f, reason: collision with root package name */
    private final BlockingQueue<r4<?>> f6345f;

    /* renamed from: g, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f6346g;

    /* renamed from: h, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f6347h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f6348i;

    /* renamed from: j, reason: collision with root package name */
    private final Semaphore f6349j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f6350k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q4(t4 t4Var) {
        super(t4Var);
        this.f6348i = new Object();
        this.f6349j = new Semaphore(2);
        this.f6344e = new PriorityBlockingQueue<>();
        this.f6345f = new LinkedBlockingQueue();
        this.f6346g = new s4(this, "Thread death: Uncaught exception on worker thread");
        this.f6347h = new s4(this, "Thread death: Uncaught exception on network thread");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ u4 A(q4 q4Var, u4 u4Var) {
        q4Var.f6343d = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ u4 u(q4 q4Var, u4 u4Var) {
        q4Var.f6342c = null;
        return null;
    }

    private final void y(r4<?> r4Var) {
        synchronized (this.f6348i) {
            this.f6344e.add(r4Var);
            u4 u4Var = this.f6342c;
            if (u4Var == null) {
                u4 u4Var2 = new u4(this, "Measurement Worker", this.f6344e);
                this.f6342c = u4Var2;
                u4Var2.setUncaughtExceptionHandler(this.f6346g);
                this.f6342c.start();
            } else {
                u4Var.a();
            }
        }
    }

    public final <V> Future<V> B(Callable<V> callable) {
        q();
        b2.p.k(callable);
        r4<?> r4Var = new r4<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f6342c) {
            r4Var.run();
        } else {
            y(r4Var);
        }
        return r4Var;
    }

    public final void C(Runnable runnable) {
        q();
        b2.p.k(runnable);
        y(new r4<>(this, runnable, true, "Task exception on worker thread"));
    }

    public final void F(Runnable runnable) {
        q();
        b2.p.k(runnable);
        r4<?> r4Var = new r4<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f6348i) {
            this.f6345f.add(r4Var);
            u4 u4Var = this.f6343d;
            if (u4Var == null) {
                u4 u4Var2 = new u4(this, "Measurement Network", this.f6345f);
                this.f6343d = u4Var2;
                u4Var2.setUncaughtExceptionHandler(this.f6347h);
                this.f6343d.start();
            } else {
                u4Var.a();
            }
        }
    }

    public final boolean I() {
        return Thread.currentThread() == this.f6342c;
    }

    @Override // com.google.android.gms.measurement.internal.r5
    public final void b() {
        if (Thread.currentThread() != this.f6343d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.r5
    public final void c() {
        if (Thread.currentThread() != this.f6342c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.q5
    protected final boolean t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> T v(AtomicReference<T> atomicReference, long j10, String str, Runnable runnable) {
        synchronized (atomicReference) {
            e().z(runnable);
            try {
                atomicReference.wait(j10);
            } catch (InterruptedException unused) {
                t3 I = h().I();
                String valueOf = String.valueOf(str);
                I.a(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t10 = atomicReference.get();
        if (t10 == null) {
            t3 I2 = h().I();
            String valueOf2 = String.valueOf(str);
            I2.a(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t10;
    }

    public final <V> Future<V> w(Callable<V> callable) {
        q();
        b2.p.k(callable);
        r4<?> r4Var = new r4<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f6342c) {
            if (!this.f6344e.isEmpty()) {
                h().I().a("Callable skipped the worker queue.");
            }
            r4Var.run();
        } else {
            y(r4Var);
        }
        return r4Var;
    }

    public final void z(Runnable runnable) {
        q();
        b2.p.k(runnable);
        y(new r4<>(this, runnable, false, "Task exception on worker thread"));
    }
}
