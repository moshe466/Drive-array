package com.google.android.gms.internal.ads;

import java.util.concurrent.BlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzf implements Runnable {
    private final /* synthetic */ zzq zzp;
    private final /* synthetic */ zzc zzq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(zzc zzcVar, zzq zzqVar) {
        this.zzq = zzcVar;
        this.zzp = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.zzq.zzb;
            blockingQueue.put(this.zzp);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
