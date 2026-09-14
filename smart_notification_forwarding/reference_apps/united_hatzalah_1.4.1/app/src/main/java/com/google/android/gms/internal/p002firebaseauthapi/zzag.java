package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;

/* loaded from: classes.dex */
final class zzag {
    public static int zza(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 == null) {
            throw new NullPointerException(a.e("null value in entry: ", String.valueOf(obj), "=null"));
        }
    }
}
