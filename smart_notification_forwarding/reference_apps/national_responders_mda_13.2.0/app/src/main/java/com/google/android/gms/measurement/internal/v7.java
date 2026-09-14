package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v9 f6557f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ k7 f6558g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v7(k7 k7Var, v9 v9Var) {
        this.f6558g = k7Var;
        this.f6557f = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        cVar = this.f6558g.f6164d;
        if (cVar == null) {
            this.f6558g.h().F().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            cVar.I(this.f6557f);
            this.f6558g.e0();
        } catch (RemoteException e10) {
            this.f6558g.h().F().b("Failed to send measurementEnabled to the service", e10);
        }
    }
}
