package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;

@TargetApi(14)
/* loaded from: classes.dex */
public final class zzbba implements AudioManager.OnAudioFocusChangeListener {
    private float zzcy = 1.0f;
    private boolean zzdya;
    private final AudioManager zzeba;
    private final zzbbd zzebb;
    private boolean zzebc;
    private boolean zzebd;

    public zzbba(Context context, zzbbd zzbbdVar) {
        this.zzeba = (AudioManager) context.getSystemService("audio");
        this.zzebb = zzbbdVar;
    }

    private final void zzyv() {
        boolean z;
        boolean z2;
        boolean z3 = this.zzdya && !this.zzebd && this.zzcy > 0.0f;
        if (z3 && !(z2 = this.zzebc)) {
            AudioManager audioManager = this.zzeba;
            if (audioManager != null && !z2) {
                this.zzebc = audioManager.requestAudioFocus(this, 3, 2) == 1;
            }
            this.zzebb.zzxs();
            return;
        }
        if (z3 || !(z = this.zzebc)) {
            return;
        }
        AudioManager audioManager2 = this.zzeba;
        if (audioManager2 != null && z) {
            this.zzebc = audioManager2.abandonAudioFocus(this) == 0;
        }
        this.zzebb.zzxs();
    }

    public final float getVolume() {
        float f = this.zzebd ? 0.0f : this.zzcy;
        if (this.zzebc) {
            return f;
        }
        return 0.0f;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.zzebc = i > 0;
        this.zzebb.zzxs();
    }

    public final void setMuted(boolean z) {
        this.zzebd = z;
        zzyv();
    }

    public final void setVolume(float f) {
        this.zzcy = f;
        zzyv();
    }

    public final void zzyi() {
        this.zzdya = true;
        zzyv();
    }

    public final void zzyj() {
        this.zzdya = false;
        zzyv();
    }
}
