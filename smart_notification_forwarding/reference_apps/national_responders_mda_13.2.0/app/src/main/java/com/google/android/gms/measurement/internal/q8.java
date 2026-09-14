package com.google.android.gms.measurement.internal;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q8 {

    /* renamed from: a, reason: collision with root package name */
    private u8 f6359a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p8 f6360b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q8(p8 p8Var) {
        this.f6360b = p8Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        Handler handler;
        this.f6360b.c();
        if (this.f6359a != null) {
            handler = this.f6360b.f6324c;
            handler.removeCallbacks(this.f6359a);
        }
        if (this.f6360b.m().t(s.f6435v0)) {
            this.f6360b.l().f5976w.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j10) {
        Handler handler;
        this.f6359a = new u8(this, this.f6360b.f().a(), j10);
        handler = this.f6360b.f6324c;
        handler.postDelayed(this.f6359a, 2000L);
    }
}
