package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
public final class zzdup extends RuntimeException {
    private final List<String> zzhrc;

    public zzdup(zzdte zzdteVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zzhrc = null;
    }
}
