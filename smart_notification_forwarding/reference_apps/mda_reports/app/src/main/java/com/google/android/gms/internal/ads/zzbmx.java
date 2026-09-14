package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class zzbmx implements com.google.android.gms.ads.internal.overlay.zzo {
    private final zzbpm zzfgg;
    private AtomicBoolean zzfgh = new AtomicBoolean(false);

    public zzbmx(zzbpm zzbpmVar) {
        this.zzfgg = zzbpmVar;
    }

    public final boolean isClosed() {
        return this.zzfgh.get();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzte() {
        this.zzfgh.set(true);
        this.zzfgg.onAdClosed();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zztf() {
        this.zzfgg.onAdOpened();
    }
}
