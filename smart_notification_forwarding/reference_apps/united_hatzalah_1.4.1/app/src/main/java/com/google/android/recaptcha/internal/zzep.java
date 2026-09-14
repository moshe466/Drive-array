package com.google.android.recaptcha.internal;

import P2.E;
import P2.G;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class zzep extends TimerTask {
    final /* synthetic */ zzes zza;

    public zzep(zzes zzesVar) {
        this.zza = zzesVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        E e4;
        zzes zzesVar = this.zza;
        e4 = zzesVar.zzd;
        G.r(e4, null, new zzeq(zzesVar, null), 3);
    }
}
