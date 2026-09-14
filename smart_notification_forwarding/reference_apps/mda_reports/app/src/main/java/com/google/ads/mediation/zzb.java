package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;

/* loaded from: classes.dex */
final class zzb extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter zzlp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzlp = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        InterstitialAd interstitialAd;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        InterstitialAd interstitialAd2;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener2;
        interstitialAd = this.zzlp.zzlu;
        if (interstitialAd != null) {
            mediationRewardedVideoAdListener = this.zzlp.zzlv;
            if (mediationRewardedVideoAdListener != null) {
                interstitialAd2 = this.zzlp.zzlu;
                Bundle adMetadata = interstitialAd2.getAdMetadata();
                mediationRewardedVideoAdListener2 = this.zzlp.zzlv;
                mediationRewardedVideoAdListener2.zzb(adMetadata);
            }
        }
    }
}
