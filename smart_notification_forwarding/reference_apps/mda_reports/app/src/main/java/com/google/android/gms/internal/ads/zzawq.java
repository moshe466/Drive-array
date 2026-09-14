package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

/* loaded from: classes.dex */
public final class zzawq {
    private boolean zzdjk = false;
    private float zzdje = 1.0f;

    public static float zzbe(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return streamVolume / streamMaxVolume;
    }

    private final synchronized boolean zzwt() {
        return this.zzdje >= 0.0f;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.zzdjk = z;
    }

    public final synchronized void setAppVolume(float f) {
        this.zzdje = f;
    }

    public final synchronized float zzpe() {
        if (!zzwt()) {
            return 1.0f;
        }
        return this.zzdje;
    }

    public final synchronized boolean zzpf() {
        return this.zzdjk;
    }
}
