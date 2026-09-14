package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzdbq implements zzdxg<Executor> {
    private static final zzdbq zzgpp = new zzdbq();

    public static zzdbq zzapv() {
        return zzgpp;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Executor) zzdxm.zza(zzazd.zzdwi, "Cannot return null from a non-@Nullable @Provides method");
    }
}
