package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzxn;

/* loaded from: classes.dex */
public final class PublisherInterstitialAd {
    private final zzxn zzabl;

    public PublisherInterstitialAd(Context context) {
        this.zzabl = new zzxn(context, this);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzabl.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzabl.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzabl.getAppEventListener();
    }

    public final String getMediationAdapterClassName() {
        return this.zzabl.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzabl.getOnCustomRenderedAdLoadedListener();
    }

    public final boolean isLoaded() {
        return this.zzabl.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzabl.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzabl.zza(publisherAdRequest.zzdg());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzabl.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzabl.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzabl.setAppEventListener(appEventListener);
    }

    @KeepForSdk
    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public final void setImmersiveMode(boolean z) {
        this.zzabl.setImmersiveMode(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzabl.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void show() {
        this.zzabl.show();
    }
}
