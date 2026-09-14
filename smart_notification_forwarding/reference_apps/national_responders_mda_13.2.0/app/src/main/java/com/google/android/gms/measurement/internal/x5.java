package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6617f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f6618g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x5(w5 w5Var, AtomicReference atomicReference) {
        this.f6618g = w5Var;
        this.f6617f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6617f) {
            try {
                this.f6617f.set(Boolean.valueOf(this.f6618g.m().N(this.f6618g.q().C())));
            } finally {
                this.f6617f.notify();
            }
        }
    }
}
