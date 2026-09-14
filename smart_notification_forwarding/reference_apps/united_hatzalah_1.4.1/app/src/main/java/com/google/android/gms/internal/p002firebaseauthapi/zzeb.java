package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzeg;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzeb extends zzcv {
    private final zzeg zza;
    private final zzaaf zzb;
    private final zzaae zzc;
    private final Integer zzd;

    /* loaded from: classes.dex */
    public static class zza {
        private zzeg zza;
        private zzaaf zzb;
        private Integer zzc;

        public final zza zza(Integer num) {
            this.zzc = num;
            return this;
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzaaf zzaafVar) {
            this.zzb = zzaafVar;
            return this;
        }

        public final zza zza(zzeg zzegVar) {
            this.zza = zzegVar;
            return this;
        }

        public final zzeb zza() {
            zzaae zzb;
            zzeg zzegVar = this.zza;
            if (zzegVar != null && this.zzb != null) {
                if (zzegVar.zzb() == this.zzb.zza()) {
                    if (this.zza.zza() && this.zzc == null) {
                        throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                    }
                    if (!this.zza.zza() && this.zzc != null) {
                        throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                    }
                    if (this.zza.zzd() == zzeg.zza.zzc) {
                        zzb = zzpd.zza;
                    } else if (this.zza.zzd() == zzeg.zza.zzb) {
                        zzb = zzpd.zza(this.zzc.intValue());
                    } else if (this.zza.zzd() == zzeg.zza.zza) {
                        zzb = zzpd.zzb(this.zzc.intValue());
                    } else {
                        throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
                    }
                    return new zzeb(this.zza, this.zzb, zzb, this.zzc);
                }
                throw new GeneralSecurityException("Key size mismatch");
            }
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
    }

    public static zza zze() {
        return new zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcv, com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final /* synthetic */ zzce zza() {
        return (zzeg) zza();
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

    public final zzaaf zzf() {
        return this.zzb;
    }

    private zzeb(zzeg zzegVar, zzaaf zzaafVar, zzaae zzaaeVar, Integer num) {
        this.zza = zzegVar;
        this.zzb = zzaafVar;
        this.zzc = zzaaeVar;
        this.zzd = num;
    }
}
