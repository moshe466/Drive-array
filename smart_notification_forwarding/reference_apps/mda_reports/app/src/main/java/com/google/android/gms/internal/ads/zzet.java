package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzet extends BroadcastReceiver {
    private final /* synthetic */ zzer zzzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzet(zzer zzerVar) {
        this.zzzj = zzerVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzzj.zzcm();
    }
}
