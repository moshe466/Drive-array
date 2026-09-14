package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzkk {
    public static long zza(long j2, long j3) {
        boolean z3;
        boolean z4 = false;
        if ((j2 ^ j3) < 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        long j4 = j2 + j3;
        if ((j2 ^ j4) >= 0) {
            z4 = true;
        }
        zzkl.zza(z3 | z4, "checkedAdd", j2, j3);
        return j4;
    }

    public static long zzb(long j2, long j3) {
        boolean z3;
        boolean z4 = false;
        if ((1 ^ j2) >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        long j4 = (-1) + j2;
        if ((j2 ^ j4) >= 0) {
            z4 = true;
        }
        zzkl.zza(z3 | z4, "checkedSubtract", j2, 1L);
        return j4;
    }
}
