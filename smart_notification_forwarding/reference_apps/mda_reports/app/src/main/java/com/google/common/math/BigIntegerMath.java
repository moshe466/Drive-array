package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class BigIntegerMath {

    @VisibleForTesting
    static final BigInteger a = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
    private static final double LN_10 = Math.log(10.0d);
    private static final double LN_2 = Math.log(2.0d);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.math.BigIntegerMath$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[RoundingMode.values().length];

        static {
            try {
                a[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private BigIntegerMath() {
    }

    static BigInteger a(List<BigInteger> list) {
        return a(list, 0, list.size());
    }

    static BigInteger a(List<BigInteger> list, int i, int i2) {
        int i3 = i2 - i;
        if (i3 == 0) {
            return BigInteger.ONE;
        }
        if (i3 == 1) {
            return list.get(i);
        }
        if (i3 == 2) {
            return list.get(i).multiply(list.get(i + 1));
        }
        if (i3 == 3) {
            return list.get(i).multiply(list.get(i + 1)).multiply(list.get(i + 2));
        }
        int i4 = (i2 + i) >>> 1;
        return a(list, i, i4).multiply(a(list, i4, i2));
    }

    @GwtIncompatible
    static boolean a(BigInteger bigInteger) {
        return bigInteger.bitLength() <= 63;
    }

    public static BigInteger binomial(int i, int i2) {
        int i3;
        MathPreconditions.a("n", i);
        MathPreconditions.a("k", i2);
        int i4 = 1;
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        int[] iArr = LongMath.e;
        if (i2 < iArr.length && i <= iArr[i2]) {
            return BigInteger.valueOf(LongMath.binomial(i, i2));
        }
        BigInteger bigInteger = BigInteger.ONE;
        long j = i;
        long j2 = 1;
        int log2 = LongMath.log2(j, RoundingMode.CEILING);
        while (true) {
            int i5 = log2;
            while (i4 < i2) {
                i3 = i - i4;
                i4++;
                i5 += log2;
                if (i5 >= 63) {
                    break;
                }
                j *= i3;
                j2 *= i4;
            }
            return bigInteger.multiply(BigInteger.valueOf(j)).divide(BigInteger.valueOf(j2));
            bigInteger = bigInteger.multiply(BigInteger.valueOf(j)).divide(BigInteger.valueOf(j2));
            j = i3;
            j2 = i4;
        }
    }

    @Beta
    public static BigInteger ceilingPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.CEILING));
    }

    @GwtIncompatible
    public static BigInteger divide(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger factorial(int i) {
        MathPreconditions.a("n", i);
        long[] jArr = LongMath.d;
        if (i < jArr.length) {
            return BigInteger.valueOf(jArr[i]);
        }
        ArrayList arrayList = new ArrayList(IntMath.divide(IntMath.log2(i, RoundingMode.CEILING) * i, 64, RoundingMode.CEILING));
        long[] jArr2 = LongMath.d;
        int length = jArr2.length;
        long j = jArr2[length - 1];
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j2 = j >> numberOfTrailingZeros;
        int log2 = LongMath.log2(j2, RoundingMode.FLOOR) + 1;
        long j3 = length;
        int log22 = LongMath.log2(j3, RoundingMode.FLOOR) + 1;
        int i2 = 1 << (log22 - 1);
        while (j3 <= i) {
            if ((i2 & j3) != 0) {
                i2 <<= 1;
                log22++;
            }
            int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j3);
            long j4 = j3 >> numberOfTrailingZeros2;
            numberOfTrailingZeros += numberOfTrailingZeros2;
            if ((log22 - numberOfTrailingZeros2) + log2 >= 64) {
                arrayList.add(BigInteger.valueOf(j2));
                j2 = 1;
            }
            j2 *= j4;
            log2 = LongMath.log2(j2, RoundingMode.FLOOR) + 1;
            j3++;
        }
        if (j2 > 1) {
            arrayList.add(BigInteger.valueOf(j2));
        }
        return a(arrayList).shiftLeft(numberOfTrailingZeros);
    }

    @Beta
    public static BigInteger floorPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.FLOOR));
    }

    public static boolean isPowerOfTwo(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        return bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1 A[FALL_THROUGH, RETURN] */
    @com.google.common.annotations.GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int log10(java.math.BigInteger r7, java.math.RoundingMode r8) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.b(r0, r7)
            boolean r0 = a(r7)
            if (r0 == 0) goto L14
            long r0 = r7.longValue()
            int r7 = com.google.common.math.LongMath.log10(r0, r8)
            return r7
        L14:
            java.math.RoundingMode r0 = java.math.RoundingMode.FLOOR
            int r0 = log2(r7, r0)
            double r0 = (double) r0
            double r2 = com.google.common.math.BigIntegerMath.LN_2
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r2
            double r2 = com.google.common.math.BigIntegerMath.LN_10
            double r0 = r0 / r2
            int r0 = (int) r0
            java.math.BigInteger r1 = java.math.BigInteger.TEN
            java.math.BigInteger r1 = r1.pow(r0)
            int r2 = r1.compareTo(r7)
            if (r2 <= 0) goto L41
        L32:
            int r0 = r0 + (-1)
            java.math.BigInteger r2 = java.math.BigInteger.TEN
            java.math.BigInteger r1 = r1.divide(r2)
            int r2 = r1.compareTo(r7)
            if (r2 > 0) goto L32
            goto L65
        L41:
            java.math.BigInteger r3 = java.math.BigInteger.TEN
            java.math.BigInteger r3 = r3.multiply(r1)
            int r4 = r3.compareTo(r7)
            r5 = r3
            r3 = r2
            r2 = r4
            r4 = r5
        L4f:
            if (r2 > 0) goto L64
            int r0 = r0 + 1
            java.math.BigInteger r1 = java.math.BigInteger.TEN
            java.math.BigInteger r1 = r1.multiply(r4)
            int r3 = r1.compareTo(r7)
            r5 = r4
            r4 = r1
            r1 = r5
            r6 = r3
            r3 = r2
            r2 = r6
            goto L4f
        L64:
            r2 = r3
        L65:
            int[] r3 = com.google.common.math.BigIntegerMath.AnonymousClass1.a
            int r8 = r8.ordinal()
            r8 = r3[r8]
            switch(r8) {
                case 1: goto L99;
                case 2: goto La1;
                case 3: goto La1;
                case 4: goto L8f;
                case 5: goto L8f;
                case 6: goto L76;
                case 7: goto L76;
                case 8: goto L76;
                default: goto L70;
            }
        L70:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L76:
            r8 = 2
            java.math.BigInteger r7 = r7.pow(r8)
            java.math.BigInteger r8 = r1.pow(r8)
            java.math.BigInteger r1 = java.math.BigInteger.TEN
            java.math.BigInteger r8 = r8.multiply(r1)
            int r7 = r7.compareTo(r8)
            if (r7 > 0) goto L8c
            goto L8e
        L8c:
            int r0 = r0 + 1
        L8e:
            return r0
        L8f:
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L96
            goto L98
        L96:
            int r0 = r0 + 1
        L98:
            return r0
        L99:
            if (r2 != 0) goto L9d
            r7 = 1
            goto L9e
        L9d:
            r7 = 0
        L9e:
            com.google.common.math.MathPreconditions.b(r7)
        La1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.BigIntegerMath.log10(java.math.BigInteger, java.math.RoundingMode):int");
    }

    public static int log2(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.b("x", (BigInteger) Preconditions.checkNotNull(bigInteger));
        int bitLength = bigInteger.bitLength() - 1;
        switch (AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.b(isPowerOfTwo(bigInteger));
            case 2:
            case 3:
                return bitLength;
            case 4:
            case 5:
                return isPowerOfTwo(bigInteger) ? bitLength : bitLength + 1;
            case 6:
            case 7:
            case 8:
                return bitLength < 256 ? bigInteger.compareTo(a.shiftRight(256 - bitLength)) <= 0 ? bitLength : bitLength + 1 : bigInteger.pow(2).bitLength() + (-1) < (bitLength * 2) + 1 ? bitLength : bitLength + 1;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static BigInteger sqrt(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.a("x", bigInteger);
        if (a(bigInteger)) {
            return BigInteger.valueOf(LongMath.sqrt(bigInteger.longValue(), roundingMode));
        }
        BigInteger sqrtFloor = sqrtFloor(bigInteger);
        switch (AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.b(sqrtFloor.pow(2).equals(bigInteger));
            case 2:
            case 3:
                return sqrtFloor;
            case 4:
            case 5:
                int intValue = sqrtFloor.intValue();
                return intValue * intValue == bigInteger.intValue() && sqrtFloor.pow(2).equals(bigInteger) ? sqrtFloor : sqrtFloor.add(BigInteger.ONE);
            case 6:
            case 7:
            case 8:
                return sqrtFloor.pow(2).add(sqrtFloor).compareTo(bigInteger) >= 0 ? sqrtFloor : sqrtFloor.add(BigInteger.ONE);
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    private static BigInteger sqrtApproxWithDoubles(BigInteger bigInteger) {
        return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.a(bigInteger)), RoundingMode.HALF_EVEN);
    }

    @GwtIncompatible
    private static BigInteger sqrtFloor(BigInteger bigInteger) {
        BigInteger shiftLeft;
        int log2 = log2(bigInteger, RoundingMode.FLOOR);
        if (log2 < 1023) {
            shiftLeft = sqrtApproxWithDoubles(bigInteger);
        } else {
            int i = (log2 - 52) & (-2);
            shiftLeft = sqrtApproxWithDoubles(bigInteger.shiftRight(i)).shiftLeft(i >> 1);
        }
        BigInteger shiftRight = shiftLeft.add(bigInteger.divide(shiftLeft)).shiftRight(1);
        if (shiftLeft.equals(shiftRight)) {
            return shiftLeft;
        }
        while (true) {
            BigInteger shiftRight2 = shiftRight.add(bigInteger.divide(shiftRight)).shiftRight(1);
            if (shiftRight2.compareTo(shiftRight) >= 0) {
                return shiftRight;
            }
            shiftRight = shiftRight2;
        }
    }
}
