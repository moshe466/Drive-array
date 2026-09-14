package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;

/* loaded from: classes.dex */
public final class zzaho extends zzahk {
    private final InstreamAd.InstreamAdLoadCallback zzcyl;

    public zzaho(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.zzcyl = instreamAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzahh
    public final void onInstreamAdFailedToLoad(int i) {
        this.zzcyl.onInstreamAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzahh
    public final void zza(zzahb zzahbVar) {
        this.zzcyl.onInstreamAdLoaded(new zzahm(zzahbVar));
    }
}
