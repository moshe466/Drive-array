package com.google.android.gms.internal.common;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
public final class zzai {
    public static Object[] zza(Object[] objArr, int i) {
        for (int i3 = 0; i3 < i; i3++) {
            if (objArr[i3] == null) {
                throw new NullPointerException(AbstractC0008a.t(new StringBuilder(String.valueOf(i3).length() + 9), "at index ", i3));
            }
        }
        return objArr;
    }
}
