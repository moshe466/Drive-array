package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzcpd implements zzdgt<zzbmd> {
    private final /* synthetic */ zzcoz zzgdv;
    private final /* synthetic */ zzbvm zzgdw;
    private final /* synthetic */ zzcpb zzgdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcpd(zzcpb zzcpbVar, zzcoz zzcozVar, zzbvm zzbvmVar) {
        this.zzgdx = zzcpbVar;
        this.zzgdv = zzcozVar;
        this.zzgdw = zzbvmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzbmd zzbmdVar) {
        zzbmd zzbmdVar2 = zzbmdVar;
        synchronized (this.zzgdx) {
            this.zzgdv.onSuccess(zzbmdVar2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        this.zzgdw.zzadd().onAdFailedToLoad(zzcfb.zzd(th));
        zzdad.zzc(th, "NativeAdLoader.onFailure");
        this.zzgdv.zzamx();
    }
}
