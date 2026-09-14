package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzem;
import e0.a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzei extends zzcv {
    private final zzem zza;
    private final zzaaf zzb;
    private final zzaae zzc;
    private final Integer zzd;

    private zzei(zzem zzemVar, zzaaf zzaafVar, zzaae zzaaeVar, Integer num) {
        this.zza = zzemVar;
        this.zzb = zzaafVar;
        this.zzc = zzaaeVar;
        this.zzd = num;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcv, com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final /* synthetic */ zzce zza() {
        return (zzem) zza();
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

    public static zzei zza(zzem.zza zzaVar, zzaaf zzaafVar, Integer num) {
        zzaae zzb;
        zzem.zza zzaVar2 = zzem.zza.zzc;
        if (zzaVar != zzaVar2 && num == null) {
            throw new GeneralSecurityException(a.e("For given Variant ", String.valueOf(zzaVar), " the value of idRequirement must be non-null"));
        }
        if (zzaVar == zzaVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzaafVar.zza() == 32) {
            zzem zza = zzem.zza(zzaVar);
            if (zza.zzb() == zzaVar2) {
                zzb = zzpd.zza;
            } else if (zza.zzb() == zzem.zza.zzb) {
                zzb = zzpd.zza(num.intValue());
            } else if (zza.zzb() == zzem.zza.zza) {
                zzb = zzpd.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(String.valueOf(zza.zzb())));
            }
            return new zzei(zza, zzaafVar, zzb, num);
        }
        throw new GeneralSecurityException(a.c(zzaafVar.zza(), "ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not "));
    }
}
