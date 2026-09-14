package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjh;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzja extends zzjj {
    private final zzjh zza;
    private final zzaaf zzb;
    private final zzaae zzc;
    private final Integer zzd;

    /* loaded from: classes.dex */
    public static class zza {
        private zzjh zza;
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

        public final zza zza(zzjh zzjhVar) {
            this.zza = zzjhVar;
            return this;
        }

        public final zzja zza() {
            zzaae zzb;
            zzjh zzjhVar = this.zza;
            if (zzjhVar != null && this.zzb != null) {
                if (zzjhVar.zzb() == this.zzb.zza()) {
                    if (this.zza.zza() && this.zzc == null) {
                        throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                    }
                    if (!this.zza.zza() && this.zzc != null) {
                        throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
                    }
                    if (this.zza.zzd() == zzjh.zzb.zzc) {
                        zzb = zzpd.zza;
                    } else if (this.zza.zzd() == zzjh.zzb.zzb) {
                        zzb = zzpd.zza(this.zzc.intValue());
                    } else if (this.zza.zzd() == zzjh.zzb.zza) {
                        zzb = zzpd.zzb(this.zzc.intValue());
                    } else {
                        throw new IllegalStateException("Unknown AesSivParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
                    }
                    return new zzja(this.zza, this.zzb, zzb, this.zzc);
                }
                throw new GeneralSecurityException("Key size mismatch");
            }
            throw new IllegalArgumentException("Cannot build without parameters and/or key material");
        }
    }

    public static zza zzc() {
        return new zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjj, com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final /* synthetic */ zzce zza() {
        return (zzjh) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjj
    /* renamed from: zzd */
    public final /* synthetic */ zzjm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjj
    public final zzaae zze() {
        return this.zzc;
    }

    public final zzaaf zzf() {
        return this.zzb;
    }

    private zzja(zzjh zzjhVar, zzaaf zzaafVar, zzaae zzaaeVar, Integer num) {
        this.zza = zzjhVar;
        this.zzb = zzaafVar;
        this.zzc = zzaaeVar;
        this.zzd = num;
    }
}
