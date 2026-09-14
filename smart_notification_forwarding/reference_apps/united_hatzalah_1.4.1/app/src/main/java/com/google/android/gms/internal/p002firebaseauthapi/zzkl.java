package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzki;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzkl extends zzli {
    private final zzkt zza;
    private final zzaaf zzb;

    private zzkl(zzkt zzktVar, zzaaf zzaafVar) {
        this.zza = zzktVar;
        this.zzb = zzaafVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli, com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final /* synthetic */ zzce zza() {
        return (zzki) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli, com.google.android.gms.internal.p002firebaseauthapi.zzcd
    public final /* synthetic */ zzbm zzc() {
        return (zzkt) zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli
    /* renamed from: zzd */
    public final /* synthetic */ zzlj zza() {
        return (zzki) ((zzlj) this.zza.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli
    /* renamed from: zze */
    public final /* synthetic */ zzll zzc() {
        return this.zza;
    }

    public final zzaaf zzf() {
        return this.zzb;
    }

    public static zzkl zza(zzkt zzktVar, zzaaf zzaafVar) {
        ECParameterSpec eCParameterSpec;
        if (zzktVar == null) {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without an HPKE public key");
        }
        if (zzaafVar != null) {
            zzki.zzd zze = ((zzki) ((zzlj) zzktVar.zza())).zze();
            int zza = zzaafVar.zza();
            String str = "Encoded private key byte length for " + String.valueOf(zze) + " must be %d, not " + zza;
            zzki.zzd zzdVar = zzki.zzd.zza;
            if (zze == zzdVar) {
                if (zza != 32) {
                    throw new GeneralSecurityException(String.format(str, 32));
                }
            } else if (zze == zzki.zzd.zzb) {
                if (zza != 48) {
                    throw new GeneralSecurityException(String.format(str, 48));
                }
            } else if (zze == zzki.zzd.zzc) {
                if (zza != 66) {
                    throw new GeneralSecurityException(String.format(str, 66));
                }
            } else {
                if (zze != zzki.zzd.zzd) {
                    throw new GeneralSecurityException("Unable to validate private key length for ".concat(String.valueOf(zze)));
                }
                if (zza != 32) {
                    throw new GeneralSecurityException(String.format(str, 32));
                }
            }
            zzki.zzd zze2 = ((zzki) ((zzlj) zzktVar.zza())).zze();
            byte[] zzb = zzktVar.zze().zzb();
            byte[] zza2 = zzaafVar.zza(zzbj.zza());
            if (zze2 != zzdVar && zze2 != zzki.zzd.zzb && zze2 != zzki.zzd.zzc) {
                if (zze2 == zzki.zzd.zzd) {
                    if (!Arrays.equals(zzaac.zza(zza2), zzb)) {
                        throw new GeneralSecurityException("Invalid private key for public key.");
                    }
                } else {
                    throw new IllegalArgumentException("Unable to validate key pair for ".concat(String.valueOf(zze2)));
                }
            } else {
                if (zze2 == zzdVar) {
                    eCParameterSpec = zzni.zza;
                } else if (zze2 == zzki.zzd.zzb) {
                    eCParameterSpec = zzni.zzb;
                } else if (zze2 == zzki.zzd.zzc) {
                    eCParameterSpec = zzni.zzc;
                } else {
                    throw new IllegalArgumentException("Unable to determine NIST curve params for ".concat(String.valueOf(zze2)));
                }
                BigInteger order = eCParameterSpec.getOrder();
                BigInteger zza3 = zznh.zza(zza2);
                if (zza3.signum() > 0 && zza3.compareTo(order) < 0) {
                    if (!zzni.zza(zza3, eCParameterSpec).equals(zzyz.zza(eCParameterSpec.getCurve(), zzzb.UNCOMPRESSED, zzb))) {
                        throw new GeneralSecurityException("Invalid private key for public key.");
                    }
                } else {
                    throw new GeneralSecurityException("Invalid private key.");
                }
            }
            return new zzkl(zzktVar, zzaafVar);
        }
        throw new GeneralSecurityException("HPKE private key cannot be constructed without secret");
    }
}
