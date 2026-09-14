package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzty;
import com.google.android.gms.internal.ads.zzxn;

/* loaded from: classes.dex */
public final class InterstitialAd {
    private final zzxn zzabl;

    public InterstitialAd(Context context) {
        this.zzabl = new zzxn(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzabl.getAdListener();
    }

    public final Bundle getAdMetadata() {
        return this.zzabl.getAdMetadata();
    }

    public final String getAdUnitId() {
        return this.zzabl.getAdUnitId();
    }

    public final String getMediationAdapterClassName() {
        return this.zzabl.getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        return this.zzabl.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzabl.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest) {
        this.zzabl.zza(adRequest.zzdg());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAdListener(AdListener adListener) {
        this.zzabl.setAdListener(adListener);
        if (adListener != 0 && (adListener instanceof zzty)) {
            this.zzabl.zza((zzty) adListener);
        } else if (adListener == 0) {
            this.zzabl.zza((zzty) null);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.zzabl.setAdMetadataListener(adMetadataListener);
    }

    public final void setAdUnitId(String str) {
        this.zzabl.setAdUnitId(str);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzabl.setImmersiveMode(z);
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzabl.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void show() {
        this.zzabl.show();
    }

    public final void zzd(boolean z) {
        this.zzabl.zzd(true);
    }
}
