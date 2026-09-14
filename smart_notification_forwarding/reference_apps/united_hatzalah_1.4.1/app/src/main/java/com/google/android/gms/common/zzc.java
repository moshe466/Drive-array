package com.google.android.gms.common;

/* loaded from: classes.dex */
public final class zzc {
    public static int zza(int i) {
        int[] iArr = {1, 2, 3};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr[i3];
            int i5 = i4 - 1;
            if (i4 != 0) {
                if (i5 == i) {
                    return i4;
                }
            } else {
                throw null;
            }
        }
        return 1;
    }
}
