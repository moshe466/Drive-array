package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v9 f6254f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ k7 f6255g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n7(k7 k7Var, v9 v9Var) {
        this.f6255g = k7Var;
        this.f6254f = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        cVar = this.f6255g.f6164d;
        if (cVar == null) {
            this.f6255g.h().F().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            cVar.i0(this.f6254f);
        } catch (RemoteException e10) {
            this.f6255g.h().F().b("Failed to reset data on the service: remote exception", e10);
        }
        this.f6255g.e0();
    }
}
