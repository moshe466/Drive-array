package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbhz implements zzdxg<zzaxk> {
    private final zzdxp<Context> zzejv;

    public zzbhz(zzdxp<Context> zzdxpVar) {
        this.zzejv = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzaxk) zzdxm.zza(new zzaxk(this.zzejv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
