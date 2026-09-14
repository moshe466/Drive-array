package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

/* loaded from: classes.dex */
public final class zzany implements MediationInterstitialAdapter {
    private Uri uri;
    private Activity zzdex;
    private MediationInterstitialListener zzdey;

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        zzayu.zzea("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        zzayu.zzea("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        zzayu.zzea("Resuming AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdey = mediationInterstitialListener;
        if (this.zzdey == null) {
            zzayu.zzez("Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            zzayu.zzez("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzdey.onAdFailedToLoad(this, 0);
            return;
        }
        if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzaao.zzk(context))) {
            zzayu.zzez("Default browser does not support custom tabs. Bailing out.");
            this.zzdey.onAdFailedToLoad(this, 0);
            return;
        }
        String string = bundle.getString("tab_url");
        if (TextUtils.isEmpty(string)) {
            zzayu.zzez("The tab_url retrieved from mediation metadata is empty. Bailing out.");
            this.zzdey.onAdFailedToLoad(this, 0);
        } else {
            this.zzdex = (Activity) context;
            this.uri = Uri.parse(string);
            this.zzdey.onAdLoaded(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.uri);
        zzawb.zzdsr.post(new zzaoa(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.zzd(build.intent), null, new zzanx(this), null, new zzazb(0, 0, false))));
        com.google.android.gms.ads.internal.zzq.zzku().zzvb();
    }
}
