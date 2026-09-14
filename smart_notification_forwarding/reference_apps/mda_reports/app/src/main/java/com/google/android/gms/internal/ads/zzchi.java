package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes.dex */
final class zzchi implements zzdgt<ParcelFileDescriptor> {
    private final /* synthetic */ zzaqe zzfwk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzchi(zzcgw zzcgwVar, zzaqe zzaqeVar) {
        this.zzfwk = zzaqeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            this.zzfwk.zzb(parcelFileDescriptor);
        } catch (RemoteException e) {
            zzavs.zza("Service can't call client", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        try {
            this.zzfwk.zza(zzaxc.zza(th, zzcfb.zzd(th)));
        } catch (RemoteException e) {
            zzavs.zza("Service can't call client", e);
        }
    }
}
