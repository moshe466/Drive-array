package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzasv;

/* loaded from: classes.dex */
public final class RewardedAd {
    private final zzasv zzgrt;

    public RewardedAd(Context context, String str) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "adUnitID cannot be null");
        this.zzgrt = new zzasv(context, str);
    }

    public final Bundle getAdMetadata() {
        return this.zzgrt.getAdMetadata();
    }

    public final String getMediationAdapterClassName() {
        return this.zzgrt.getMediationAdapterClassName();
    }

    @Nullable
    public final RewardItem getRewardItem() {
        return this.zzgrt.getRewardItem();
    }

    public final boolean isLoaded() {
        return this.zzgrt.isLoaded();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzgrt.zza(adRequest.zzdg(), rewardedAdLoadCallback);
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzgrt.zza(publisherAdRequest.zzdg(), rewardedAdLoadCallback);
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzgrt.setOnAdMetadataChangedListener(onAdMetadataChangedListener);
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.zzgrt.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        this.zzgrt.show(activity, rewardedAdCallback);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        this.zzgrt.show(activity, rewardedAdCallback, z);
    }
}
