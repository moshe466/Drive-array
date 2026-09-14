package com.google.android.gms.measurement.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u4 extends Thread {

    /* renamed from: f, reason: collision with root package name */
    private final Object f6521f;

    /* renamed from: g, reason: collision with root package name */
    private final BlockingQueue<r4<?>> f6522g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6523h = false;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ q4 f6524i;

    public u4(q4 q4Var, String str, BlockingQueue<r4<?>> blockingQueue) {
        this.f6524i = q4Var;
        b2.p.k(str);
        b2.p.k(blockingQueue);
        this.f6521f = new Object();
        this.f6522g = blockingQueue;
        setName(str);
    }

    private final void b(InterruptedException interruptedException) {
        this.f6524i.h().I().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    private final void c() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        u4 u4Var;
        u4 u4Var2;
        obj = this.f6524i.f6348i;
        synchronized (obj) {
            if (!this.f6523h) {
                semaphore = this.f6524i.f6349j;
                semaphore.release();
                obj2 = this.f6524i.f6348i;
                obj2.notifyAll();
                u4Var = this.f6524i.f6342c;
                if (this == u4Var) {
                    q4.u(this.f6524i, null);
                } else {
                    u4Var2 = this.f6524i.f6343d;
                    if (this == u4Var2) {
                        q4.A(this.f6524i, null);
                    } else {
                        this.f6524i.h().F().a("Current scheduler thread is neither worker nor network");
                    }
                }
                this.f6523h = true;
            }
        }
    }

    public final void a() {
        synchronized (this.f6521f) {
            this.f6521f.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Semaphore semaphore;
        Object obj;
        boolean z10;
        boolean z11 = false;
        while (!z11) {
            try {
                semaphore = this.f6524i.f6349j;
                semaphore.acquire();
                z11 = true;
            } catch (InterruptedException e10) {
                b(e10);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                r4<?> poll = this.f6522g.poll();
                if (poll == null) {
                    synchronized (this.f6521f) {
                        if (this.f6522g.peek() == null) {
                            z10 = this.f6524i.f6350k;
                            if (!z10) {
                                try {
                                    this.f6521f.wait(30000L);
                                } catch (InterruptedException e11) {
                                    b(e11);
                                }
                            }
                        }
                    }
                    obj = this.f6524i.f6348i;
                    synchronized (obj) {
                        if (this.f6522g.peek() == null) {
                            break;
                        }
                    }
                } else {
                    Process.setThreadPriority(poll.f6378g ? threadPriority : 10);
                    poll.run();
                }
            }
            if (this.f6524i.m().t(s.f6427r0)) {
                c();
            }
        } finally {
            c();
        }
    }
}
