package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
abstract class b1 {

    /* renamed from: a, reason: collision with root package name */
    private final a1 f4787a;

    /* JADX INFO: Access modifiers changed from: protected */
    public b1(a1 a1Var) {
        this.f4787a = a1Var;
    }

    protected abstract void a();

    public final void b(d1 d1Var) {
        Lock lock;
        Lock lock2;
        a1 a1Var;
        lock = d1Var.f4812a;
        lock.lock();
        try {
            a1Var = d1Var.f4822k;
            if (a1Var == this.f4787a) {
                a();
            }
        } finally {
            lock2 = d1Var.f4812a;
            lock2.unlock();
        }
    }
}
