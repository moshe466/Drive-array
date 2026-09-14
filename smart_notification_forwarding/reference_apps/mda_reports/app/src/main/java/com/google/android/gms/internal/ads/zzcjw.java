package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcjw implements zzdgt<zzbkk> {
    private final /* synthetic */ zzcjr zzfzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcjw(zzcjr zzcjrVar) {
        this.zzfzd = zzcjrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzbkk zzbkkVar) {
        zzbkkVar.zzagf();
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        zzbou zzbouVar;
        zzbouVar = this.zzfzd.zzfik;
        zzbouVar.onAdFailedToLoad(zzcfb.zzd(th));
        zzdad.zzc(th, "DelayedBannerAd.onFailure");
    }
}
