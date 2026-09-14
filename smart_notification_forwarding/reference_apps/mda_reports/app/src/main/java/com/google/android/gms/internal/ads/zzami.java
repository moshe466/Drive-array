package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class zzami implements Runnable {
    private final /* synthetic */ zzamf zzdef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzami(zzamf zzamfVar) {
        this.zzdef = zzamfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzali zzaliVar;
        try {
            zzaliVar = this.zzdef.zzdds;
            zzaliVar.onAdClicked();
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }
}
