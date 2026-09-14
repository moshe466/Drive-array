package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class zzye implements Runnable {
    private final /* synthetic */ zzyb zzcfk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzye(zzyb zzybVar) {
        this.zzcfk = zzybVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzxz.a(this.zzcfk.a) != null) {
            try {
                zzxz.a(this.zzcfk.a).onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzayu.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
