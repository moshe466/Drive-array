package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbva implements zzbov {
    private final zzbpd zzfjm;
    private final zzczl zzfjn;

    public zzbva(zzbpd zzbpdVar, zzczl zzczlVar) {
        this.zzfjm = zzbpdVar;
        this.zzfjn = zzczlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdOpened() {
        int i = this.zzfjn.zzglz;
        if (i == 0 || i == 1) {
            this.zzfjm.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void zzb(zzare zzareVar, String str, String str2) {
    }
}
