package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzayu;

@KeepForSdkWithMembers
@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {

    @VisibleForTesting
    private CustomEventBanner zzejh;

    @VisibleForTesting
    private CustomEventInterstitial zzeji;

    @VisibleForTesting
    private CustomEventNative zzejj;
    private View zzmj;

    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzejf;
        private final MediationBannerListener zzejg;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzejf = customEventAdapter;
            this.zzejg = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzayu.zzea("Custom event adapter called onAdClicked.");
            this.zzejg.onAdClicked(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzayu.zzea("Custom event adapter called onAdClosed.");
            this.zzejg.onAdClosed(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzayu.zzea("Custom event adapter called onAdFailedToLoad.");
            this.zzejg.onAdFailedToLoad(this.zzejf, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzayu.zzea("Custom event adapter called onAdLeftApplication.");
            this.zzejg.onAdLeftApplication(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
        public final void onAdLoaded(View view) {
            zzayu.zzea("Custom event adapter called onAdLoaded.");
            this.zzejf.zza(view);
            this.zzejg.onAdLoaded(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzayu.zzea("Custom event adapter called onAdOpened.");
            this.zzejg.onAdOpened(this.zzejf);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    static class zzb implements CustomEventNativeListener {
        private final CustomEventAdapter zzejf;
        private final MediationNativeListener zzejk;

        public zzb(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzejf = customEventAdapter;
            this.zzejk = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzayu.zzea("Custom event adapter called onAdClicked.");
            this.zzejk.onAdClicked(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzayu.zzea("Custom event adapter called onAdClosed.");
            this.zzejk.onAdClosed(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzayu.zzea("Custom event adapter called onAdFailedToLoad.");
            this.zzejk.onAdFailedToLoad(this.zzejf, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdImpression() {
            zzayu.zzea("Custom event adapter called onAdImpression.");
            this.zzejk.onAdImpression(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzayu.zzea("Custom event adapter called onAdLeftApplication.");
            this.zzejk.onAdLeftApplication(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzayu.zzea("Custom event adapter called onAdLoaded.");
            this.zzejk.onAdLoaded(this.zzejf, nativeAdMapper);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
            zzayu.zzea("Custom event adapter called onAdLoaded.");
            this.zzejk.onAdLoaded(this.zzejf, unifiedNativeAdMapper);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzayu.zzea("Custom event adapter called onAdOpened.");
            this.zzejk.onAdOpened(this.zzejf);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    class zzc implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzejf;
        private final MediationInterstitialListener zzejl;

        public zzc(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzejf = customEventAdapter;
            this.zzejl = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzayu.zzea("Custom event adapter called onAdClicked.");
            this.zzejl.onAdClicked(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzayu.zzea("Custom event adapter called onAdClosed.");
            this.zzejl.onAdClosed(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzayu.zzea("Custom event adapter called onFailedToReceiveAd.");
            this.zzejl.onAdFailedToLoad(this.zzejf, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzayu.zzea("Custom event adapter called onAdLeftApplication.");
            this.zzejl.onAdLeftApplication(this.zzejf);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
        public final void onAdLoaded() {
            zzayu.zzea("Custom event adapter called onReceivedAd.");
            this.zzejl.onAdLoaded(CustomEventAdapter.this);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzayu.zzea("Custom event adapter called onAdOpened.");
            this.zzejl.onAdOpened(this.zzejf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view) {
        this.zzmj = view;
    }

    private static <T> T zzao(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzayu.zzez(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.zzmj;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.zzejh;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzeji;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.zzejj;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        CustomEventBanner customEventBanner = this.zzejh;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.zzeji;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.zzejj;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        CustomEventBanner customEventBanner = this.zzejh;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.zzeji;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.zzejj;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzejh = (CustomEventBanner) zzao(bundle.getString("class_name"));
        if (this.zzejh == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzejh.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzeji = (CustomEventInterstitial) zzao(bundle.getString("class_name"));
        if (this.zzeji == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzeji.requestInterstitialAd(context, new zzc(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.zzejj = (CustomEventNative) zzao(bundle.getString("class_name"));
        if (this.zzejj == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzejj.requestNativeAd(context, new zzb(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.zzeji.showInterstitial();
    }
}
