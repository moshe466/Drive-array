package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v9 f6388f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ k7 f6389g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r7(k7 k7Var, v9 v9Var) {
        this.f6389g = k7Var;
        this.f6388f = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        cVar = this.f6389g.f6164d;
        if (cVar == null) {
            this.f6389g.h().F().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            cVar.t(this.f6388f);
            this.f6389g.t().J();
            this.f6389g.T(cVar, null, this.f6388f);
            this.f6389g.e0();
        } catch (RemoteException e10) {
            this.f6389g.h().F().b("Failed to send app launch to the service", e10);
        }
    }
}
