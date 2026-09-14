package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* loaded from: classes.dex */
final /* synthetic */ class zzcyg implements zzcxo {
    static final zzcxo a = new zzcyg();

    private zzcyg() {
    }

    @Override // com.google.android.gms.internal.ads.zzcxo
    public final void zzt(Object obj) {
        ((AdMetadataListener) obj).onAdMetadataChanged();
    }
}
