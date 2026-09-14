package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
final class zzawe extends BroadcastReceiver {
    private final /* synthetic */ zzawb zzdsw;

    private zzawe(zzawb zzawbVar) {
        this.zzdsw = zzawbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzawe(zzawb zzawbVar, zzawa zzawaVar) {
        this(zzawbVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            zzawb.a(this.zzdsw, true);
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            zzawb.a(this.zzdsw, false);
        }
    }
}
