package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* loaded from: classes.dex */
final class zzanx implements com.google.android.gms.ads.internal.overlay.zzo {
    private final /* synthetic */ zzany zzdew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanx(zzany zzanyVar) {
        this.zzdew = zzanyVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
        zzayu.zzea("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
        zzayu.zzea("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzte() {
        MediationInterstitialListener mediationInterstitialListener;
        zzayu.zzea("AdMobCustomTabsAdapter overlay is closed.");
        mediationInterstitialListener = this.zzdew.zzdey;
        mediationInterstitialListener.onAdClosed(this.zzdew);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zztf() {
        MediationInterstitialListener mediationInterstitialListener;
        zzayu.zzea("Opening AdMobCustomTabsAdapter overlay.");
        mediationInterstitialListener = this.zzdew.zzdey;
        mediationInterstitialListener.onAdOpened(this.zzdew);
    }
}
