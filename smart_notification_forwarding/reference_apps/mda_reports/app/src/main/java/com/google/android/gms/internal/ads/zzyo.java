package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class zzyo implements Runnable {
    private final /* synthetic */ zzyl zzcfr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyo(zzyl zzylVar) {
        this.zzcfr = zzylVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaro zzaroVar;
        zzaro zzaroVar2;
        zzaroVar = this.zzcfr.zzcfo;
        if (zzaroVar != null) {
            try {
                zzaroVar2 = this.zzcfr.zzcfo;
                zzaroVar2.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzayu.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
