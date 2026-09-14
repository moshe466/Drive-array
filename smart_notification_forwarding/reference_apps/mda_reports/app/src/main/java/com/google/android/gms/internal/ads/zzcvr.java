package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzcvr implements zzcub<zzcvo> {
    private ApplicationInfo applicationInfo;
    private boolean zzdlv;
    private ScheduledExecutorService zzffx;
    private zzakp zzgid;

    public zzcvr(zzakp zzakpVar, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo) {
        this.zzgid = zzakpVar;
        this.zzffx = scheduledExecutorService;
        this.zzdlv = z;
        this.applicationInfo = applicationInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcvo> zzanc() {
        if (!this.zzdlv) {
            return zzdgs.zzk(new Exception("Auto Collect Location is false."));
        }
        return zzdgs.zzb(zzdgs.zza(this.zzgid.zza(this.applicationInfo), ((Long) zzve.zzoy().zzd(zzzn.zzcmn)).longValue(), TimeUnit.MILLISECONDS, this.zzffx), zzcvq.a, zzazd.zzdwe);
    }
}
