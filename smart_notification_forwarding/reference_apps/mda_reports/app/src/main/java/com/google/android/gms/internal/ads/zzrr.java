package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzrr {
    private final Object zzbrf = new Object();

    @GuardedBy("poolLock")
    private boolean zzbrg = false;
}
