package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zzrd extends zzrj {
    private final WeakReference<AppOpenAd.AppOpenAdLoadCallback> zzbqw;

    public zzrd(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzbqw = new WeakReference<>(appOpenAdLoadCallback);
    }

    @Override // com.google.android.gms.internal.ads.zzrg
    public final void onAppOpenAdFailedToLoad(int i) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbqw.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrg
    public final void zza(zzrf zzrfVar) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbqw.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdLoaded(new zzrm(zzrfVar));
        }
    }
}
