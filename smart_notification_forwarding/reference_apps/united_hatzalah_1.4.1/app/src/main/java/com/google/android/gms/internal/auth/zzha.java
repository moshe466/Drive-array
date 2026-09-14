package com.google.android.gms.internal.auth;

/* loaded from: classes.dex */
final class zzha extends zzgy {
    @Override // com.google.android.gms.internal.auth.zzgy
    public final /* synthetic */ Object zza(Object obj) {
        return ((zzeu) obj).zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final /* bridge */ /* synthetic */ Object zzb(Object obj, Object obj2) {
        zzgz zzgzVar = (zzgz) obj2;
        if (zzgzVar.equals(zzgz.zza())) {
            return obj;
        }
        return zzgz.zzb((zzgz) obj, zzgzVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final /* synthetic */ Object zzc() {
        return zzgz.zzc();
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i, long j2) {
        ((zzgz) obj).zzf(i << 3, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final void zze(Object obj) {
        ((zzeu) obj).zzc.zzd();
    }

    @Override // com.google.android.gms.internal.auth.zzgy
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        ((zzeu) obj).zzc = (zzgz) obj2;
    }
}
