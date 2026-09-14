package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public final class zzcrm implements zzdxg<zzcrk<zzcrg>> {
    private final zzdxp<Clock> zzfcz;
    private final zzdxp<zzcrj> zzgfp;

    public zzcrm(zzdxp<zzcrj> zzdxpVar, zzdxp<Clock> zzdxpVar2) {
        this.zzgfp = zzdxpVar;
        this.zzfcz = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzcrk) zzdxm.zza(new zzcrk(this.zzgfp.get(), 10000L, this.zzfcz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
