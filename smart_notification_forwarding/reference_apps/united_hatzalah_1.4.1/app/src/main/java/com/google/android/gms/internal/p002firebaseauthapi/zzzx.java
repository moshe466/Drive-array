package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqw;
import com.google.android.gms.internal.p002firebaseauthapi.zzrj;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class zzzx implements zzcb {
    private static final byte[] zza = {0};
    private final zzso zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzzx(zzqp zzqpVar) {
        this.zzb = new zzzt(zzqpVar.zzf().zza(zzbj.zza()));
        this.zzc = ((zzqw) ((zzrm) zzqpVar.zza())).zzb();
        this.zzd = zzqpVar.zze().zzb();
        if (((zzqw) ((zzrm) zzqpVar.zza())).zze().equals(zzqw.zzb.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzcb zza(zzqp zzqpVar) {
        return new zzzx(zzqpVar);
    }

    public static zzcb zza(zzrc zzrcVar) {
        return new zzzx(zzrcVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcb
    public final void zza(byte[] bArr, byte[] bArr2) {
        if (!MessageDigest.isEqual(zza(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcb
    public final byte[] zza(byte[] bArr) {
        byte[] bArr2 = this.zze;
        if (bArr2.length > 0) {
            return zzyt.zza(this.zzd, this.zzb.zza(zzyt.zza(bArr, bArr2), this.zzc));
        }
        return zzyt.zza(this.zzd, this.zzb.zza(bArr, this.zzc));
    }

    private zzzx(zzrc zzrcVar) {
        this.zzb = new zzzv("HMAC".concat(String.valueOf(((zzrj) ((zzrm) zzrcVar.zza())).zze())), new SecretKeySpec(zzrcVar.zzf().zza(zzbj.zza()), "HMAC"));
        this.zzc = ((zzrj) ((zzrm) zzrcVar.zza())).zzb();
        this.zzd = zzrcVar.zze().zzb();
        if (((zzrj) ((zzrm) zzrcVar.zza())).zzf().equals(zzrj.zzb.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzzx(zzso zzsoVar, int i) {
        this.zzb = zzsoVar;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        if (i >= 10) {
            zzsoVar.zza(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }
}
