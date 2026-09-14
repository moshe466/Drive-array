package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements ServiceConnection {
    final /* synthetic */ t a;

    private z(t tVar) {
        this.a = tVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(t tVar, byte b) {
        this(tVar);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.play.core.splitcompat.a aVar;
        aVar = this.a.c;
        aVar.a("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.a.c(new y(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.play.core.splitcompat.a aVar;
        aVar = this.a.c;
        aVar.a("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.a.c(new ab(this));
    }
}
