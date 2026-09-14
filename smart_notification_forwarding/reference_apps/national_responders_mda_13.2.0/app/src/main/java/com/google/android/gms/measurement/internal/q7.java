package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ c7 f6357f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ k7 f6358g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q7(k7 k7Var, c7 c7Var) {
        this.f6358g = k7Var;
        this.f6357f = c7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        long j10;
        String str;
        String str2;
        String packageName;
        cVar = this.f6358g.f6164d;
        if (cVar == null) {
            this.f6358g.h().F().a("Failed to send current screen to service");
            return;
        }
        try {
            c7 c7Var = this.f6357f;
            if (c7Var == null) {
                j10 = 0;
                str = null;
                str2 = null;
                packageName = this.f6358g.i().getPackageName();
            } else {
                j10 = c7Var.f5903c;
                str = c7Var.f5901a;
                str2 = c7Var.f5902b;
                packageName = this.f6358g.i().getPackageName();
            }
            cVar.e0(j10, str, str2, packageName);
            this.f6358g.e0();
        } catch (RemoteException e10) {
            this.f6358g.h().F().b("Failed to send current screen to the service", e10);
        }
    }
}
