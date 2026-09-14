package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzke;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzkh extends zzli {
    private final zzkg zza;
    private final zzaad zzb;
    private final zzaaf zzc;

    private zzkh(zzkg zzkgVar, zzaad zzaadVar, zzaaf zzaafVar) {
        this.zza = zzkgVar;
        this.zzb = zzaadVar;
        this.zzc = zzaafVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli, com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final /* synthetic */ zzce zza() {
        return (zzke) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli, com.google.android.gms.internal.p002firebaseauthapi.zzcd
    public final /* synthetic */ zzbm zzc() {
        return (zzkg) zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli
    /* renamed from: zzd */
    public final /* synthetic */ zzlj zza() {
        return (zzke) ((zzlj) this.zza.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli
    /* renamed from: zze */
    public final /* synthetic */ zzll zzc() {
        return this.zza;
    }

    public final zzaad zzf() {
        return this.zzb;
    }

    public final zzaaf zzg() {
        return this.zzc;
    }

    public static zzkh zza(zzkg zzkgVar, zzaaf zzaafVar) {
        if (zzkgVar != null) {
            if (zzkgVar.zze() == null) {
                throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
            }
            if (zzaafVar != null) {
                byte[] zza = zzaafVar.zza(zzbj.zza());
                byte[] zzb = zzkgVar.zze().zzb();
                if (zza.length == 32) {
                    if (Arrays.equals(zzaac.zza(zza), zzb)) {
                        return new zzkh(zzkgVar, null, zzaafVar);
                    }
                    throw new GeneralSecurityException("Invalid private key for public key.");
                }
                throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
            }
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
    }

    public static zzkh zza(zzkg zzkgVar, zzaad zzaadVar) {
        if (zzkgVar != null) {
            if (zzkgVar.zzf() == null) {
                throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
            }
            if (zzaadVar != null) {
                BigInteger zza = zzaadVar.zza(zzbj.zza());
                ECPoint zzf = zzkgVar.zzf();
                zzke.zza zzd = ((zzke) ((zzlj) zzkgVar.zza())).zzd();
                BigInteger order = zza(zzd).getOrder();
                if (zza.signum() > 0 && zza.compareTo(order) < 0) {
                    if (zzni.zza(zza, zza(zzd)).equals(zzf)) {
                        return new zzkh(zzkgVar, zzaadVar, null);
                    }
                    throw new GeneralSecurityException("Invalid private value");
                }
                throw new GeneralSecurityException("Invalid private value");
            }
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
    }

    private static ECParameterSpec zza(zzke.zza zzaVar) {
        if (zzaVar == zzke.zza.zza) {
            return zzni.zza;
        }
        if (zzaVar == zzke.zza.zzb) {
            return zzni.zzb;
        }
        if (zzaVar == zzke.zza.zzc) {
            return zzni.zzc;
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for ".concat(String.valueOf(zzaVar)));
    }
}
