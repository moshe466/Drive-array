package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzcn {
    private static final zzno zza = zzb();

    public static /* synthetic */ zzbe zza(zzgb zzgbVar) {
        if (zzij.zza()) {
            return zzij.zza(zzgbVar);
        }
        return zzaab.zza(zzgbVar);
    }

    private static zzno zzb() {
        try {
            zzpx zza2 = zzpv.zza();
            zzda.zza(zza2);
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzcq
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzze.zza((zzdd) zzbmVar);
                }
            }, zzdd.class, zzbe.class));
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzcp
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzys.zza((zzds) zzbmVar);
                }
            }, zzds.class, zzbe.class));
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzcs
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzis.zza((zzeb) zzbmVar);
                }
            }, zzeb.class, zzbe.class));
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzcr
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzyn.zza((zzdl) zzbmVar);
                }
            }, zzdl.class, zzbe.class));
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzcu
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzcn.zza((zzei) zzbmVar);
                }
            }, zzei.class, zzbe.class));
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzct
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzcn.zza((zzgb) zzbmVar);
                }
            }, zzgb.class, zzbe.class));
            zza2.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzcw
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzie.zza((zzfv) zzbmVar);
                }
            }, zzfv.class, zzbe.class));
            return zzno.zza(zza2.zza());
        } catch (GeneralSecurityException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static /* synthetic */ zzbe zza(zzei zzeiVar) {
        if (zzhk.zzb()) {
            return zzhk.zza(zzeiVar);
        }
        return zzyw.zza(zzeiVar);
    }

    public static zzbf zza() {
        if (!zzix.zzb()) {
            return zza;
        }
        throw new GeneralSecurityException("Cannot use non-FIPS-compliant AeadConfigurationV1 in FIPS mode");
    }
}
