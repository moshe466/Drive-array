package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class zzdof implements zzdpi {
    private final SecretKeySpec zzhfb;
    private final int zzhfd;
    private final int zzhfe;

    public zzdof(byte[] bArr, int i) {
        zzdpo.zzez(bArr.length);
        this.zzhfb = new SecretKeySpec(bArr, "AES");
        this.zzhfe = zzdoy.zzhgg.zzhd("AES/CTR/NoPadding").getBlockSize();
        if (i < 12 || i > this.zzhfe) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzhfd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdpi
    public final byte[] zzp(byte[] bArr) {
        int length = bArr.length;
        int i = this.zzhfd;
        if (length > Integer.MAX_VALUE - i) {
            int i2 = Integer.MAX_VALUE - i;
            StringBuilder sb = new StringBuilder(43);
            sb.append("plaintext length can not exceed ");
            sb.append(i2);
            throw new GeneralSecurityException(sb.toString());
        }
        byte[] bArr2 = new byte[bArr.length + i];
        byte[] zzey = zzdpn.zzey(i);
        System.arraycopy(zzey, 0, bArr2, 0, this.zzhfd);
        int length2 = bArr.length;
        int i3 = this.zzhfd;
        Cipher zzhd = zzdoy.zzhgg.zzhd("AES/CTR/NoPadding");
        byte[] bArr3 = new byte[this.zzhfe];
        System.arraycopy(zzey, 0, bArr3, 0, this.zzhfd);
        zzhd.init(1, this.zzhfb, new IvParameterSpec(bArr3));
        if (zzhd.doFinal(bArr, 0, length2, bArr2, i3) == length2) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
