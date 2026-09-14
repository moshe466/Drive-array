package n5;

/* loaded from: classes.dex */
public final class b {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        for (int i10 = 0; i10 < 32; i10++) {
            bArr3[i10] = (byte) (bArr[i10] & bArr2[i10]);
        }
        return bArr3;
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[32];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = (byte) (~bArr[i10]);
        }
        return bArr2;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        for (int i10 = 0; i10 < 32; i10++) {
            bArr3[i10] = (byte) (bArr[i10] | bArr2[i10]);
        }
        return bArr3;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        for (int i10 = 0; i10 < 32; i10++) {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        return bArr3;
    }
}
