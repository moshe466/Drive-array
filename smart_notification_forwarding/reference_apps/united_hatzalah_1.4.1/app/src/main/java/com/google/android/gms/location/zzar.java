package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzar {
    public static int zza(int i) {
        boolean z3 = true;
        if (i != 0 && i != 1) {
            if (i == 2) {
                i = 2;
            } else {
                z3 = false;
            }
        }
        Preconditions.checkArgument(z3, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i));
        return i;
    }

    public static String zzb(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return "THROTTLE_NEVER";
                }
                throw new IllegalArgumentException();
            }
            return "THROTTLE_ALWAYS";
        }
        return "THROTTLE_BACKGROUND";
    }
}
