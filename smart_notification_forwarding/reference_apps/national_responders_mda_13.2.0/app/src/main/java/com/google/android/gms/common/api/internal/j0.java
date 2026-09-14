package com.google.android.gms.common.api.internal;

import android.os.Looper;
import b2.c;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class j0 implements c.InterfaceC0067c {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f4879a;

    /* renamed from: b, reason: collision with root package name */
    private final a2.a f4880b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f4881c;

    public j0(u0 u0Var, a2.a aVar, boolean z10) {
        this.f4879a = new WeakReference(u0Var);
        this.f4880b = aVar;
        this.f4881c = z10;
    }

    @Override // b2.c.InterfaceC0067c
    public final void a(com.google.android.gms.common.a aVar) {
        d1 d1Var;
        Lock lock;
        Lock lock2;
        boolean n10;
        boolean o10;
        u0 u0Var = (u0) this.f4879a.get();
        if (u0Var == null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        d1Var = u0Var.f4996a;
        b2.p.o(myLooper == d1Var.f4824m.h(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        lock = u0Var.f4997b;
        lock.lock();
        try {
            n10 = u0Var.n(0);
            if (n10) {
                if (!aVar.t()) {
                    u0Var.l(aVar, this.f4880b, this.f4881c);
                }
                o10 = u0Var.o();
                if (o10) {
                    u0Var.m();
                }
            }
        } finally {
            lock2 = u0Var.f4997b;
            lock2.unlock();
        }
    }
}
