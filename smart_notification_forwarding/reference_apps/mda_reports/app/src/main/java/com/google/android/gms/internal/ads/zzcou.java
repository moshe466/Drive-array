package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzcou implements zzdgt<zzbtu> {
    private final /* synthetic */ zzbup zzgdk;
    private final /* synthetic */ zzcor zzgdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcou(zzcor zzcorVar, zzbup zzbupVar) {
        this.zzgdl = zzcorVar;
        this.zzgdk = zzbupVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzbtu zzbtuVar) {
        zzbtu zzbtuVar2 = zzbtuVar;
        synchronized (this.zzgdl) {
            zzcor.a(this.zzgdl, (zzdhe) null);
            this.zzgdl.zzgdf = zzbtuVar2;
            zzbtuVar2.zzagf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        synchronized (this.zzgdl) {
            zzcor.a(this.zzgdl, (zzdhe) null);
            this.zzgdk.zzadd().onAdFailedToLoad(zzcfb.zzd(th));
            zzdad.zzc(th, "InterstitialAdManagerShim.onFailure");
        }
    }
}
