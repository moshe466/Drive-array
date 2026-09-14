package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbod;

/* loaded from: classes.dex */
public final class zzbon implements zzdxg<zzbod.zza> {
    private final zzbod zzfhi;

    private zzbon(zzbod zzbodVar) {
        this.zzfhi = zzbodVar;
    }

    public static zzbon zzl(zzbod zzbodVar) {
        return new zzbon(zzbodVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbod.zza) zzdxm.zza(this.zzfhi.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
