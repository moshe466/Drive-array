package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
final class zzkl {
    public static void zza(boolean z3, String str, long j2, long j3) {
        if (z3) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j2 + ", " + j3 + ")");
    }

    public static void zzb(boolean z3) {
        if (z3) {
        } else {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
