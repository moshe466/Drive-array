package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcwm implements zzdgt<zzbke> {
    private final /* synthetic */ zzcoz zzgdv;
    private final /* synthetic */ zzcwl zzgip;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcwm(zzcwl zzcwlVar, zzcoz zzcozVar) {
        this.zzgip = zzcwlVar;
        this.zzgdv = zzcozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzbke zzbkeVar) {
        zzbke zzbkeVar2 = zzbkeVar;
        synchronized (this.zzgip) {
            zzcwl.a(this.zzgip, null);
            this.zzgdv.onSuccess(zzbkeVar2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        zzcxt zzcxtVar;
        synchronized (this.zzgip) {
            zzcwl.a(this.zzgip, null);
            zzcxtVar = this.zzgip.zzgio;
            ((zzbka) zzcxtVar.zzaog()).zzadd().onAdFailedToLoad(zzcfb.zzd(th));
            zzdad.zzc(th, "AppOpenAdLoader.onFailure");
            this.zzgdv.zzamx();
        }
    }
}
