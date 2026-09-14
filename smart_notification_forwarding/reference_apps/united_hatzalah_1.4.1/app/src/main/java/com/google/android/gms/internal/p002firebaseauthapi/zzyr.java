package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class zzyr implements zzbi {
    private static final zzix.zza zza = zzix.zza.zza;
    private static final Collection<Integer> zzb = Arrays.asList(64);
    private static final byte[] zzc = new byte[16];
    private static final ThreadLocal<Cipher> zzd = new zzyu();
    private final zzzt zze;
    private final byte[] zzf;
    private final byte[] zzg;

    private zzyr(byte[] bArr, zzaae zzaaeVar) {
        if (zza.zza()) {
            if (zzb.contains(Integer.valueOf(bArr.length))) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
                this.zzf = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
                this.zze = new zzzt(copyOfRange);
                this.zzg = zzaaeVar.zzb();
                return;
            }
            throw new InvalidKeyException(AbstractC0008a.j(bArr.length, "invalid key size: ", " bytes; key must have 64 bytes"));
        }
        throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
    }

    public static zzbi zza(zzja zzjaVar) {
        return new zzyr(zzjaVar.zzf().zza(zzbj.zza()), zzjaVar.zze());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] zza2;
        int length = bArr.length;
        byte[] bArr3 = this.zzg;
        if (length >= bArr3.length + 16) {
            if (zzqq.zza(bArr3, bArr)) {
                Cipher cipher = zzd.get();
                byte[] bArr4 = this.zzg;
                byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr4.length, bArr4.length + 16);
                byte[] bArr5 = (byte[]) copyOfRange.clone();
                bArr5[8] = (byte) (bArr5[8] & Byte.MAX_VALUE);
                bArr5[12] = (byte) (bArr5[12] & Byte.MAX_VALUE);
                cipher.init(2, new SecretKeySpec(this.zzf, "AES"), new IvParameterSpec(bArr5));
                int length2 = this.zzg.length + 16;
                int length3 = bArr.length - length2;
                byte[] doFinal = cipher.doFinal(bArr, length2, length3);
                if (length3 == 0 && doFinal == null && zzaaa.zza()) {
                    doFinal = new byte[0];
                }
                byte[][] bArr6 = {bArr2, doFinal};
                byte[] zza3 = this.zze.zza(zzc, 16);
                for (int i = 0; i <= 0; i++) {
                    byte[] bArr7 = bArr6[i];
                    if (bArr7 == null) {
                        bArr7 = new byte[0];
                    }
                    zza3 = zzyt.zza(zzse.zzb(zza3), this.zze.zza(bArr7, 16));
                }
                byte[] bArr8 = bArr6[1];
                if (bArr8.length >= 16) {
                    if (bArr8.length >= zza3.length) {
                        int length4 = bArr8.length - zza3.length;
                        zza2 = Arrays.copyOf(bArr8, bArr8.length);
                        for (int i3 = 0; i3 < zza3.length; i3++) {
                            int i4 = length4 + i3;
                            zza2[i4] = (byte) (zza2[i4] ^ zza3[i3]);
                        }
                    } else {
                        throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                    }
                } else {
                    zza2 = zzyt.zza(zzse.zza(bArr8), zzse.zzb(zza3));
                }
                if (MessageDigest.isEqual(copyOfRange, this.zze.zza(zza2, 16))) {
                    return doFinal;
                }
                throw new AEADBadTagException("Integrity check failed.");
            }
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
