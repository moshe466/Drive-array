package com.google.cloud.datastore.core.number;

/* loaded from: classes2.dex */
public class IndexNumberEncoder {
    public static final int MAX_ENCODED_BYTES = 11;

    private IndexNumberEncoder() {
    }

    public static int encodeDouble(boolean z, double d, byte[] bArr, int i) {
        long j;
        if (d == 0.0d) {
            return encodeZero(bArr, i);
        }
        long doubleToLongBits = Double.doubleToLongBits(d);
        boolean z2 = (d < 0.0d) ^ z;
        int i2 = ((int) ((doubleToLongBits >>> 52) & 2047)) - 1023;
        long j2 = doubleToLongBits & 4503599627370495L;
        if (i2 < -1022) {
            int numberOfLeadingZeros = Long.numberOfLeadingZeros(j2);
            j = (j2 & ((1 << (63 - numberOfLeadingZeros)) ^ (-1))) << (numberOfLeadingZeros + 1);
            i2 -= numberOfLeadingZeros - 12;
        } else {
            if (i2 > 1023) {
                if (j2 != 0) {
                    bArr[i] = 0;
                    bArr[i + 1] = 96;
                    return 2;
                }
                if (!z2) {
                    bArr[i] = -1;
                    return 1;
                }
                bArr[i] = 0;
                bArr[i + 1] = Byte.MIN_VALUE;
                return 2;
            }
            j = j2 << 12;
        }
        return encodeNumber(z2, i2, j, bArr, i);
    }

    public static int encodeLong(boolean z, long j, byte[] bArr, int i) {
        if (j == 0) {
            return encodeZero(bArr, i);
        }
        if (j < 0) {
            z = !z;
            j = -j;
        }
        boolean z2 = z;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j);
        int i2 = 63 - numberOfLeadingZeros;
        return encodeNumber(z2, i2, (j & ((1 << i2) ^ (-1))) << (numberOfLeadingZeros + 1), bArr, i);
    }

    private static int encodeNumber(boolean z, int i, long j, byte[] bArr, int i2) {
        int i3;
        int i4;
        long j2;
        int i5 = 0;
        int i6 = z ? 255 : 0;
        if (i < 0) {
            i = -i;
            i5 = 255;
        }
        if (i < 4) {
            int i7 = i + 1;
            int i8 = 1 << i7;
            i4 = ((i8 - 2) & ((int) (j >>> (64 - i7)))) | i8 | 192;
            j2 = j << i;
            if (i5 != 0) {
                i4 ^= ((-1) << i7) & 126;
            }
            i3 = i2;
        } else {
            if (i < 20) {
                int i9 = ((i - 4) | 224) ^ ((i5 & 127) ^ i6);
                i3 = i2 + 1;
                bArr[i2] = (byte) i9;
            } else if (i < 148) {
                int i10 = i - 20;
                int i11 = i2 + 1;
                bArr[i2] = (byte) (((i10 >>> 4) | 240) ^ ((i5 & 127) ^ i6));
                int i12 = ((i10 << 4) & 240) | ((int) (j >>> 60));
                j <<= 4;
                int i13 = i12 ^ ((i5 & 240) ^ i6);
                i3 = i11 + 1;
                bArr[i11] = (byte) i13;
            } else {
                if (i >= 1172) {
                    throw new IllegalStateException("unimplemented");
                }
                int i14 = i - 148;
                int i15 = i2 + 1;
                bArr[i2] = (byte) ((248 | (i14 >>> 8)) ^ ((i5 & 127) ^ i6));
                int i16 = (i14 & 255) ^ ((i5 & 255) ^ i6);
                i3 = i15 + 1;
                bArr[i15] = (byte) i16;
            }
            i4 = topSignificandByte(j);
            j2 = j << 7;
        }
        while (j2 != 0) {
            bArr[i3] = (byte) ((i4 | 1) ^ i6);
            i4 = topSignificandByte(j2);
            j2 <<= 7;
            i3++;
        }
        bArr[i3] = (byte) (i6 ^ i4);
        return (i3 + 1) - i2;
    }

    private static int encodeZero(byte[] bArr, int i) {
        bArr[i] = Byte.MIN_VALUE;
        return 1;
    }

    private static int topSignificandByte(long j) {
        return ((int) (j >>> 56)) & 254;
    }
}
