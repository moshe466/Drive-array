package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class zzqv extends zzqo {
    private MessageDigest zzbqm;

    @Override // com.google.android.gms.internal.ads.zzqo
    public final byte[] zzbv(String str) {
        byte[] bArr;
        String[] split = str.split(" ");
        int i = 4;
        if (split.length == 1) {
            int zzbx = zzqs.zzbx(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zzbx);
            bArr = allocate.array();
        } else if (split.length < 5) {
            bArr = new byte[split.length << 1];
            for (int i2 = 0; i2 < split.length; i2++) {
                int zzbx2 = zzqs.zzbx(split[i2]);
                int i3 = (zzbx2 >> 16) ^ (65535 & zzbx2);
                byte[] bArr2 = {(byte) i3, (byte) (i3 >> 8)};
                int i4 = i2 << 1;
                bArr[i4] = bArr2[0];
                bArr[i4 + 1] = bArr2[1];
            }
        } else {
            bArr = new byte[split.length];
            for (int i5 = 0; i5 < split.length; i5++) {
                int zzbx3 = zzqs.zzbx(split[i5]);
                bArr[i5] = (byte) ((zzbx3 >> 24) ^ (((zzbx3 & 255) ^ ((zzbx3 >> 8) & 255)) ^ ((zzbx3 >> 16) & 255)));
            }
        }
        this.zzbqm = a();
        synchronized (this.a) {
            if (this.zzbqm == null) {
                return new byte[0];
            }
            this.zzbqm.reset();
            this.zzbqm.update(bArr);
            byte[] digest = this.zzbqm.digest();
            if (digest.length <= 4) {
                i = digest.length;
            }
            byte[] bArr3 = new byte[i];
            System.arraycopy(digest, 0, bArr3, 0, bArr3.length);
            return bArr3;
        }
    }
}
