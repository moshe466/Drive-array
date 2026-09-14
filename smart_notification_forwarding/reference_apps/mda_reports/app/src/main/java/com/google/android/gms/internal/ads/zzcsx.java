package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcty;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzcsx<S extends zzcty<?>> implements zzcub<S> {
    private final ScheduledExecutorService zzfdi;
    private final zzcub<S> zzgfn;
    private final long zzgge;

    public zzcsx(zzcub<S> zzcubVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zzgfn = zzcubVar;
        this.zzgge = j;
        this.zzfdi = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<S> zzanc() {
        zzdhe<S> zzanc = this.zzgfn.zzanc();
        long j = this.zzgge;
        if (j > 0) {
            zzanc = zzdgs.zza(zzanc, j, TimeUnit.MILLISECONDS, this.zzfdi);
        }
        return zzdgs.zzb(zzanc, Throwable.class, zzcsw.a, zzazd.zzdwj);
    }
}
