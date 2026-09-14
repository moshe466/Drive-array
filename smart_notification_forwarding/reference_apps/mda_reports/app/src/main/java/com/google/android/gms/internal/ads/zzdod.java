package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class zzdod implements zzdio {
    private final SecretKey zzhev;
    private final int zzhew;
    private byte[] zzhex;
    private byte[] zzhey;

    public zzdod(byte[] bArr, int i) {
        zzdpo.zzez(bArr.length);
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, min is 10 bytes");
        }
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("tag size too large, max is 16 bytes");
        }
        this.zzhev = new SecretKeySpec(bArr, "AES");
        this.zzhew = i;
        Cipher zzaxa = zzaxa();
        zzaxa.init(1, this.zzhev);
        this.zzhex = zzdoj.a(zzaxa.doFinal(new byte[16]));
        this.zzhey = zzdoj.a(this.zzhex);
    }

    private static Cipher zzaxa() {
        return zzdoy.zzhgg.zzhd("AES/ECB/NoPadding");
    }

    @Override // com.google.android.gms.internal.ads.zzdio
    public final byte[] zzl(byte[] bArr) {
        byte[] zzd;
        Cipher zzaxa = zzaxa();
        zzaxa.init(1, this.zzhev);
        double length = bArr.length;
        Double.isNaN(length);
        int max = Math.max(1, (int) Math.ceil(length / 16.0d));
        if ((max << 4) == bArr.length) {
            zzd = zzdoi.zza(bArr, (max - 1) << 4, this.zzhex, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
            if (copyOfRange.length >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
            copyOf[copyOfRange.length] = Byte.MIN_VALUE;
            zzd = zzdoi.zzd(copyOf, this.zzhey);
        }
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr2 = zzaxa.doFinal(zzdoi.zza(bArr2, 0, bArr, i << 4, 16));
        }
        byte[] zzd2 = zzdoi.zzd(zzd, bArr2);
        byte[] bArr3 = new byte[this.zzhew];
        System.arraycopy(zzaxa.doFinal(zzd2), 0, bArr3, 0, this.zzhew);
        return bArr3;
    }
}
