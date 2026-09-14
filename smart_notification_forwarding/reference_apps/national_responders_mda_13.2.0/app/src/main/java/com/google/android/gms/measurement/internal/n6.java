package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6252f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f6253g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n6(w5 w5Var, AtomicReference atomicReference) {
        this.f6253g = w5Var;
        this.f6252f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6252f) {
            try {
                this.f6252f.set(Long.valueOf(this.f6253g.m().q(this.f6253g.q().C(), s.M)));
            } finally {
                this.f6252f.notify();
            }
        }
    }
}
