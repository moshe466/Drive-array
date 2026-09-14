package com.google.android.gms.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzb {
    public static AdSize zza(int i, int i2) {
        AdSize adSize = new AdSize(i, 0);
        adSize.a(true);
        adSize.a(i2);
        return adSize;
    }

    public static AdSize zza(int i, int i2, String str) {
        return new AdSize(i, i2, str);
    }

    public static boolean zza(AdSize adSize) {
        return adSize.a();
    }

    public static boolean zzb(AdSize adSize) {
        return adSize.b();
    }

    public static int zzc(AdSize adSize) {
        return adSize.c();
    }
}
