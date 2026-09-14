package com.google.android.gms.internal.ads;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzqz extends zzqo {
    private MessageDigest zzbqm;
    private final int zzbqt;
    private final int zzbqu;

    public zzqz(int i) {
        int i2 = i / 8;
        this.zzbqt = i % 8 > 0 ? i2 + 1 : i2;
        this.zzbqu = i;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final byte[] zzbv(String str) {
        synchronized (this.a) {
            this.zzbqm = a();
            if (this.zzbqm == null) {
                return new byte[0];
            }
            this.zzbqm.reset();
            this.zzbqm.update(str.getBytes(Charset.forName(HttpRequest.CHARSET_UTF8)));
            byte[] digest = this.zzbqm.digest();
            byte[] bArr = new byte[digest.length > this.zzbqt ? this.zzbqt : digest.length];
            System.arraycopy(digest, 0, bArr, 0, bArr.length);
            if (this.zzbqu % 8 > 0) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    if (i > 0) {
                        j <<= 8;
                    }
                    j += bArr[i] & 255;
                }
                long j2 = j >>> (8 - (this.zzbqu % 8));
                for (int i2 = this.zzbqt - 1; i2 >= 0; i2--) {
                    bArr[i2] = (byte) (255 & j2);
                    j2 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
