package io.opencensus.common;

import java.math.BigInteger;

/* loaded from: classes2.dex */
final class TimeUtils {
    private static final BigInteger MAX_LONG_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger MIN_LONG_VALUE = BigInteger.valueOf(Long.MIN_VALUE);

    private TimeUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(long j, long j2) {
        BigInteger add = BigInteger.valueOf(j).add(BigInteger.valueOf(j2));
        if (add.compareTo(MAX_LONG_VALUE) <= 0 && add.compareTo(MIN_LONG_VALUE) >= 0) {
            return j + j2;
        }
        throw new ArithmeticException("Long sum overflow: x=" + j + ", y=" + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
