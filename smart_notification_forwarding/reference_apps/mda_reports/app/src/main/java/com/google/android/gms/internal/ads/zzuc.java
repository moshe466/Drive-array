package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* loaded from: classes.dex */
public final class zzuc extends zzvk {
    private final AdListener zzcbw;

    public zzuc(AdListener adListener) {
        this.zzcbw = adListener;
    }

    public final AdListener getAdListener() {
        return this.zzcbw;
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdClicked() {
        this.zzcbw.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdClosed() {
        this.zzcbw.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdFailedToLoad(int i) {
        this.zzcbw.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdImpression() {
        this.zzcbw.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdLeftApplication() {
        this.zzcbw.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdLoaded() {
        this.zzcbw.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdOpened() {
        this.zzcbw.onAdOpened();
    }
}
