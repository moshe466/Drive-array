package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzalw extends zzxe {
    private final Object lock = new Object();
    private volatile zzxg zzddj;

    @Override // com.google.android.gms.internal.ads.zzxb
    public final float getAspectRatio() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final int getPlaybackState() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean isClickToExpandEnabled() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean isCustomControlsEnabled() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean isMuted() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void mute(boolean z) {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void pause() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void play() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void stop() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void zza(zzxg zzxgVar) {
        synchronized (this.lock) {
            this.zzddj = zzxgVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final float zzpk() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final float zzpl() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final zzxg zzpm() {
        zzxg zzxgVar;
        synchronized (this.lock) {
            zzxgVar = this.zzddj;
        }
        return zzxgVar;
    }
}
