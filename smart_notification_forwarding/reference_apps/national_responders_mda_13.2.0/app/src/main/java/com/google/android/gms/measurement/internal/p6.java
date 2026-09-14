package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6319f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f6320g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p6(w5 w5Var, AtomicReference atomicReference) {
        this.f6320g = w5Var;
        this.f6319f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6319f) {
            try {
                this.f6319f.set(Double.valueOf(this.f6320g.m().w(this.f6320g.q().C(), s.O)));
            } finally {
                this.f6319f.notify();
            }
        }
    }
}
