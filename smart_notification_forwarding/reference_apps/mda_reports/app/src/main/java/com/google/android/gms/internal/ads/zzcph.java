package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
final class zzcph implements zzdgt<zzcps> {
    private final /* synthetic */ zzaun zzgdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcph(zzcpi zzcpiVar, zzaun zzaunVar) {
        this.zzgdz = zzaunVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(@Nullable zzcps zzcpsVar) {
        zzcps zzcpsVar2 = zzcpsVar;
        try {
            this.zzgdz.zzk(zzcpsVar2.zzgeg, zzcpsVar2.zzgeh);
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        try {
            this.zzgdz.onError("Internal error.");
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }
}
