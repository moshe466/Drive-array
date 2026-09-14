package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzoe extends zzbm {
    private final zzqe zza;
    private final zzaae zzb;

    /* loaded from: classes.dex */
    public static class zza extends zzce {
        private final String zza;
        private final zzxu zzb;

        public final String toString() {
            String str;
            String str2 = this.zza;
            int i = zzog.zza[this.zzb.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            str = "UNKNOWN";
                        } else {
                            str = "CRUNCHY";
                        }
                    } else {
                        str = "RAW";
                    }
                } else {
                    str = "LEGACY";
                }
            } else {
                str = "TINK";
            }
            return AbstractC0008a.p("(typeUrl=", str2, ", outputPrefixType=", str, ")");
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzce
        public final boolean zza() {
            if (this.zzb != zzxu.RAW) {
                return true;
            }
            return false;
        }

        private zza(String str, zzxu zzxuVar) {
            this.zza = str;
            this.zzb = zzxuVar;
        }
    }

    public zzoe(zzqe zzqeVar, zzck zzckVar) {
        zzaae zza2;
        zza(zzqeVar, zzckVar);
        this.zza = zzqeVar;
        if (zzqeVar.zzc().equals(zzxu.RAW)) {
            zza2 = zzaae.zza(new byte[0]);
        } else if (zzqeVar.zzc().equals(zzxu.TINK)) {
            zza2 = zzpd.zzb(zzqeVar.zze().intValue());
        } else {
            if (!zzqeVar.zzc().equals(zzxu.LEGACY) && !zzqeVar.zzc().equals(zzxu.CRUNCHY)) {
                throw new GeneralSecurityException("Unknown output prefix type");
            }
            zza2 = zzpd.zza(zzqeVar.zze().intValue());
        }
        this.zzb = zza2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final zzce zza() {
        return new zza(this.zza.zzf(), this.zza.zzc());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final Integer zzb() {
        return this.zza.zze();
    }

    public final zzaae zzc() {
        return this.zzb;
    }

    public final zzqe zza(zzck zzckVar) {
        zza(this.zza, zzckVar);
        return this.zza;
    }

    private static void zza(zzqe zzqeVar, zzck zzckVar) {
        int i = zzog.zzb[zzqeVar.zza().ordinal()];
        if (i == 1 || i == 2) {
            zzck.zza(zzckVar);
        }
    }
}
