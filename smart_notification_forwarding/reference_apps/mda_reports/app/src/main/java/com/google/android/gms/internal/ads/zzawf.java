package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzawf extends BroadcastReceiver {
    private zzawf(zzawb zzawbVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzawf(zzawb zzawbVar, zzawa zzawaVar) {
        this(zzawbVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzayo.zzxk();
        zzavq.zzan(context);
    }
}
