package com.google.android.gms.internal.ads;

import android.os.Trace;

/* loaded from: classes.dex */
public final class zzon {
    public static void beginSection(String str) {
        if (zzoq.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzoq.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
