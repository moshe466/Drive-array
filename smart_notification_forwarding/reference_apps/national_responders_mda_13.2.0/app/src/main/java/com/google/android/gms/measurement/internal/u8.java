package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    long f6535f;

    /* renamed from: g, reason: collision with root package name */
    long f6536g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ q8 f6537h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u8(q8 q8Var, long j10, long j11) {
        this.f6537h = q8Var;
        this.f6535f = j10;
        this.f6536g = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6537h.f6360b.e().z(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.t8

            /* renamed from: f, reason: collision with root package name */
            private final u8 f6508f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f6508f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                u8 u8Var = this.f6508f;
                q8 q8Var = u8Var.f6537h;
                long j10 = u8Var.f6535f;
                long j11 = u8Var.f6536g;
                q8Var.f6360b.c();
                q8Var.f6360b.h().M().a("Application going to the background");
                boolean z10 = true;
                if (q8Var.f6360b.m().t(s.f6435v0)) {
                    q8Var.f6360b.l().f5976w.a(true);
                }
                Bundle bundle = new Bundle();
                if (!q8Var.f6360b.m().I().booleanValue()) {
                    q8Var.f6360b.f6326e.f(j11);
                    if (q8Var.f6360b.m().t(s.f6417m0)) {
                        bundle.putLong("_et", q8Var.f6360b.B(j11));
                        b7.O(q8Var.f6360b.s().D(true), bundle, true);
                    } else {
                        z10 = false;
                    }
                    q8Var.f6360b.E(false, z10, j11);
                }
                q8Var.f6360b.p().O("auto", "_ab", j10, bundle);
            }
        });
    }
}
