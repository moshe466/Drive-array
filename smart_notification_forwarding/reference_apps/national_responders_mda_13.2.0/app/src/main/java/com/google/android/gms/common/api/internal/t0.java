package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
abstract class t0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ u0 f4990f;

    protected abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        d1 d1Var;
        lock = this.f4990f.f4997b;
        lock.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    a();
                }
            } catch (RuntimeException e10) {
                d1Var = this.f4990f.f4996a;
                d1Var.n(e10);
            }
        } finally {
            lock2 = this.f4990f.f4997b;
            lock2.unlock();
        }
    }
}
