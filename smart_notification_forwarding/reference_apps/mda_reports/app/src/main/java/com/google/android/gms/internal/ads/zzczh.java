package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* loaded from: classes.dex */
final class zzczh extends AdMetadataListener {
    private final /* synthetic */ zzczf zzgla;
    private final /* synthetic */ zzvx zzglb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzczh(zzczf zzczfVar, zzvx zzvxVar) {
        this.zzgla = zzczfVar;
        this.zzglb = zzvxVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzcbb zzcbbVar;
        zzcbbVar = this.zzgla.zzgky;
        if (zzcbbVar != null) {
            try {
                this.zzglb.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
