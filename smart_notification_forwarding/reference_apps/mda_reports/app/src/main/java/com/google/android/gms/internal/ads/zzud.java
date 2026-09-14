package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* loaded from: classes.dex */
public final class zzud extends zzwa {
    private final AdMetadataListener zzcbx;

    public zzud(AdMetadataListener adMetadataListener) {
        this.zzcbx = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.zzcbx;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
