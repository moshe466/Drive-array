package com.google.cloud.datastore.core.number;

/* loaded from: classes2.dex */
public final class NumberParts {
    private static final int DOUBLE_EXPONENT_BIAS = 1023;
    private static final int DOUBLE_MIN_EXPONENT = -1022;
    private static final int DOUBLE_SIGNIFICAND_BITS = 52;
    private static final long DOUBLE_SIGN_BIT = Long.MIN_VALUE;
    private final int exponent;
    private final boolean negative;
    private final long significand;

    private NumberParts(boolean z, int i, long j) {
        this.negative = z;
        this.exponent = i;
        this.significand = j;
    }

    public static NumberParts create(boolean z, int i, long j) {
        if (i != Integer.MAX_VALUE || j == 0 || (z && j == 1)) {
            return new NumberParts(z, i, j);
        }
        throw new IllegalArgumentException("Invalid number parts: non-normalized NaN");
    }

    private static String doubleRepresentationError() {
        return null;
    }

    public static NumberParts fromDouble(double d) {
        long j;
        long doubleToLongBits = Double.doubleToLongBits(d);
        boolean z = d < 0.0d;
        int i = ((int) ((doubleToLongBits >>> 52) & 2047)) - DOUBLE_EXPONENT_BIAS;
        long j2 = doubleToLongBits & 4503599627370495L;
        if (i < DOUBLE_MIN_EXPONENT) {
            if (j2 == 0) {
                return create(false, Integer.MIN_VALUE, 0L);
            }
            int numberOfLeadingZeros = Long.numberOfLeadingZeros(j2);
            j = (j2 & ((1 << (63 - numberOfLeadingZeros)) ^ (-1))) << (numberOfLeadingZeros + 1);
            i -= numberOfLeadingZeros - 12;
        } else {
            if (i > DOUBLE_EXPONENT_BIAS) {
                return j2 == 0 ? z ? create(true, Integer.MAX_VALUE, 0L) : create(false, Integer.MAX_VALUE, 0L) : create(true, Integer.MAX_VALUE, 1L);
            }
            j = j2 << 12;
        }
        return create(z, i, j);
    }

    public static NumberParts fromLong(long j) {
        boolean z = false;
        if (j == 0) {
            return create(false, Integer.MIN_VALUE, 0L);
        }
        if (j < 0) {
            j = -j;
            z = true;
        }
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j);
        int i = 63 - numberOfLeadingZeros;
        return create(z, i, (j & ((1 << i) ^ (-1))) << (numberOfLeadingZeros + 1));
    }

    private String longRepresentationError() {
        StringBuilder sb;
        String str;
        if (isZero()) {
            return null;
        }
        if (isInfinite()) {
            sb = new StringBuilder();
            sb.append("Invalid encoded long ");
            sb.append(this);
            str = ": Infinity is not a long";
        } else if (isNaN()) {
            sb = new StringBuilder();
            sb.append("Invalid encoded long ");
            sb.append(this);
            str = ": NaN is not a long";
        } else if (exponent() == 63) {
            if (significand() == 0 && negative()) {
                return null;
            }
            sb = new StringBuilder();
            sb.append("Invalid encoded long ");
            sb.append(this);
            str = ": overflow";
        } else if (exponent() < 0 || exponent() > 63) {
            sb = new StringBuilder();
            sb.append("Invalid encoded long ");
            sb.append(this);
            sb.append(": exponent ");
            sb.append(exponent());
            str = " too large";
        } else {
            if (exponent() >= 64 - Long.numberOfTrailingZeros(significand())) {
                return null;
            }
            sb = new StringBuilder();
            sb.append("Invalid encoded long ");
            sb.append(this);
            str = ": contains fractional part";
        }
        sb.append(str);
        return sb.toString();
    }

    public double asDouble() {
        long j;
        long j2;
        String doubleRepresentationError = doubleRepresentationError();
        if (doubleRepresentationError != null) {
            throw new IllegalArgumentException(doubleRepresentationError);
        }
        if (isZero()) {
            return 0.0d;
        }
        if (isInfinite()) {
            return negative() ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        if (isNaN()) {
            return Double.NaN;
        }
        long exponent = exponent();
        long significand = significand() >>> 12;
        if (exponent >= -1022) {
            j = significand;
            j2 = exponent + 1023;
        } else {
            int exponent2 = (-1022) - exponent();
            j = (significand >>> exponent2) | (1 << (52 - exponent2));
            j2 = 0;
        }
        return Double.longBitsToDouble(j | (j2 << 52) | (negative() ? Long.MIN_VALUE : 0L));
    }

    public long asLong() {
        String longRepresentationError = longRepresentationError();
        if (longRepresentationError != null) {
            throw new IllegalArgumentException(longRepresentationError);
        }
        if (isZero()) {
            return 0L;
        }
        if (exponent() == 63) {
            return Long.MIN_VALUE;
        }
        long significand = (significand() >>> ((63 - exponent()) + 1)) ^ (1 << exponent());
        return negative() ? -significand : significand;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NumberParts)) {
            return false;
        }
        NumberParts numberParts = (NumberParts) obj;
        return this.negative == numberParts.negative && this.exponent == numberParts.exponent && this.significand == numberParts.significand;
    }

    public int exponent() {
        return this.exponent;
    }

    public int hashCode() {
        int i = (((this.negative ? 1 : 0) * 31) + this.exponent) * 31;
        long j = this.significand;
        return i + ((int) (j ^ (j >>> 32)));
    }

    public boolean isInfinite() {
        return exponent() == Integer.MAX_VALUE && significand() == 0;
    }

    public boolean isNaN() {
        return exponent() == Integer.MAX_VALUE && significand() != 0;
    }

    public boolean isZero() {
        return exponent() == Integer.MIN_VALUE && significand() == 0;
    }

    public NumberParts negate() {
        return (isZero() || isNaN()) ? this : create(!negative(), exponent(), significand());
    }

    public boolean negative() {
        return this.negative;
    }

    public boolean representableAsDouble() {
        return doubleRepresentationError() == null;
    }

    public boolean representableAsLong() {
        return longRepresentationError() == null;
    }

    public long significand() {
        return this.significand;
    }
}
