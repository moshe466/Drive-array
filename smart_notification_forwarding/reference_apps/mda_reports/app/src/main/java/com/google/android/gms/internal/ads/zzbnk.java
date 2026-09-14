package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public final class zzbnk implements zzbov, zzbpe, zzbqb, zzbqx, zzty {
    private final Clock zzbmq;
    private final zzavd zzfgv;

    public zzbnk(Clock clock, zzavd zzavdVar) {
        this.zzbmq = clock;
        this.zzfgv = zzavdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void onAdClicked() {
        this.zzfgv.zzuw();
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdClosed() {
        this.zzfgv.zzux();
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final void onAdImpression() {
        this.zzfgv.zzuv();
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final void onAdLoaded() {
        this.zzfgv.zzan(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzaqk zzaqkVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void zzb(zzare zzareVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzczt zzcztVar) {
        this.zzfgv.zzey(this.zzbmq.elapsedRealtime());
    }

    public final void zzf(zzug zzugVar) {
        this.zzfgv.zze(zzugVar);
    }

    public final String zzuy() {
        return this.zzfgv.zzuy();
    }
}
