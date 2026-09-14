package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Bundle f6086f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f6087g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h6(w5 w5Var, Bundle bundle) {
        this.f6087g = w5Var;
        this.f6086f = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6087g.t0(this.f6086f);
    }
}
