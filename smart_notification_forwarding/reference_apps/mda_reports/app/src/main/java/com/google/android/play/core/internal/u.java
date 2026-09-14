package com.google.android.play.core.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends r {
    private final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // com.google.android.play.core.internal.r
    public final void a() {
        IInterface iInterface;
        com.google.android.play.core.splitcompat.a aVar;
        Context context;
        ServiceConnection serviceConnection;
        iInterface = this.a.l;
        if (iInterface != null) {
            aVar = this.a.c;
            aVar.a("Unbind from service.", new Object[0]);
            context = this.a.b;
            serviceConnection = this.a.k;
            context.unbindService(serviceConnection);
            t.a(this.a, false);
            this.a.l = null;
            t.a(this.a, (ServiceConnection) null);
        }
    }
}
