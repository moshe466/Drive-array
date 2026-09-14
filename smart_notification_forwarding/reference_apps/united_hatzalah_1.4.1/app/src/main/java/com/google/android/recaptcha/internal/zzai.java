package com.google.android.recaptcha.internal;

import P2.E;
import P2.G;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class zzai extends TimerTask {
    final /* synthetic */ zzan zza;

    public zzai(zzan zzanVar) {
        this.zza = zzanVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        E e4;
        zzan zzanVar = this.zza;
        e4 = zzanVar.zzb;
        G.r(e4, null, new zzaj(zzanVar, null), 3);
    }
}
