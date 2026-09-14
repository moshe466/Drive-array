package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import androidx.annotation.NonNull;

@TargetApi(23)
/* loaded from: classes.dex */
final class zzpc implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzox zzbja;

    private zzpc(zzox zzoxVar, MediaCodec mediaCodec) {
        this.zzbja = zzoxVar;
        mediaCodec.setOnFrameRenderedListener(this, new zzddu());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
        zzox zzoxVar = this.zzbja;
        if (this != zzoxVar.b) {
            return;
        }
        zzoxVar.l();
    }
}
