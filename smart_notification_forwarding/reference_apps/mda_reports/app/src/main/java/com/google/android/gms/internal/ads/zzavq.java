package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzavq {
    public static void zzan(Context context) {
        if (zzayo.zzbo(context) && !zzayo.zzxl()) {
            zzdhe<?> zzvr = new zzavt(context).zzvr();
            zzayu.zzey("Updating ad debug logging enablement.");
            zzazh.zza(zzvr, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
