package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzkt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzjy {
    final /* synthetic */ zzjo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjy(zzjo zzjoVar) {
        this.a = zzjoVar;
    }

    @VisibleForTesting
    @WorkerThread
    private final void zzb(long j, boolean z) {
        this.a.zzd();
        if (zzkt.zzb() && this.a.zzt().zza(zzap.zzaw)) {
            if (!this.a.a.zzab()) {
                return;
            } else {
                this.a.zzs().zzq.zza(j);
            }
        }
        this.a.zzr().zzx().zza("Session started, time", Long.valueOf(this.a.zzm().elapsedRealtime()));
        Long valueOf = this.a.zzt().zza(zzap.zzap) ? Long.valueOf(j / 1000) : null;
        this.a.zzf().a("auto", "_sid", valueOf, j);
        this.a.zzs().zzm.zza(false);
        Bundle bundle = new Bundle();
        if (this.a.zzt().zza(zzap.zzap)) {
            bundle.putLong("_sid", valueOf.longValue());
        }
        if (this.a.zzt().zza(zzap.zzce) && z) {
            bundle.putLong("_aib", 1L);
        }
        this.a.zzf().a("auto", "_s", j, bundle);
        if (com.google.android.gms.internal.measurement.zzkb.zzb() && this.a.zzt().zza(zzap.zzcl)) {
            String zza = this.a.zzs().zzw.zza();
            if (!TextUtils.isEmpty(zza)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", zza);
                this.a.zzf().a("auto", "_ssr", j, bundle2);
            }
        }
        if (zzkt.zzb() && this.a.zzt().zza(zzap.zzaw)) {
            return;
        }
        this.a.zzs().zzq.zza(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a() {
        if (zzkt.zzb() && this.a.zzt().zza(zzap.zzaw)) {
            this.a.zzd();
            if (this.a.zzs().zza(this.a.zzm().currentTimeMillis())) {
                this.a.zzs().zzm.zza(true);
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    if (runningAppProcessInfo.importance == 100) {
                        this.a.zzr().zzx().zza("Detected application was in foreground");
                        zzb(this.a.zzm().currentTimeMillis(), false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(long j, boolean z) {
        this.a.zzd();
        this.a.zzac();
        if (this.a.zzs().zza(j)) {
            this.a.zzs().zzm.zza(true);
            this.a.zzs().zzr.zza(0L);
        }
        if (z && this.a.zzt().zza(zzap.zzar)) {
            this.a.zzs().zzq.zza(j);
        }
        if (this.a.zzs().zzm.zza()) {
            zzb(j, z);
        }
    }
}
