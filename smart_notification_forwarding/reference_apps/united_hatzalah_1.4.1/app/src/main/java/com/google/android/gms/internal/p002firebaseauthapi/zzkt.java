package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzki;
import e0.a;
import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;

/* loaded from: classes.dex */
public final class zzkt extends zzll {
    private final zzki zza;
    private final zzaae zzb;
    private final zzaae zzc;
    private final Integer zzd;

    private zzkt(zzki zzkiVar, zzaae zzaaeVar, zzaae zzaaeVar2, Integer num) {
        this.zza = zzkiVar;
        this.zzb = zzaaeVar;
        this.zzc = zzaaeVar2;
        this.zzd = num;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzll, com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final /* synthetic */ zzce zza() {
        return (zzki) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzll
    /* renamed from: zzc */
    public final /* synthetic */ zzlj zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzll
    public final zzaae zzd() {
        return this.zzc;
    }

    public final zzaae zze() {
        return this.zzb;
    }

    public static zzkt zza(zzki zzkiVar, zzaae zzaaeVar, Integer num) {
        EllipticCurve curve;
        zzaae zzb;
        zzki.zzf zzf = zzkiVar.zzf();
        zzki.zzf zzfVar = zzki.zzf.zzc;
        if (!zzf.equals(zzfVar) && num == null) {
            throw new GeneralSecurityException(a.e("'idRequirement' must be non-null for ", String.valueOf(zzf), " variant."));
        }
        if (zzf.equals(zzfVar) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
        zzki.zzd zze = zzkiVar.zze();
        int zza = zzaaeVar.zza();
        String str = "Encoded public key byte length for " + String.valueOf(zze) + " must be %d, not " + zza;
        zzki.zzd zzdVar = zzki.zzd.zza;
        if (zze == zzdVar) {
            if (zza != 65) {
                throw new GeneralSecurityException(String.format(str, 65));
            }
        } else if (zze == zzki.zzd.zzb) {
            if (zza != 97) {
                throw new GeneralSecurityException(String.format(str, 97));
            }
        } else if (zze == zzki.zzd.zzc) {
            if (zza != 133) {
                throw new GeneralSecurityException(String.format(str, 133));
            }
        } else {
            if (zze != zzki.zzd.zzd) {
                throw new GeneralSecurityException("Unable to validate public key length for ".concat(String.valueOf(zze)));
            }
            if (zza != 32) {
                throw new GeneralSecurityException(String.format(str, 32));
            }
        }
        if (zze == zzdVar || zze == zzki.zzd.zzb || zze == zzki.zzd.zzc) {
            if (zze == zzdVar) {
                curve = zzni.zza.getCurve();
            } else if (zze == zzki.zzd.zzb) {
                curve = zzni.zzb.getCurve();
            } else if (zze == zzki.zzd.zzc) {
                curve = zzni.zzc.getCurve();
            } else {
                throw new IllegalArgumentException("Unable to determine NIST curve type for ".concat(String.valueOf(zze)));
            }
            zzni.zza(zzyz.zza(curve, zzzb.UNCOMPRESSED, zzaaeVar.zzb()), curve);
        }
        zzki.zzf zzf2 = zzkiVar.zzf();
        if (zzf2 == zzfVar) {
            zzb = zzpd.zza;
        } else if (num != null) {
            if (zzf2 == zzki.zzf.zzb) {
                zzb = zzpd.zza(num.intValue());
            } else if (zzf2 == zzki.zzf.zza) {
                zzb = zzpd.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown HpkeParameters.Variant: ".concat(String.valueOf(zzf2)));
            }
        } else {
            throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant ".concat(String.valueOf(zzf2)));
        }
        return new zzkt(zzkiVar, zzaaeVar, zzb, num);
    }
}
