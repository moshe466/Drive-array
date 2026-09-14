package com.google.android.gms.internal.ads;

import com.google.firebase.firestore.util.ExponentialBackoff;

/* loaded from: classes.dex */
public final class zzabj {
    private static zzaan<Long> zzcuq = zzaan.zzb("gads:ad_loader:timeout_ms", ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
    public static zzaan<Long> zzcur = zzaan.zzb("gads:rendering:timeout_ms", ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
    private static zzaan<Long> zzcus = zzaan.zzb("gads:resolve_future:default_timeout_ms", 30000);
}
