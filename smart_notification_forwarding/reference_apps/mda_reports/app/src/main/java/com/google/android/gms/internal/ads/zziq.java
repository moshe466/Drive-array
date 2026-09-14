package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(24)
/* loaded from: classes.dex */
final class zziq {
    private final MediaCodec.CryptoInfo zzalz;
    private final MediaCodec.CryptoInfo.Pattern zzamb;

    private zziq(MediaCodec.CryptoInfo cryptoInfo) {
        this.zzalz = cryptoInfo;
        this.zzamb = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set(int i, int i2) {
        this.zzamb.set(i, i2);
        this.zzalz.setPattern(this.zzamb);
    }
}
