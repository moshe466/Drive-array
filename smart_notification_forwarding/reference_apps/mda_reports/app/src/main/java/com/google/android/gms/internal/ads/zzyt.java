package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* loaded from: classes.dex */
public final class zzyt extends zzxf {
    private final VideoController.VideoLifecycleCallbacks zzabu;

    public zzyt(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzabu = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void onVideoEnd() {
        this.zzabu.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void onVideoMute(boolean z) {
        this.zzabu.onVideoMute(z);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void onVideoPause() {
        this.zzabu.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void onVideoPlay() {
        this.zzabu.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void onVideoStart() {
        this.zzabu.onVideoStart();
    }
}
