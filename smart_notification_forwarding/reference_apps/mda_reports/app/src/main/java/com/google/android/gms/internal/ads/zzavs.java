package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.ads.AdRequest;

/* loaded from: classes.dex */
public final class zzavs extends zzayu {
    public static void zza(String str, Throwable th) {
        if (zzvs()) {
            Log.v(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzed(String str) {
        if (zzvs()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzvs() {
        return zzayu.isLoggable(2) && zzabc.zzctx.get().booleanValue();
    }
}
