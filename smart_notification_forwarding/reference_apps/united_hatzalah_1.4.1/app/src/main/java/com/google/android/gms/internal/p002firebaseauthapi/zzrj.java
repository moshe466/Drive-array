package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzrj extends zzrm {
    private final int zza;
    private final int zzb;
    private final zzb zzc;
    private final zzc zzd;

    /* loaded from: classes.dex */
    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private zzc zzc;
        private zzb zzd;

        public final zza zza(zzc zzcVar) {
            this.zzc = zzcVar;
            return this;
        }

        public final zza zzb(int i) {
            this.zzb = Integer.valueOf(i);
            return this;
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = zzb.zzd;
        }

        public final zza zza(int i) {
            this.zza = Integer.valueOf(i);
            return this;
        }

        public final zza zza(zzb zzbVar) {
            this.zzd = zzbVar;
            return this;
        }

        public final zzrj zza() {
            Integer num = this.zza;
            if (num != null) {
                if (this.zzb != null) {
                    if (this.zzc != null) {
                        if (this.zzd != null) {
                            if (num.intValue() >= 16) {
                                Integer num2 = this.zzb;
                                int intValue = num2.intValue();
                                zzc zzcVar = this.zzc;
                                if (intValue >= 10) {
                                    if (zzcVar == zzc.zza) {
                                        if (intValue > 20) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
                                        }
                                    } else if (zzcVar == zzc.zzb) {
                                        if (intValue > 28) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
                                        }
                                    } else if (zzcVar == zzc.zzc) {
                                        if (intValue > 32) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
                                        }
                                    } else if (zzcVar == zzc.zzd) {
                                        if (intValue > 48) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
                                        }
                                    } else {
                                        if (zzcVar != zzc.zze) {
                                            throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                                        }
                                        if (intValue > 64) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
                                        }
                                    }
                                    return new zzrj(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc);
                                }
                                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
                            }
                            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.zza));
                        }
                        throw new GeneralSecurityException("variant is not set");
                    }
                    throw new GeneralSecurityException("hash type is not set");
                }
                throw new GeneralSecurityException("tag size is not set");
            }
            throw new GeneralSecurityException("key size is not set");
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("LEGACY");
        public static final zzb zzd = new zzb("NO_PREFIX");
        private final String zze;

        private zzb(String str) {
            this.zze = str;
        }

        public final String toString() {
            return this.zze;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzc {
        public static final zzc zza = new zzc("SHA1");
        public static final zzc zzb = new zzc("SHA224");
        public static final zzc zzc = new zzc("SHA256");
        public static final zzc zzd = new zzc("SHA384");
        public static final zzc zze = new zzc("SHA512");
        private final String zzf;

        private zzc(String str) {
            this.zzf = str;
        }

        public final String toString() {
            return this.zzf;
        }
    }

    public static zza zzd() {
        return new zza();
    }

    private final int zzg() {
        int i;
        zzb zzbVar = this.zzc;
        if (zzbVar == zzb.zzd) {
            return this.zzb;
        }
        if (zzbVar == zzb.zza) {
            i = this.zzb;
        } else if (zzbVar == zzb.zzb) {
            i = this.zzb;
        } else if (zzbVar == zzb.zzc) {
            i = this.zzb;
        } else {
            throw new IllegalStateException("Unknown variant");
        }
        return i + 5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzrj)) {
            return false;
        }
        zzrj zzrjVar = (zzrj) obj;
        if (zzrjVar.zza != this.zza || zzrjVar.zzg() != zzg() || zzrjVar.zzc != this.zzc || zzrjVar.zzd != this.zzd) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(zzrj.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        int i = this.zzb;
        int i3 = this.zza;
        StringBuilder y = AbstractC0008a.y("HMAC Parameters (variant: ", valueOf, ", hashType: ", valueOf2, ", ");
        y.append(i);
        y.append("-byte tags, and ");
        y.append(i3);
        y.append("-byte key)");
        return y.toString();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzce
    public final boolean zza() {
        if (this.zzc != zzb.zzd) {
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzc zze() {
        return this.zzd;
    }

    public final zzb zzf() {
        return this.zzc;
    }

    private zzrj(int i, int i3, zzb zzbVar, zzc zzcVar) {
        this.zza = i;
        this.zzb = i3;
        this.zzc = zzbVar;
        this.zzd = zzcVar;
    }
}
