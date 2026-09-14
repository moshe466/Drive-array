package bc;

import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f4295a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    public static byte[] a(String str) {
        int i10;
        char charAt;
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i11 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < length; i15++) {
            char charAt2 = str.charAt(i15);
            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                i10 = charAt2 - 'A';
            } else if (charAt2 >= 'a' && charAt2 <= 'z') {
                i10 = charAt2 - 'G';
            } else if (charAt2 >= '0' && charAt2 <= '9') {
                i10 = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i10 = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i10 = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i13 = (i13 << 6) | ((byte) i10);
            i12++;
            if (i12 % 4 == 0) {
                int i16 = i14 + 1;
                bArr[i14] = (byte) (i13 >> 16);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (i13 >> 8);
                bArr[i17] = (byte) i13;
                i14 = i17 + 1;
            }
        }
        int i18 = i12 % 4;
        if (i18 == 1) {
            return null;
        }
        if (i18 == 2) {
            bArr[i14] = (byte) ((i13 << 12) >> 16);
            i14++;
        } else if (i18 == 3) {
            int i19 = i13 << 6;
            int i20 = i14 + 1;
            bArr[i14] = (byte) (i19 >> 16);
            i14 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
        }
        if (i14 == i11) {
            return bArr;
        }
        byte[] bArr2 = new byte[i14];
        System.arraycopy(bArr, 0, bArr2, 0, i14);
        return bArr2;
    }

    public static String b(byte[] bArr) {
        return c(bArr, f4295a);
    }

    private static String c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int i12 = i10 + 1;
            bArr3[i10] = bArr2[(bArr[i11] & 255) >> 2];
            int i13 = i12 + 1;
            int i14 = i11 + 1;
            bArr3[i12] = bArr2[((bArr[i11] & 3) << 4) | ((bArr[i14] & 255) >> 4)];
            int i15 = i13 + 1;
            int i16 = (bArr[i14] & 15) << 2;
            int i17 = i11 + 2;
            bArr3[i13] = bArr2[i16 | ((bArr[i17] & 255) >> 6)];
            i10 = i15 + 1;
            bArr3[i15] = bArr2[bArr[i17] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i18 = i10 + 1;
            bArr3[i10] = bArr2[(bArr[length] & 255) >> 2];
            int i19 = i18 + 1;
            bArr3[i18] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i19] = 61;
            bArr3[i19 + 1] = 61;
        } else if (length2 == 2) {
            int i20 = i10 + 1;
            bArr3[i10] = bArr2[(bArr[length] & 255) >> 2];
            int i21 = i20 + 1;
            int i22 = (bArr[length] & 3) << 4;
            int i23 = length + 1;
            bArr3[i20] = bArr2[((bArr[i23] & 255) >> 4) | i22];
            bArr3[i21] = bArr2[(bArr[i23] & 15) << 2];
            bArr3[i21 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }
}
