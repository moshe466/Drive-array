package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Bundle f6139f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ w5 f6140g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j6(w5 w5Var, Bundle bundle) {
        this.f6140g = w5Var;
        this.f6139f = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6140g.v0(this.f6139f);
    }
}
