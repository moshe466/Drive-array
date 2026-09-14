package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Bundle f6532f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ v9 f6533g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ k7 f6534h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u7(k7 k7Var, Bundle bundle, v9 v9Var) {
        this.f6534h = k7Var;
        this.f6532f = bundle;
        this.f6533g = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        cVar = this.f6534h.f6164d;
        if (cVar == null) {
            this.f6534h.h().F().a("Failed to send default event parameters to service");
            return;
        }
        try {
            cVar.Y(this.f6532f, this.f6533g);
        } catch (RemoteException e10) {
            this.f6534h.h().F().b("Failed to send default event parameters to service", e10);
        }
    }
}
