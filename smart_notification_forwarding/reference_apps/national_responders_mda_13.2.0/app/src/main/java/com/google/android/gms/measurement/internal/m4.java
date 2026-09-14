package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes.dex */
public final class m4 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final String f6221a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ n4 f6222b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m4(n4 n4Var, String str) {
        this.f6222b = n4Var;
        this.f6221a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f6222b.f6248a.h().I().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.l2 n10 = com.google.android.gms.internal.measurement.n5.n(iBinder);
            if (n10 == null) {
                this.f6222b.f6248a.h().I().a("Install Referrer Service implementation was not found");
            } else {
                this.f6222b.f6248a.h().N().a("Install Referrer Service connected");
                this.f6222b.f6248a.e().z(new o4(this, n10, this));
            }
        } catch (Exception e10) {
            this.f6222b.f6248a.h().I().b("Exception occurred while calling Install Referrer API", e10);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f6222b.f6248a.h().N().a("Install Referrer Service disconnected");
    }
}
