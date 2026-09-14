package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpq extends BroadcastReceiver {
    private final /* synthetic */ zzpo zzbnw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpq(zzpo zzpoVar) {
        this.zzbnw = zzpoVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzbnw.zzbn(3);
    }
}
