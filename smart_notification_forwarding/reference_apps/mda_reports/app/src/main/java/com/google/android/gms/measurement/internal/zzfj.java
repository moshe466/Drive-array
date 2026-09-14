package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzfj {

    @VisibleForTesting
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final /* synthetic */ zzff zze;

    private zzfj(zzff zzffVar, String str, long j) {
        this.zze = zzffVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.zza = String.valueOf(str).concat(":start");
        this.zzb = String.valueOf(str).concat(":count");
        this.zzc = String.valueOf(str).concat(":value");
        this.zzd = j;
    }

    @WorkerThread
    private final void zzb() {
        this.zze.zzd();
        long currentTimeMillis = this.zze.zzm().currentTimeMillis();
        SharedPreferences.Editor edit = this.zze.zzg().edit();
        edit.remove(this.zzb);
        edit.remove(this.zzc);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    private final long zzc() {
        return this.zze.zzg().getLong(this.zza, 0L);
    }

    @WorkerThread
    public final Pair<String, Long> zza() {
        long abs;
        this.zze.zzd();
        this.zze.zzd();
        long zzc = zzc();
        if (zzc == 0) {
            zzb();
            abs = 0;
        } else {
            abs = Math.abs(zzc - this.zze.zzm().currentTimeMillis());
        }
        long j = this.zzd;
        if (abs < j) {
            return null;
        }
        if (abs > (j << 1)) {
            zzb();
            return null;
        }
        String string = this.zze.zzg().getString(this.zzc, null);
        long j2 = this.zze.zzg().getLong(this.zzb, 0L);
        zzb();
        return (string == null || j2 <= 0) ? zzff.b : new Pair<>(string, Long.valueOf(j2));
    }

    @WorkerThread
    public final void zza(String str, long j) {
        this.zze.zzd();
        if (zzc() == 0) {
            zzb();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zze.zzg().getLong(this.zzb, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.zze.zzg().edit();
            edit.putString(this.zzc, str);
            edit.putLong(this.zzb, 1L);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.zze.zzp().zzh().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
        SharedPreferences.Editor edit2 = this.zze.zzg().edit();
        if (z) {
            edit2.putString(this.zzc, str);
        }
        edit2.putLong(this.zzb, j3);
        edit2.apply();
    }
}
