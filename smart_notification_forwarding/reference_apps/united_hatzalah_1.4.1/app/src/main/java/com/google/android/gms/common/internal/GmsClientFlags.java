package com.google.android.gms.common.internal;

/* loaded from: classes.dex */
public final class GmsClientFlags {
    private static volatile boolean zza = true;

    private GmsClientFlags() {
    }

    public static boolean isBindServiceOptimizationEnabled(String str) {
        return zza;
    }
}
