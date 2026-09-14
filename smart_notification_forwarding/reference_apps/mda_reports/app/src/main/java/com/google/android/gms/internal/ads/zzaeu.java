package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* loaded from: classes.dex */
public final class zzaeu extends zzaee {
    private final UnifiedNativeAd.UnconfirmedClickListener zzcwr;

    public zzaeu(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzcwr = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final void onUnconfirmedClickCancelled() {
        this.zzcwr.onUnconfirmedClickCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final void onUnconfirmedClickReceived(String str) {
        this.zzcwr.onUnconfirmedClickReceived(str);
    }
}
