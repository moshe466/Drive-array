package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzcvv implements zzcub<zzcvs> {
    private ScheduledExecutorService zzffx;
    private zzaoz zzgig;
    private Context zzup;

    public zzcvv(zzaoz zzaozVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzgig = zzaozVar;
        this.zzffx = scheduledExecutorService;
        this.zzup = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcvs> zzanc() {
        return zzdgs.zzb(zzdgs.zza(this.zzgig.zzr(this.zzup), ((Long) zzve.zzoy().zzd(zzzn.zzcmu)).longValue(), TimeUnit.MILLISECONDS, this.zzffx), zzcvu.a, zzazd.zzdwe);
    }
}
