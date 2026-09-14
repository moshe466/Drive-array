package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

@TargetApi(21)
/* loaded from: classes.dex */
final class zzlf implements zzld {
    private final int zzazo;
    private MediaCodecInfo[] zzazp;

    public zzlf(boolean z) {
        this.zzazo = z ? 1 : 0;
    }

    private final void zzhe() {
        if (this.zzazp == null) {
            this.zzazp = new MediaCodecList(this.zzazo).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final int getCodecCount() {
        zzhe();
        return this.zzazp.length;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final MediaCodecInfo getCodecInfoAt(int i) {
        zzhe();
        return this.zzazp[i];
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final boolean zzhd() {
        return true;
    }
}
