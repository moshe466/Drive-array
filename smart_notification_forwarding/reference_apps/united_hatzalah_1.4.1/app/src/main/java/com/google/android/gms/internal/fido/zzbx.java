package com.google.android.gms.internal.fido;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbx {
    public static int zza(Set set) {
        int i;
        int i3 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i3 += i;
        }
        return i3;
    }
}
