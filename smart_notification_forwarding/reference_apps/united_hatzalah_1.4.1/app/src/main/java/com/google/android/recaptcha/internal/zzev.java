package com.google.android.recaptcha.internal;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzev {
    public static final zzrl zza(zzbn zzbnVar, zzbn zzbnVar2) {
        zzrj zzf = zzrl.zzf();
        zzf.zzq(zzqb.zzb(zzbnVar.zzb()));
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        zzf.zzr(zzpz.zza(zzbnVar.zza(timeUnit)));
        zzf.zze(zzqb.zzb(zzbnVar2.zzb()));
        zzf.zzf(zzpz.zza(zzbnVar2.zza(timeUnit)));
        return (zzrl) zzf.zzk();
    }
}
