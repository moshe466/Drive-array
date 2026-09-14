package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzayj extends BroadcastReceiver {
    private final /* synthetic */ zzayg zzdvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzayj(zzayg zzaygVar) {
        this.zzdvg = zzaygVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzdvg.zzc(context, intent);
    }
}
