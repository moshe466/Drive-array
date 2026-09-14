package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* loaded from: classes.dex */
public final class zzyn extends zzwy {
    private final OnAdMetadataChangedListener zzcfq;

    public zzyn(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzcfq = onAdMetadataChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzwv
    public final void onAdMetadataChanged() {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.zzcfq;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
