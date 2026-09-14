package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

/* loaded from: classes.dex */
public final class zzasx extends zzask {
    private final RewardedAdCallback zzdoa;

    public zzasx(RewardedAdCallback rewardedAdCallback) {
        this.zzdoa = rewardedAdCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzasl
    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.zzdoa;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasl
    public final void onRewardedAdFailedToShow(int i) {
        RewardedAdCallback rewardedAdCallback = this.zzdoa;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasl
    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.zzdoa;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasl
    public final void zza(zzasf zzasfVar) {
        RewardedAdCallback rewardedAdCallback = this.zzdoa;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzasu(zzasfVar));
        }
    }
}
