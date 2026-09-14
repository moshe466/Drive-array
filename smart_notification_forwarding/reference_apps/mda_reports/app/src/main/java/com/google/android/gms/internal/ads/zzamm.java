package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* loaded from: classes.dex */
final class zzamm implements Runnable {
    private final /* synthetic */ zzamf zzdef;
    private final /* synthetic */ AdRequest.ErrorCode zzdeg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamm(zzamf zzamfVar, AdRequest.ErrorCode errorCode) {
        this.zzdef = zzamfVar;
        this.zzdeg = errorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzali zzaliVar;
        try {
            zzaliVar = this.zzdef.zzdds;
            zzaliVar.onAdFailedToLoad(zzamr.zza(this.zzdeg));
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }
}
