package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzkv {
    private static final zzno zza = zzb();

    public static zzbf zza() {
        if (!zzix.zzb()) {
            return zza;
        }
        throw new GeneralSecurityException("Cannot use non-FIPS-compliant HybridConfigurationV1 in FIPS mode");
    }

    private static zzno zzb() {
        try {
            zzpx zza2 = zzpv.zza();
            zzlc.zza(zza2);
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzku
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzyy.zza((zzkg) zzbmVar);
                }
            }, zzkg.class, zzbk.class));
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkx
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzmc.zza((zzkt) zzbmVar);
                }
            }, zzkt.class, zzbk.class));
            zzky.zza(zza2);
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkw
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzyv.zza((zzkh) zzbmVar);
                }
            }, zzkh.class, zzbh.class));
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkz
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzmd.zza((zzkl) zzbmVar);
                }
            }, zzkl.class, zzbh.class));
            return zzno.zza(zza2.zza());
        } catch (GeneralSecurityException e4) {
            throw new IllegalStateException(e4);
        }
    }
}
