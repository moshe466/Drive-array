package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* loaded from: classes.dex */
final /* synthetic */ class zzbqd implements zzbrn {
    static final zzbrn a = new zzbqd();

    private zzbqd() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrn
    public final void zzp(Object obj) {
        ((AdMetadataListener) obj).onAdMetadataChanged();
    }
}
