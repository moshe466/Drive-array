package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* loaded from: classes.dex */
final class zzczb extends AdMetadataListener {
    private final /* synthetic */ zzcyz zzgkv;
    private final /* synthetic */ zzwv zzgkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzczb(zzcyz zzcyzVar, zzwv zzwvVar) {
        this.zzgkv = zzcyzVar;
        this.zzgkz = zzwvVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzcbb zzcbbVar;
        zzcbbVar = this.zzgkv.zzgky;
        if (zzcbbVar != null) {
            try {
                this.zzgkz.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
