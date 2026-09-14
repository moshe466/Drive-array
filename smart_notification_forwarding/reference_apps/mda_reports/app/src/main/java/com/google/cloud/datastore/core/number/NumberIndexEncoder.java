package com.google.cloud.datastore.core.number;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class NumberIndexEncoder {
    private static final int EXP1_END = 4;
    private static final int EXP2_END = 20;
    private static final int EXP3_END = 148;
    private static final int EXP4_END = 1172;
    private static final int MAX_ENCODED_BYTES = 11;
    private static final byte[] ENCODED_ZERO = {Byte.MIN_VALUE};
    private static final byte[] ENCODED_NAN = {0, 96};
    private static final byte[] ENCODED_NEGATIVE_INFINITY = {0, Byte.MIN_VALUE};
    private static final byte[] ENCODED_POSITIVE_INFINITY = {-1};

    /* loaded from: classes2.dex */
    public static final class DecodedNumberParts {
        private final int bytesRead;
        private final NumberParts parts;

        private DecodedNumberParts(int i, NumberParts numberParts) {
            this.bytesRead = i;
            this.parts = numberParts;
        }

        static DecodedNumberParts a(int i, NumberParts numberParts) {
            return new DecodedNumberParts(i, numberParts);
        }

        public int bytesRead() {
            return this.bytesRead;
        }

        public NumberParts parts() {
            return this.parts;
        }
    }

    static int a(int i) {
        boolean z = (i & 32) != 0;
        if (z) {
            i ^= 255;
        }
        int numberOfLeadingZeros = 5 - (31 - Integer.numberOfLeadingZeros(i & 63));
        return z ? numberOfLeadingZeros : -numberOfLeadingZeros;
    }

    private static byte[] copyOf(byte[] bArr) {
        return (byte[]) bArr.clone();
    }

    public static DecodedNumberParts decode(byte[] bArr) {
        int i;
        int i2;
        int i3;
        NumberParts create;
        int i4 = 1;
        if (bArr.length < 1) {
            throw new IllegalArgumentException("Invalid encoded byte array");
        }
        int i5 = bArr[0] & 255;
        boolean z = (i5 & 128) == 0;
        int i6 = z ? 255 : 0;
        int i7 = i5 ^ i6;
        boolean z2 = (i7 & 64) == 0;
        int i8 = z2 ? 255 : 0;
        int i9 = i7 ^ i8;
        int a = a(i9);
        long j = 0;
        int i10 = 3;
        if (a == -4) {
            i = 64;
            if (z2) {
                throw new IllegalArgumentException("Invalid encoded number " + Arrays.toString(bArr) + ": exponent negative zero is invalid");
            }
            i2 = i7;
            i3 = 0;
            i10 = 1;
        } else if (a == -3 || a == -2 || a == -1) {
            int i11 = a + 4;
            int i12 = 64 - i11;
            j = 0 | (((((-1) ^ ((-1) << (i11 + 1))) & 126) & i7) << (i12 - 1));
            i = i12;
            i10 = 1;
            i3 = i11;
            i2 = i7;
        } else {
            if (a != 1) {
                if (a != 2) {
                    if (a != 3) {
                        if (a != 6) {
                            throw new IllegalArgumentException("Invalid encoded byte array");
                        }
                        if (!z) {
                            create = z2 ? NumberParts.create(false, Integer.MIN_VALUE, 0L) : NumberParts.create(false, Integer.MAX_VALUE, 0L);
                        } else if (z2) {
                            create = NumberParts.create(true, Integer.MIN_VALUE, 0L);
                        } else {
                            if (bArr.length < 2) {
                                throw new IllegalArgumentException("Invalid encoded byte array");
                            }
                            int i13 = bArr[1] & 255;
                            if (i13 == 128) {
                                create = NumberParts.create(true, Integer.MAX_VALUE, 0L);
                            } else {
                                if (i13 != 96) {
                                    throw new IllegalArgumentException("Invalid encoded byte array");
                                }
                                create = NumberParts.create(true, Integer.MAX_VALUE, 1L);
                            }
                            i4 = 2;
                        }
                        return DecodedNumberParts.a(i4, create);
                    }
                    if (bArr.length < 3) {
                        throw new IllegalArgumentException("Invalid encoded byte array");
                    }
                    i3 = (((i9 & 3) << 8) | (((bArr[1] & 255) ^ i6) ^ i8)) + EXP3_END;
                    i2 = (bArr[2] & 255) ^ i6;
                    j = 0 | decodeTrailingSignificandByte(i2, 57);
                } else {
                    if (bArr.length < 3) {
                        throw new IllegalArgumentException("Invalid encoded byte array");
                    }
                    int i14 = (bArr[1] & 255) ^ i6;
                    i3 = (((i9 & 7) << 4) | ((i8 ^ i14) >>> 4)) + 20;
                    i2 = (bArr[2] & 255) ^ i6;
                    j = decodeTrailingSignificandByte(i2, 53) | ((i14 & 15) << 60) | 0;
                    i = 53;
                }
            } else {
                if (bArr.length < 2) {
                    throw new IllegalArgumentException("Invalid encoded byte array");
                }
                i3 = (i9 & 15) + 4;
                int i15 = (bArr[1] & 255) ^ i6;
                j = 0 | decodeTrailingSignificandByte(i15, 57);
                i2 = i15;
                i10 = 2;
            }
            i = 57;
        }
        while ((i2 & 1) != 0) {
            if (i10 >= bArr.length) {
                throw new IllegalArgumentException("Invalid encoded byte array");
            }
            int i16 = i10 + 1;
            int i17 = (bArr[i10] & 255) ^ i6;
            int i18 = i - 7;
            if (i18 >= 0) {
                j |= decodeTrailingSignificandByte(i17, i18);
                i10 = i16;
                i2 = i17;
                i = i18;
            } else {
                j |= (i17 & 254) >>> (-(i18 - 1));
                if ((i17 & 1) != 0) {
                    throw new IllegalArgumentException("Invalid encoded byte array: overlong sequence");
                }
                i10 = i16;
                i2 = i17;
                i = 0;
            }
        }
        if (z2) {
            i3 = -i3;
        }
        return DecodedNumberParts.a(i10, NumberParts.create(z, i3, j));
    }

    public static double decodeDouble(byte[] bArr) {
        return decode(bArr).parts().asDouble();
    }

    public static long decodeLong(byte[] bArr) {
        return decode(bArr).parts().asLong();
    }

    private static long decodeTrailingSignificandByte(int i, int i2) {
        return (i & 254) << (i2 - 1);
    }

    public static byte[] encode(NumberParts numberParts) {
        int i;
        int i2;
        long j;
        if (numberParts.isZero()) {
            return copyOf(ENCODED_ZERO);
        }
        if (numberParts.isNaN()) {
            return copyOf(ENCODED_NAN);
        }
        if (numberParts.isInfinite()) {
            return numberParts.negative() ? copyOf(ENCODED_NEGATIVE_INFINITY) : copyOf(ENCODED_POSITIVE_INFINITY);
        }
        int exponent = numberParts.exponent();
        long significand = numberParts.significand();
        byte[] bArr = new byte[11];
        int i3 = 0;
        int i4 = numberParts.negative() ? 255 : 0;
        if (exponent < 0) {
            exponent = -exponent;
            i = 255;
        } else {
            i = 0;
        }
        if (exponent < 4) {
            int i5 = exponent + 1;
            int i6 = 1 << i5;
            i2 = (((int) (significand >>> (64 - i5))) & (i6 - 2)) | i6 | 192;
            j = significand << exponent;
            if (i != 0) {
                i2 ^= ((-1) << i5) & 126;
            }
        } else if (exponent < 20) {
            bArr[0] = (byte) (((exponent - 4) | 224) ^ ((i & 127) ^ i4));
            i2 = topSignificandByte(significand);
            j = significand << 7;
            i3 = 1;
        } else {
            if (exponent < EXP3_END) {
                int i7 = exponent - 20;
                bArr[0] = (byte) (((i7 >>> 4) | 240) ^ ((i & 127) ^ i4));
                int i8 = ((i7 << 4) & 240) | ((int) (significand >>> 60));
                significand <<= 4;
                bArr[1] = (byte) (i8 ^ ((i & 240) ^ i4));
            } else {
                if (exponent >= EXP4_END) {
                    throw new IllegalStateException("unimplemented");
                }
                int i9 = exponent - 148;
                bArr[0] = (byte) ((248 | (i9 >>> 8)) ^ ((i & 127) ^ i4));
                bArr[1] = (byte) ((i9 & 255) ^ ((i & 255) ^ i4));
            }
            i2 = topSignificandByte(significand);
            j = significand << 7;
            i3 = 2;
        }
        while (j != 0) {
            bArr[i3] = (byte) ((i2 | 1) ^ i4);
            i2 = topSignificandByte(j);
            j <<= 7;
            i3++;
        }
        bArr[i3] = (byte) (i4 ^ i2);
        return Arrays.copyOf(bArr, i3 + 1);
    }

    public static byte[] encodeDouble(double d) {
        return encode(NumberParts.fromDouble(d));
    }

    public static byte[] encodeLong(long j) {
        return encode(NumberParts.fromLong(j));
    }

    private static int topSignificandByte(long j) {
        return ((int) (j >>> 56)) & 254;
    }
}
