package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* loaded from: classes.dex */
final class zzpe implements Handler.Callback, Choreographer.FrameCallback {
    private static final zzpe zzbjc = new zzpe();
    private final zzddu zzaee;
    public volatile long zzbjb;
    private final HandlerThread zzbjd = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer zzbje;
    private int zzbjf;

    private zzpe() {
        this.zzbjd.start();
        this.zzaee = new zzddu(this.zzbjd.getLooper(), this);
        this.zzaee.sendEmptyMessage(0);
    }

    public static zzpe zzjg() {
        return zzbjc;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.zzbjb = j;
        this.zzbje.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.zzbje = Choreographer.getInstance();
            return true;
        }
        if (i == 1) {
            this.zzbjf++;
            if (this.zzbjf == 1) {
                this.zzbje.postFrameCallback(this);
            }
            return true;
        }
        if (i != 2) {
            return false;
        }
        this.zzbjf--;
        if (this.zzbjf == 0) {
            this.zzbje.removeFrameCallback(this);
            this.zzbjb = 0L;
        }
        return true;
    }

    public final void zzjh() {
        this.zzaee.sendEmptyMessage(1);
    }

    public final void zzji() {
        this.zzaee.sendEmptyMessage(2);
    }
}
