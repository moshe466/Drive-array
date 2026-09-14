package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* loaded from: classes.dex */
final class zzanu implements SignalCallbacks {
    private final /* synthetic */ zzanj zzdeu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanu(zzann zzannVar, zzanj zzanjVar) {
        this.zzdeu = zzanjVar;
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onFailure(String str) {
        try {
            this.zzdeu.onFailure(str);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onSuccess(String str) {
        try {
            this.zzdeu.zzdn(str);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }
}
