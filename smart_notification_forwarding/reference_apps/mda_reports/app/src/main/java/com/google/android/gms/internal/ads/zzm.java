package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public final class zzm extends Thread {
    private final zzn zzaa;
    private final zza zzc;
    private final zzaa zzd;
    private volatile boolean zze = false;
    private final BlockingQueue<zzq<?>> zzz;

    public zzm(BlockingQueue<zzq<?>> blockingQueue, zzn zznVar, zza zzaVar, zzaa zzaaVar) {
        this.zzz = blockingQueue;
        this.zzaa = zznVar;
        this.zzc = zzaVar;
        this.zzd = zzaaVar;
    }

    private final void processRequest() {
        zzq<?> take = this.zzz.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        take.a(3);
        try {
            take.zzb("network-queue-take");
            take.isCanceled();
            TrafficStats.setThreadStatsTag(take.zzc());
            zzo zzc = this.zzaa.zzc(take);
            take.zzb("network-http-complete");
            if (zzc.zzac && take.zzk()) {
                take.a("not-modified");
                take.a();
                return;
            }
            zzz<?> a = take.a(zzc);
            take.zzb("network-parse-complete");
            if (take.zzg() && a.zzbh != null) {
                this.zzc.zza(take.zzd(), a.zzbh);
                take.zzb("network-cache-written");
            }
            take.zzj();
            this.zzd.zzb(take, a);
            take.a(a);
        } catch (Exception e) {
            zzag.zza(e, "Unhandled exception %s", e.toString());
            zzae zzaeVar = new zzae(e);
            zzaeVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzd.zza(take, zzaeVar);
            take.a();
        } catch (zzae e2) {
            e2.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzd.zza(take, e2);
            take.a();
        } finally {
            take.a(4);
        }
    }

    public final void quit() {
        this.zze = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
