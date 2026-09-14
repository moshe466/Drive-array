package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class zzyg implements Runnable {
    private final /* synthetic */ zzyd zzcfm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyg(zzyd zzydVar) {
        this.zzcfm = zzydVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzvh zzvhVar;
        zzvh zzvhVar2;
        zzvhVar = this.zzcfm.zzblq;
        if (zzvhVar != null) {
            try {
                zzvhVar2 = this.zzcfm.zzblq;
                zzvhVar2.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzayu.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
