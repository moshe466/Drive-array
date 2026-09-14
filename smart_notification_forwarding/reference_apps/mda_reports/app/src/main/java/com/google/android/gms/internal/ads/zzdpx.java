package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdpx {
    private final byte[] zzhhh = new byte[256];
    private int zzhhi;
    private int zzhhj;

    public zzdpx(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzhhh[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            byte[] bArr2 = this.zzhhh;
            i2 = (i2 + bArr2[i3] + bArr[i3 % bArr.length]) & 255;
            byte b = bArr2[i3];
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b;
        }
        this.zzhhi = 0;
        this.zzhhj = 0;
    }

    public final void zzt(byte[] bArr) {
        int i = this.zzhhi;
        int i2 = this.zzhhj;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte[] bArr2 = this.zzhhh;
            i2 = (i2 + bArr2[i]) & 255;
            byte b = bArr2[i];
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + bArr2[i2]) & 255] ^ bArr[i3]);
        }
        this.zzhhi = i;
        this.zzhhj = i2;
    }
}
