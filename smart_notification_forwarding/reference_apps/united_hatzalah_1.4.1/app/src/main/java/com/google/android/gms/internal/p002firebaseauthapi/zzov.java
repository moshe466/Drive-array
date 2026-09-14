package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzov {
    private static final zzov zza = new zzov();
    private static final zzoy zzb = new zzoy();
    private final AtomicReference<zzoo> zzc = new AtomicReference<>();

    public static zzov zzb() {
        return zza;
    }

    public final zzoo zza() {
        zzoo zzooVar = this.zzc.get();
        if (zzooVar == null) {
            return zzb;
        }
        return zzooVar;
    }
}
