package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzq {
    public static int zza(int i) {
        boolean z3 = true;
        if (i != 0 && i != 1) {
            if (i == 2) {
                i = 2;
            } else {
                z3 = false;
            }
        }
        Preconditions.checkArgument(z3, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i));
        return i;
    }

    public static String zzb(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return "GRANULARITY_FINE";
                }
                throw new IllegalArgumentException();
            }
            return "GRANULARITY_COARSE";
        }
        return "GRANULARITY_PERMISSION_LEVEL";
    }
}
