package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzel<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzej<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;

    @GuardedBy("overrideLock")
    private volatile V zzg;

    @GuardedBy("cachingLock")
    private volatile V zzh;

    private zzel(@NonNull String str, @NonNull V v, @NonNull V v2, @Nullable zzej<V> zzejVar) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzejVar;
    }

    public final V zza(@Nullable V v) {
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzem.a == null) {
            return this.zzc;
        }
        synchronized (zzf) {
            if (zzw.zza()) {
                return this.zzh == null ? this.zzc : this.zzh;
            }
            try {
                for (zzel zzelVar : zzap.v0()) {
                    if (zzw.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V v2 = null;
                    try {
                        if (zzelVar.zzb != null) {
                            v2 = zzelVar.zzb.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zzf) {
                        zzelVar.zzh = v2;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzej<V> zzejVar = this.zzb;
            if (zzejVar == null) {
                return this.zzc;
            }
            try {
                return zzejVar.zza();
            } catch (IllegalStateException unused3) {
                return this.zzc;
            } catch (SecurityException unused4) {
                return this.zzc;
            }
        }
    }

    public final String zza() {
        return this.zza;
    }
}
