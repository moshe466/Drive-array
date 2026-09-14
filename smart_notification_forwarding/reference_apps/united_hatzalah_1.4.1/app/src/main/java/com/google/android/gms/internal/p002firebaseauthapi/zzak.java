package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public class zzak<E> {
    public static int zza(int i, int i3) {
        if (i3 >= 0) {
            if (i3 <= i) {
                return i;
            }
            int i4 = i + (i >> 1) + 1;
            if (i4 < i3) {
                i4 = Integer.highestOneBit(i3 - 1) << 1;
            }
            if (i4 < 0) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            return i4;
        }
        throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
    }
}
