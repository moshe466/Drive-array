package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzdaf<T> {
    private final zzdhd zzfov;

    @GuardedBy("this")
    private final Deque<zzdhe<T>> zzgmw = new LinkedBlockingDeque();
    private final Callable<T> zzgmx;

    public zzdaf(Callable<T> callable, zzdhd zzdhdVar) {
        this.zzgmx = callable;
        this.zzfov = zzdhdVar;
    }

    public final synchronized zzdhe<T> zzaou() {
        zzdm(1);
        return this.zzgmw.poll();
    }

    public final synchronized void zzb(zzdhe<T> zzdheVar) {
        this.zzgmw.addFirst(zzdheVar);
    }

    public final synchronized void zzdm(int i) {
        int size = i - this.zzgmw.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zzgmw.add(this.zzfov.zzd(this.zzgmx));
        }
    }
}
