package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
public final class zzbc {
    public static long zza(long j2, long j3) {
        boolean z3;
        long j4 = j2 + j3;
        boolean z4 = false;
        if ((j2 ^ j3) < 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((j2 ^ j4) >= 0) {
            z4 = true;
        }
        zzbb.zza(z3 | z4, "checkedAdd", j2, j3);
        return j4;
    }

    public static long zzb(long j2, long j3) {
        boolean z3;
        long j4 = j2 - 1;
        boolean z4 = false;
        if ((1 ^ j2) >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((j2 ^ j4) >= 0) {
            z4 = true;
        }
        zzbb.zza(z3 | z4, "checkedSubtract", j2, 1L);
        return j4;
    }
}
