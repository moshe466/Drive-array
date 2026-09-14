package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzie implements zzbe {
    private final byte[] zza;
    private final int zzb;
    private final zzso zzc;

    private zzie(byte[] bArr, zzaae zzaaeVar, int i) {
        this.zzc = new zzzt(bArr);
        this.zza = zzaaeVar.zzb();
        this.zzb = i;
    }

    public static zzbe zza(zzfv zzfvVar) {
        if (((zzfz) ((zzcx) zzfvVar.zza())).zzb() >= 8 && ((zzfz) ((zzcx) zzfvVar.zza())).zzb() <= 12) {
            return new zzie(zzfvVar.zze().zza(zzbj.zza()), zzfvVar.zzd(), ((zzfz) ((zzcx) zzfvVar.zza())).zzb());
        }
        throw new GeneralSecurityException("invalid salt size");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            byte[] zza = zzqg.zza(this.zzb + 12);
            byte[] copyOf = Arrays.copyOf(zza, this.zzb);
            int i = this.zzb;
            byte[] copyOfRange = Arrays.copyOfRange(zza, i, i + 12);
            byte[] zzb = new zzhr(zza(copyOf)).zzb(copyOfRange, bArr, this.zza.length + this.zzb + copyOfRange.length, bArr2);
            byte[] bArr3 = this.zza;
            System.arraycopy(bArr3, 0, zzb, 0, bArr3.length);
            System.arraycopy(zza, 0, zzb, this.zza.length, zza.length);
            return zzb;
        }
        throw new NullPointerException("plaintext is null");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr3 = this.zza;
            if (length >= bArr3.length + this.zzb + 28) {
                if (zzqq.zza(bArr3, bArr)) {
                    int length2 = this.zza.length + this.zzb;
                    int i = length2 + 12;
                    return new zzhr(zza(Arrays.copyOfRange(bArr, this.zza.length, length2))).zza(Arrays.copyOfRange(bArr, length2, i), bArr, i, bArr2);
                }
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
            throw new GeneralSecurityException("ciphertext too short");
        }
        throw new NullPointerException("ciphertext is null");
    }

    private final byte[] zza(byte[] bArr) {
        byte[] bArr2 = {0, 1, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bArr3 = {0, 2, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (bArr.length <= 12 && bArr.length >= 8) {
            System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
            System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
            byte[] bArr4 = new byte[32];
            System.arraycopy(this.zzc.zza(bArr2, 16), 0, bArr4, 0, 16);
            System.arraycopy(this.zzc.zza(bArr3, 16), 0, bArr4, 16, 16);
            return bArr4;
        }
        throw new GeneralSecurityException("invalid salt size");
    }
}
