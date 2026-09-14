package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(17)
/* loaded from: classes.dex */
public final class zzayf {
    private static zzayf zzdux;
    String a;

    private zzayf() {
    }

    public static zzayf zzxc() {
        if (zzdux == null) {
            zzdux = new zzayf();
        }
        return zzdux;
    }
}
