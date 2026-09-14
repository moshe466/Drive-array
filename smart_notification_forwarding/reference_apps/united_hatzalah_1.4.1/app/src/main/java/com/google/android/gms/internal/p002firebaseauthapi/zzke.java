package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdk;
import com.google.android.gms.internal.p002firebaseauthapi.zzdz;
import com.google.android.gms.internal.p002firebaseauthapi.zzjh;
import e0.a;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzke extends zzlj {
    private static final Set<zzce> zza = (Set) zzqo.zza(new zzqn() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkd
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqn
        public final Object zza() {
            return zzke.zzj();
        }
    });
    private final zza zzb;
    private final zzd zzc;
    private final zzc zzd;
    private final zze zze;
    private final zzce zzf;
    private final zzaae zzg;

    /* loaded from: classes.dex */
    public static final class zza {
        public static final zza zza = new zza("NIST_P256");
        public static final zza zzb = new zza("NIST_P384");
        public static final zza zzc = new zza("NIST_P521");
        public static final zza zzd = new zza("X25519");
        private final String zze;

        private zza(String str) {
            this.zze = str;
        }

        public final String toString() {
            return this.zze;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb {
        private zza zza;
        private zzd zzb;
        private zzc zzc;
        private zzce zzd;
        private zze zze;
        private zzaae zzf;

        public final zzb zza(zza zzaVar) {
            this.zza = zzaVar;
            return this;
        }

        private zzb() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = zze.zzc;
            this.zzf = null;
        }

        public final zzb zza(zzce zzceVar) {
            if (zzke.zza.contains(zzceVar)) {
                this.zzd = zzceVar;
                return this;
            }
            throw new GeneralSecurityException(a.e("Invalid DEM parameters ", String.valueOf(zzceVar), "; only AES128_GCM_RAW, AES256_GCM_RAW, AES128_CTR_HMAC_SHA256_RAW, AES256_CTR_HMAC_SHA256_RAW XCHACHA20_POLY1305_RAW and AES256_SIV_RAW are currently supported."));
        }

        public final zzb zza(zzd zzdVar) {
            this.zzb = zzdVar;
            return this;
        }

        public final zzb zza(zzc zzcVar) {
            this.zzc = zzcVar;
            return this;
        }

        public final zzb zza(zzaae zzaaeVar) {
            if (zzaaeVar.zza() == 0) {
                this.zzf = null;
                return this;
            }
            this.zzf = zzaaeVar;
            return this;
        }

        public final zzb zza(zze zzeVar) {
            this.zze = zzeVar;
            return this;
        }

        public final zzke zza() {
            zza zzaVar = this.zza;
            if (zzaVar != null) {
                if (this.zzb != null) {
                    if (this.zzd != null) {
                        if (this.zze != null) {
                            zza zzaVar2 = zza.zzd;
                            if (zzaVar != zzaVar2 && this.zzc == null) {
                                throw new GeneralSecurityException("Point format is not set");
                            }
                            if (zzaVar == zzaVar2 && this.zzc != null) {
                                throw new GeneralSecurityException("For Curve25519 point format must not be set");
                            }
                            return new zzke(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
                        }
                        throw new GeneralSecurityException("Variant is not set");
                    }
                    throw new GeneralSecurityException("DEM parameters are not set");
                }
                throw new GeneralSecurityException("Hash type is not set");
            }
            throw new GeneralSecurityException("Elliptic curve type is not set");
        }
    }

    /* loaded from: classes.dex */
    public static final class zzc {
        public static final zzc zza = new zzc("COMPRESSED");
        public static final zzc zzb = new zzc("UNCOMPRESSED");
        public static final zzc zzc = new zzc("LEGACY_UNCOMPRESSED");
        private final String zzd;

        private zzc(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzd {
        public static final zzd zza = new zzd("SHA1");
        public static final zzd zzb = new zzd("SHA224");
        public static final zzd zzc = new zzd("SHA256");
        public static final zzd zzd = new zzd("SHA384");
        public static final zzd zze = new zzd("SHA512");
        private final String zzf;

        private zzd(String str) {
            this.zzf = str;
        }

        public final String toString() {
            return this.zzf;
        }
    }

    /* loaded from: classes.dex */
    public static final class zze {
        public static final zze zza = new zze("TINK");
        public static final zze zzb = new zze("CRUNCHY");
        public static final zze zzc = new zze("NO_PREFIX");
        private final String zzd;

        private zze(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    public static zzb zzc() {
        return new zzb();
    }

    public static /* synthetic */ Set zzj() {
        HashSet hashSet = new HashSet();
        zzdz.zza zzc2 = zzdz.zze().zza(12).zzb(16).zzc(16);
        zzdz.zzb zzbVar = zzdz.zzb.zzc;
        hashSet.add(zzc2.zza(zzbVar).zza());
        hashSet.add(zzdz.zze().zza(12).zzb(32).zzc(16).zza(zzbVar).zza());
        zzdk.zza zzc3 = zzdk.zzf().zza(16).zzb(32).zzd(16).zzc(16);
        zzdk.zzc zzcVar = zzdk.zzc.zzc;
        zzdk.zza zza2 = zzc3.zza(zzcVar);
        zzdk.zzb zzbVar2 = zzdk.zzb.zzc;
        hashSet.add(zza2.zza(zzbVar2).zza());
        hashSet.add(zzdk.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzcVar).zza(zzbVar2).zza());
        hashSet.add(zzgg.zzc());
        hashSet.add(zzjh.zzc().zza(64).zza(zzjh.zzb.zzc).zza());
        return Collections.unmodifiableSet(hashSet);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzke)) {
            return false;
        }
        zzke zzkeVar = (zzke) obj;
        if (!Objects.equals(zzkeVar.zzb, this.zzb) || !Objects.equals(zzkeVar.zzc, this.zzc) || !Objects.equals(zzkeVar.zzd, this.zzd) || !Objects.equals(zzkeVar.zzf, this.zzf) || !Objects.equals(zzkeVar.zze, this.zze) || !Objects.equals(zzkeVar.zzg, this.zzg)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(zzke.class, this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg);
    }

    public final String toString() {
        return String.format("EciesParameters(curveType=%s, hashType=%s, pointFormat=%s, demParameters=%s, variant=%s, salt=%s)", this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzce
    public final boolean zza() {
        if (this.zze != zze.zzc) {
            return true;
        }
        return false;
    }

    public final zzce zzb() {
        return this.zzf;
    }

    public final zza zzd() {
        return this.zzb;
    }

    public final zzd zze() {
        return this.zzc;
    }

    public final zzc zzf() {
        return this.zzd;
    }

    public final zze zzg() {
        return this.zze;
    }

    public final zzaae zzh() {
        return this.zzg;
    }

    private zzke(zza zzaVar, zzd zzdVar, zzc zzcVar, zzce zzceVar, zze zzeVar, zzaae zzaaeVar) {
        this.zzb = zzaVar;
        this.zzc = zzdVar;
        this.zzd = zzcVar;
        this.zzf = zzceVar;
        this.zze = zzeVar;
        this.zzg = zzaaeVar;
    }
}
