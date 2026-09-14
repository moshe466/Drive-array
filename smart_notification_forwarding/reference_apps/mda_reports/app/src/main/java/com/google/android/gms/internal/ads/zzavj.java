package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzavj {
    private final Object lock;
    private volatile int zzdrc;
    private volatile long zzdrd;

    private zzavj() {
        this.lock = new Object();
        this.zzdrc = zzavi.zzdqy;
        this.zzdrd = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzavj(zzavg zzavgVar) {
        this();
    }

    public final void zzvb() {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzdrc == zzavi.zzdra) {
                if (this.zzdrd + ((Long) zzve.zzoy().zzd(zzzn.zzcpq)).longValue() <= currentTimeMillis) {
                    this.zzdrc = zzavi.zzdqy;
                }
            }
        }
        long currentTimeMillis2 = com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzdrc != 2) {
                return;
            }
            this.zzdrc = 3;
            if (this.zzdrc == zzavi.zzdra) {
                this.zzdrd = currentTimeMillis2;
            }
        }
    }
}
