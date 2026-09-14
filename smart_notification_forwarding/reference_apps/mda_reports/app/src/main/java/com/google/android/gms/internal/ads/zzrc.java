package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback;

/* loaded from: classes.dex */
public final class zzrc extends zzrk {
    private final AppOpenAdPresentationCallback zzbqv;

    public zzrc(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzbqv = appOpenAdPresentationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzrl
    public final void onAppOpenAdClosed() {
        this.zzbqv.onAppOpenAdClosed();
    }
}
