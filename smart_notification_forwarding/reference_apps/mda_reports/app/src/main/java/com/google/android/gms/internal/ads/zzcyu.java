package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcyu implements zzdgt<zzcbb> {
    private final /* synthetic */ zzcoz zzgdv;
    private final /* synthetic */ zzcyt zzgku;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcyu(zzcyt zzcytVar, zzcoz zzcozVar) {
        this.zzgku = zzcytVar;
        this.zzgdv = zzcozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzcbb zzcbbVar) {
        zzcxz zzcxzVar;
        zzcbb zzcbbVar2 = zzcbbVar;
        synchronized (this.zzgku) {
            this.zzgdv.onSuccess(zzcbbVar2);
            zzcxzVar = this.zzgku.zzgks;
            zzcxzVar.onAdMetadataChanged();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        zzcxt zzcxtVar;
        synchronized (this.zzgku) {
            zzcxtVar = this.zzgku.zzgio;
            ((zzcbi) zzcxtVar.zzaog()).zzadd().onAdFailedToLoad(zzcfb.zzd(th));
            zzdad.zzc(th, "RewardedAdLoader.onFailure");
            this.zzgdv.zzamx();
        }
    }
}
