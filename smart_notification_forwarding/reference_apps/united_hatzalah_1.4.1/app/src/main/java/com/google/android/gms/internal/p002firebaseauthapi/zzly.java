package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
final class zzly implements zzmf {
    private final String zza;

    public zzly(String str) {
        this.zza = str;
    }

    public final int zza() {
        return Mac.getInstance(this.zza).getMacLength();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zzb() {
        String str = this.zza;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case 984523022:
                if (str.equals("HmacSha256")) {
                    c4 = 0;
                    break;
                }
                break;
            case 984524074:
                if (str.equals("HmacSha384")) {
                    c4 = 1;
                    break;
                }
                break;
            case 984525777:
                if (str.equals("HmacSha512")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return zzmn.zzf;
            case 1:
                return zzmn.zzg;
            case 2:
                return zzmn.zzh;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2, int i) {
        Mac zza = zzzd.zzb.zza(this.zza);
        if (i <= zza.getMacLength() * 255) {
            byte[] bArr3 = new byte[i];
            zza.init(new SecretKeySpec(bArr, this.zza));
            byte[] bArr4 = new byte[0];
            int i3 = 1;
            int i4 = 0;
            while (true) {
                zza.update(bArr4);
                zza.update(bArr2);
                zza.update((byte) i3);
                bArr4 = zza.doFinal();
                if (bArr4.length + i4 < i) {
                    System.arraycopy(bArr4, 0, bArr3, i4, bArr4.length);
                    i4 += bArr4.length;
                    i3++;
                } else {
                    System.arraycopy(bArr4, 0, bArr3, i4, i - i4);
                    return bArr3;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2) {
        Mac zza = zzzd.zzb.zza(this.zza);
        if (bArr2 != null && bArr2.length != 0) {
            zza.init(new SecretKeySpec(bArr2, this.zza));
        } else {
            zza.init(new SecretKeySpec(new byte[zza.getMacLength()], this.zza));
        }
        return zza.doFinal(bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i) {
        return zza(zza(zzmn.zza(str, bArr2, bArr4), null), zzmn.zza(str2, bArr3, bArr4, i), i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i) {
        return zza(bArr, zzmn.zza(str, bArr2, bArr3, i), i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return zza(zzmn.zza(str, bArr2, bArr3), bArr);
    }
}
