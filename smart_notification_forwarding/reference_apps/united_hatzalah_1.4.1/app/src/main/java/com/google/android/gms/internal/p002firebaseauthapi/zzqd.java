package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
public final class zzqd implements zzqi {
    private final zzaae zza;
    private final zzww zzb;

    private zzqd(zzww zzwwVar, zzaae zzaaeVar) {
        this.zzb = zzwwVar;
        this.zza = zzaaeVar;
    }

    public static zzqd zza(zzww zzwwVar) {
        return new zzqd(zzwwVar, zzqq.zza(zzwwVar.zzf()));
    }

    public static zzqd zzb(zzww zzwwVar) {
        return new zzqd(zzwwVar, zzqq.zzb(zzwwVar.zzf()));
    }

    public final zzww zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqi
    public final zzaae zzb() {
        return this.zza;
    }
}
