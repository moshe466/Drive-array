package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzaxw {
    private HandlerThread zzdup = null;
    private Handler handler = null;
    private int zzduq = 0;
    private final Object lock = new Object();

    public final Handler getHandler() {
        return this.handler;
    }

    public final Looper zzxb() {
        Looper looper;
        synchronized (this.lock) {
            if (this.zzduq != 0) {
                Preconditions.checkNotNull(this.zzdup, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzdup == null) {
                zzavs.zzed("Starting the looper thread.");
                this.zzdup = new HandlerThread("LooperProvider");
                this.zzdup.start();
                this.handler = new zzddu(this.zzdup.getLooper());
                zzavs.zzed("Looper thread started.");
            } else {
                zzavs.zzed("Resuming the looper thread");
                this.lock.notifyAll();
            }
            this.zzduq++;
            looper = this.zzdup.getLooper();
        }
        return looper;
    }
}
