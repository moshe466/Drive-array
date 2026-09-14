package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzblc implements zzdxg<zzats> {
    private final zzdxp<Context> zzejv;
    private final zzbkn zzfen;
    private final zzdxp<zzczu> zzfep;

    public zzblc(zzbkn zzbknVar, zzdxp<Context> zzdxpVar, zzdxp<zzczu> zzdxpVar2) {
        this.zzfen = zzbknVar;
        this.zzejv = zzdxpVar;
        this.zzfep = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzats) zzdxm.zza(new zzats(this.zzejv.get(), this.zzfep.get().zzgmm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
