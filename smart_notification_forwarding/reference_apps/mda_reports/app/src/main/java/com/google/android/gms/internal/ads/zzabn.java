package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzabn {
    private static final AtomicReference<zzabo> zzcuy = new AtomicReference<>();
    static final AtomicBoolean a = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzabo a() {
        return zzcuy.get();
    }

    public static void zza(zzabo zzaboVar) {
        zzcuy.set(zzaboVar);
    }
}
