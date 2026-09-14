package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
public final class zzbr {
    private boolean zza;
    private zzbo zzb;
    private final zzce zzc;
    private zzbu zzd;
    private zzbs zze;

    private zzbr(zzce zzceVar) {
        this.zzb = zzbo.zza;
        this.zzd = null;
        this.zze = null;
        this.zzc = zzceVar;
    }

    public final zzbr zzb() {
        zzbu zzbuVar;
        zzbuVar = zzbu.zza;
        this.zzd = zzbuVar;
        return this;
    }

    public final zzbr zza() {
        zzbs zzbsVar = this.zze;
        if (zzbsVar != null) {
            zzbs.zza(zzbsVar);
        }
        this.zza = true;
        return this;
    }
}
