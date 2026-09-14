package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

/* loaded from: classes.dex */
public final class zzws extends zzwq {
    private final MuteThisAdListener zzceb;

    public zzws(MuteThisAdListener muteThisAdListener) {
        this.zzceb = muteThisAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzwn
    public final void onAdMuted() {
        this.zzceb.onAdMuted();
    }
}
