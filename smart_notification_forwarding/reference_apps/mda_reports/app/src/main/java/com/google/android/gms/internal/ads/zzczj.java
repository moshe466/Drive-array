package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzczj {
    private final Clock zzbmq;
    private final Object lock = new Object();

    @GuardedBy("lock")
    private volatile int zzglg = zzczi.zzglc;
    private volatile long zzdrd = 0;

    public zzczj(Clock clock) {
        this.zzbmq = clock;
    }

    private final void zzaol() {
        long currentTimeMillis = this.zzbmq.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzglg == zzczi.zzgle) {
                if (this.zzdrd + ((Long) zzve.zzoy().zzd(zzzn.zzcpq)).longValue() <= currentTimeMillis) {
                    this.zzglg = zzczi.zzglc;
                }
            }
        }
    }

    private final void zzr(int i, int i2) {
        zzaol();
        long currentTimeMillis = this.zzbmq.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzglg != i) {
                return;
            }
            this.zzglg = i2;
            if (this.zzglg == zzczi.zzgle) {
                this.zzdrd = currentTimeMillis;
            }
        }
    }

    public final boolean zzaom() {
        boolean z;
        synchronized (this.lock) {
            zzaol();
            z = this.zzglg == zzczi.zzgld;
        }
        return z;
    }

    public final boolean zzaon() {
        boolean z;
        synchronized (this.lock) {
            zzaol();
            z = this.zzglg == zzczi.zzgle;
        }
        return z;
    }

    public final void zzbl(boolean z) {
        int i;
        int i2;
        if (z) {
            i = zzczi.zzglc;
            i2 = zzczi.zzgld;
        } else {
            i = zzczi.zzgld;
            i2 = zzczi.zzglc;
        }
        zzr(i, i2);
    }

    public final void zzvb() {
        zzr(zzczi.zzgld, zzczi.zzgle);
    }
}
