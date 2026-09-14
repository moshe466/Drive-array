package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6225f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f6226g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m6(w5 w5Var, AtomicReference atomicReference) {
        this.f6226g = w5Var;
        this.f6225f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6225f) {
            try {
                this.f6225f.set(Integer.valueOf(this.f6226g.m().v(this.f6226g.q().C(), s.N)));
            } finally {
                this.f6225f.notify();
            }
        }
    }
}
