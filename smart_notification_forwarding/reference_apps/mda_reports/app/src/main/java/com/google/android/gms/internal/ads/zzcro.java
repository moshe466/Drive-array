package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public final class zzcro implements zzdxg<zzczj> {
    private final zzdxp<Clock> zzfcz;

    public zzcro(zzdxp<Clock> zzdxpVar) {
        this.zzfcz = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzczj) zzdxm.zza(new zzczj(this.zzfcz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
