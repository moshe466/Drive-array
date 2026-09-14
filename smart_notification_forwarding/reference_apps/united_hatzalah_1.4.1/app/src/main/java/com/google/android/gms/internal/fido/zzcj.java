package com.google.android.gms.internal.fido;

import java.math.RoundingMode;

/* loaded from: classes.dex */
public final class zzcj {
    public static int zza(int i, int i3, RoundingMode roundingMode) {
        roundingMode.getClass();
        if (i3 != 0) {
            int i4 = i / i3;
            int i5 = i - (i3 * i4);
            if (i5 != 0) {
                int i6 = 1;
                int i7 = ((i ^ i3) >> 31) | 1;
                switch (zzci.zza[roundingMode.ordinal()]) {
                    case 1:
                        zzck.zza(false);
                        return i4;
                    case 2:
                        return i4;
                    case 3:
                        if (i7 >= 0) {
                            return i4;
                        }
                        break;
                    case 4:
                        break;
                    case 5:
                        if (i7 <= 0) {
                            return i4;
                        }
                        break;
                    case 6:
                    case 7:
                    case 8:
                        int abs = Math.abs(i5);
                        int abs2 = abs - (Math.abs(i3) - abs);
                        if (abs2 == 0) {
                            if (roundingMode != RoundingMode.HALF_UP) {
                                if (roundingMode != RoundingMode.HALF_EVEN) {
                                    i6 = 0;
                                }
                                if ((i4 & 1 & i6) == 0) {
                                    return i4;
                                }
                            }
                        } else if (abs2 <= 0) {
                            return i4;
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
                return i4 + i7;
            }
            return i4;
        }
        throw new ArithmeticException("/ by zero");
    }

    public static int zzb(int i, RoundingMode roundingMode) {
        boolean z3;
        if (i > 0) {
            switch (zzci.zza[roundingMode.ordinal()]) {
                case 1:
                    if (((i - 1) & i) == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zzck.zza(z3);
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                case 5:
                    return 32 - Integer.numberOfLeadingZeros(i - 1);
                case 6:
                case 7:
                case 8:
                    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                    return (31 - numberOfLeadingZeros) + ((((-1257966797) >>> numberOfLeadingZeros) - i) >>> 31);
                default:
                    throw new AssertionError();
            }
            return 31 - Integer.numberOfLeadingZeros(i);
        }
        throw new IllegalArgumentException("x (0) must be > 0");
    }
}
