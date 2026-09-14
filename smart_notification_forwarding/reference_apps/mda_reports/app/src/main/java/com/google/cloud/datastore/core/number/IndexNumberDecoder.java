package com.google.cloud.datastore.core.number;

/* loaded from: classes2.dex */
public class IndexNumberDecoder {
    private String doubleResultRepProblemMessage;
    private String longResultRepProblemMessage;
    private double resultAsDouble;
    private long resultAsLong;
    private int resultExponent;
    private boolean resultNegative;
    private long resultSignificand;

    public IndexNumberDecoder() {
        reset();
    }

    static int a(int i) {
        boolean z = (i & 32) != 0;
        if (z) {
            i ^= 255;
        }
        int numberOfLeadingZeros = 5 - (31 - Integer.numberOfLeadingZeros(i & 63));
        return z ? numberOfLeadingZeros : -numberOfLeadingZeros;
    }

    private static long decodeTrailingSignificandByte(int i, int i2) {
        return (i & 254) << (i2 - 1);
    }

    private void recordNumber(boolean z, int i, long j) {
        this.longResultRepProblemMessage = null;
        this.doubleResultRepProblemMessage = null;
        this.resultNegative = z;
        this.resultExponent = i;
        this.resultSignificand = j;
    }

    private void updateResultDoubleState() {
        int i;
        if (this.doubleResultRepProblemMessage != null) {
            return;
        }
        this.doubleResultRepProblemMessage = "";
        int i2 = this.resultExponent;
        if (i2 == Integer.MAX_VALUE) {
            this.resultAsDouble = this.resultSignificand == 0 ? this.resultNegative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY : Double.NaN;
            return;
        }
        if (i2 == Integer.MIN_VALUE && this.resultSignificand == 0) {
            this.resultAsDouble = 0.0d;
            return;
        }
        if (64 - Long.numberOfTrailingZeros(this.resultSignificand) > 52) {
            this.doubleResultRepProblemMessage = "Number has too many significant bits for a double.";
            return;
        }
        this.resultSignificand >>>= 12;
        int i3 = this.resultExponent;
        if (i3 >= -1022) {
            i = i3 + 1023;
        } else {
            int i4 = (-1022) - i3;
            long j = this.resultSignificand;
            this.resultSignificand = j >>> i4;
            if ((this.resultSignificand << i4) != j) {
                this.doubleResultRepProblemMessage = "Number has too many significant bits for a subnormal double.";
            }
            this.resultSignificand |= 1 << (52 - i4);
            i = 0;
        }
        this.resultExponent = i;
        this.resultAsDouble = Double.longBitsToDouble((this.resultExponent << 52) | this.resultSignificand | (this.resultNegative ? Long.MIN_VALUE : 0L));
    }

    private void updateResultLongState() {
        long j;
        if (this.longResultRepProblemMessage != null) {
            return;
        }
        this.longResultRepProblemMessage = "";
        int i = this.resultExponent;
        if (i == Integer.MAX_VALUE) {
            this.longResultRepProblemMessage = this.resultSignificand == 0 ? this.resultNegative ? "+Infinity is not an integer." : "-Infinity is not an integer." : "NaN is not an integer.";
            return;
        }
        if (i == Integer.MIN_VALUE && this.resultSignificand == 0) {
            this.resultAsLong = 0L;
            return;
        }
        int i2 = this.resultExponent;
        if (i2 >= 0) {
            if (i2 < 64) {
                if (i2 != 63) {
                    int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(this.resultSignificand);
                    int i3 = this.resultExponent;
                    if (i3 >= numberOfTrailingZeros) {
                        j = (1 << i3) ^ (this.resultSignificand >>> ((63 - i3) + 1));
                        if (this.resultNegative) {
                            j = -j;
                        }
                    }
                } else if (this.resultSignificand == 0 && this.resultNegative) {
                    j = Long.MIN_VALUE;
                }
                this.resultAsLong = j;
                return;
            }
            this.longResultRepProblemMessage = "Number is outside the long range.";
            return;
        }
        this.longResultRepProblemMessage = "Number is not an integer.";
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00df -> B:46:0x00fe). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int decode(boolean r18, byte[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.cloud.datastore.core.number.IndexNumberDecoder.decode(boolean, byte[], int):int");
    }

    public boolean isResultDouble() {
        updateResultDoubleState();
        return this.doubleResultRepProblemMessage.isEmpty();
    }

    public boolean isResultLong() {
        updateResultLongState();
        return this.longResultRepProblemMessage.isEmpty();
    }

    public void reset() {
        this.longResultRepProblemMessage = "No bytes decoded.";
        this.doubleResultRepProblemMessage = "No bytes decoded.";
    }

    public double resultAsDouble() {
        updateResultDoubleState();
        if (this.doubleResultRepProblemMessage.isEmpty()) {
            return this.resultAsDouble;
        }
        throw new IllegalArgumentException(this.doubleResultRepProblemMessage);
    }

    public long resultAsLong() {
        updateResultLongState();
        if (this.longResultRepProblemMessage.isEmpty()) {
            return this.resultAsLong;
        }
        throw new IllegalArgumentException(this.longResultRepProblemMessage);
    }
}
