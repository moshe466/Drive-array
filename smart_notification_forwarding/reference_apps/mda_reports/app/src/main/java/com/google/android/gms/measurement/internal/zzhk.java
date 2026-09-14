package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzkt;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhk implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhk(zzhb zzhbVar, long j) {
        this.zzb = zzhbVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhb zzhbVar = this.zzb;
        long j = this.zza;
        zzhbVar.zzd();
        zzhbVar.zzb();
        zzhbVar.zzw();
        zzhbVar.zzr().zzw().zza("Resetting analytics data (FE)");
        zzjo zzk = zzhbVar.zzk();
        zzk.zzd();
        zzk.c.a();
        boolean zzab = zzhbVar.a.zzab();
        zzff zzs = zzhbVar.zzs();
        zzs.zzh.zza(j);
        if (!TextUtils.isEmpty(zzs.zzs().zzw.zza())) {
            zzs.zzw.zza(null);
        }
        if (zzkt.zzb() && zzs.zzt().zza(zzap.zzcm)) {
            zzs.zzq.zza(0L);
        }
        if (!zzs.zzt().zzg()) {
            zzs.zzc(!zzab);
        }
        zzhbVar.zzh().zzad();
        if (zzkt.zzb() && zzhbVar.zzt().zza(zzap.zzcm)) {
            zzhbVar.zzk().b.a();
        }
        zzhbVar.c = !zzab;
        this.zzb.zzh().zza(new AtomicReference<>());
    }
}
