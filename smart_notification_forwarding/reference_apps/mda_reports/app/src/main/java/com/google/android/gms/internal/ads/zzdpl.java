package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class zzdpl implements zzdio {
    private final Mac zzhgt;
    private final int zzhgu;
    private final String zzhgv;
    private final Key zzhgw;

    public zzdpl(String str, Key key, int i) {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1823053428) {
            if (hashCode != 392315118) {
                if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                    c = 2;
                }
            } else if (str.equals("HMACSHA256")) {
                c = 1;
            }
        } else if (str.equals("HMACSHA1")) {
            c = 0;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    String valueOf = String.valueOf(str);
                    throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
                }
                if (i > 64) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
            } else if (i > 32) {
                throw new InvalidAlgorithmParameterException("tag size too big");
            }
        } else if (i > 20) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.zzhgv = str;
        this.zzhgu = i;
        this.zzhgw = key;
        this.zzhgt = zzdoy.zzhgh.zzhd(str);
        this.zzhgt.init(key);
    }

    @Override // com.google.android.gms.internal.ads.zzdio
    public final byte[] zzl(byte[] bArr) {
        Mac zzhd;
        try {
            zzhd = (Mac) this.zzhgt.clone();
        } catch (CloneNotSupportedException unused) {
            zzhd = zzdoy.zzhgh.zzhd(this.zzhgv);
            zzhd.init(this.zzhgw);
        }
        zzhd.update(bArr);
        byte[] bArr2 = new byte[this.zzhgu];
        System.arraycopy(zzhd.doFinal(), 0, bArr2, 0, this.zzhgu);
        return bArr2;
    }
}
