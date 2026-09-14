package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
public final class zzcc {
    public static zzbq zza(zzby zzbyVar, zzck zzckVar) {
        if (zzckVar != null) {
            return zzbq.zza(zzbyVar.zzb());
        }
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static void zza(zzbq zzbqVar, zzbx zzbxVar, zzck zzckVar) {
        if (zzckVar != null) {
            zzbxVar.zza(zzbqVar.zzd());
            return;
        }
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }
}
