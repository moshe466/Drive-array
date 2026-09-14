package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6072f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f6073g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g6(w5 w5Var, AtomicReference atomicReference) {
        this.f6073g = w5Var;
        this.f6072f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6072f) {
            try {
                this.f6072f.set(this.f6073g.m().O(this.f6073g.q().C()));
            } finally {
                this.f6072f.notify();
            }
        }
    }
}
