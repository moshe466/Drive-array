package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqw;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzqp extends zzrn {
    private final zzqw zza;
    private final zzaaf zzb;
    private final zzaae zzc;
    private final Integer zzd;

    /* loaded from: classes.dex */
    public static class zza {
        private zzqw zza;
        private zzaaf zzb;
        private Integer zzc;

        public final zza zza(zzaaf zzaafVar) {
            this.zzb = zzaafVar;
            return this;
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(Integer num) {
            this.zzc = num;
            return this;
        }

        public final zza zza(zzqw zzqwVar) {
            this.zza = zzqwVar;
            return this;
        }

        public final zzqp zza() {
            zzaae zza;
            zzqw zzqwVar = this.zza;
            if (zzqwVar != null && this.zzb != null) {
                if (zzqwVar.zzc() == this.zzb.zza()) {
                    if (this.zza.zza() && this.zzc == null) {
                        throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                    }
                    if (!this.zza.zza() && this.zzc != null) {
                        throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                    }
                    if (this.zza.zze() == zzqw.zzb.zzd) {
                        zza = zzpd.zza;
                    } else if (this.zza.zze() != zzqw.zzb.zzc && this.zza.zze() != zzqw.zzb.zzb) {
                        if (this.zza.zze() == zzqw.zzb.zza) {
                            zza = zzpd.zzb(this.zzc.intValue());
                        } else {
                            throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
                        }
                    } else {
                        zza = zzpd.zza(this.zzc.intValue());
                    }
                    return new zzqp(this.zza, this.zzb, zza, this.zzc);
                }
                throw new GeneralSecurityException("Key size mismatch");
            }
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
    }

    public static zza zzc() {
        return new zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzrn, com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final /* synthetic */ zzce zza() {
        return (zzqw) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzrn
    /* renamed from: zzd */
    public final /* synthetic */ zzrm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzrn
    public final zzaae zze() {
        return this.zzc;
    }

    public final zzaaf zzf() {
        return this.zzb;
    }

    private zzqp(zzqw zzqwVar, zzaaf zzaafVar, zzaae zzaaeVar, Integer num) {
        this.zza = zzqwVar;
        this.zzb = zzaafVar;
        this.zzc = zzaaeVar;
        this.zzd = num;
    }
}
