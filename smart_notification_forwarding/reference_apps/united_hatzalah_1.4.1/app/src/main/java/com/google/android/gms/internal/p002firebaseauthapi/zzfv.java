package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfz;
import e0.a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzfv extends zzcv {
    private final zzfz zza;
    private final zzaaf zzb;
    private final zzaae zzc;
    private final Integer zzd;

    private zzfv(zzfz zzfzVar, zzaaf zzaafVar, zzaae zzaaeVar, Integer num) {
        this.zza = zzfzVar;
        this.zzb = zzaafVar;
        this.zzc = zzaaeVar;
        this.zzd = num;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcv, com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final /* synthetic */ zzce zza() {
        return (zzfz) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcv
    /* renamed from: zzc */
    public final /* synthetic */ zzcx zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcv
    public final zzaae zzd() {
        return this.zzc;
    }

    public final zzaaf zze() {
        return this.zzb;
    }

    public static zzfv zza(zzfz zzfzVar, zzaaf zzaafVar, Integer num) {
        zzaae zzb;
        zzfz.zza zzc = zzfzVar.zzc();
        zzfz.zza zzaVar = zzfz.zza.zzb;
        if (zzc != zzaVar && num == null) {
            throw new GeneralSecurityException(a.e("For given Variant ", String.valueOf(zzfzVar.zzc()), " the value of idRequirement must be non-null"));
        }
        if (zzfzVar.zzc() == zzaVar && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzaafVar.zza() == 32) {
            if (zzfzVar.zzc() == zzaVar) {
                zzb = zzpd.zza;
            } else if (zzfzVar.zzc() == zzfz.zza.zza) {
                zzb = zzpd.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(String.valueOf(zzfzVar.zzc())));
            }
            return new zzfv(zzfzVar, zzaafVar, zzb, num);
        }
        throw new GeneralSecurityException(a.c(zzaafVar.zza(), "XAesGcmKey key must be constructed with key of length 32 bytes, not "));
    }
}
