package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* loaded from: classes.dex */
public final class zzaer extends zzady {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzcwm;

    public zzaer(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzcwm = onUnifiedNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zza(zzaeg zzaegVar) {
        this.zzcwm.onUnifiedNativeAdLoaded(new zzaeh(zzaegVar));
    }
}
