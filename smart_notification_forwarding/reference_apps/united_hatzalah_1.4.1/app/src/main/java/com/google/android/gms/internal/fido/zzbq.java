package com.google.android.gms.internal.fido;

import e0.a;

/* loaded from: classes.dex */
public final class zzbq {
    public static Object zza(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(a.c(i, "at index "));
    }

    public static Object[] zzb(Object[] objArr, int i) {
        for (int i3 = 0; i3 < i; i3++) {
            zza(objArr[i3], i3);
        }
        return objArr;
    }
}
