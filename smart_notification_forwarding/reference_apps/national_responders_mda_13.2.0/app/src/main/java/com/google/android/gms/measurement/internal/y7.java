package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v9 f6642f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ k7 f6643g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y7(k7 k7Var, v9 v9Var) {
        this.f6643g = k7Var;
        this.f6642f = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        cVar = this.f6643g.f6164d;
        if (cVar == null) {
            this.f6643g.h().F().a("Failed to send consent settings to service");
            return;
        }
        try {
            cVar.x(this.f6642f);
            this.f6643g.e0();
        } catch (RemoteException e10) {
            this.f6643g.h().F().b("Failed to send consent settings to the service", e10);
        }
    }
}
