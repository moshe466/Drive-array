package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzxi extends zzgc implements zzxg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void onVideoEnd() {
        b(4, c());
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void onVideoMute(boolean z) {
        Parcel c = c();
        zzge.writeBoolean(c, z);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void onVideoPause() {
        b(3, c());
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void onVideoPlay() {
        b(2, c());
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void onVideoStart() {
        b(1, c());
    }
}
