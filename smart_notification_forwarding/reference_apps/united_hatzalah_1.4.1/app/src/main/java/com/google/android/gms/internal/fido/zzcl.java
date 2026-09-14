package com.google.android.gms.internal.fido;

/* loaded from: classes.dex */
public final class zzcl {
    public static byte[] zza(byte[]... bArr) {
        int i = 0;
        int i3 = 0;
        while (true) {
            if (i >= bArr.length) {
                break;
            }
            i3 += bArr[i].length;
            i++;
        }
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        for (byte[] bArr3 : bArr) {
            int length = bArr3.length;
            System.arraycopy(bArr3, 0, bArr2, i4, length);
            i4 += length;
        }
        return bArr2;
    }
}
