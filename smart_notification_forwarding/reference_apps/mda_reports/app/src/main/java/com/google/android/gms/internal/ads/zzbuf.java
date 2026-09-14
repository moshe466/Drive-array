package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbuf implements zzdxg<zzats> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzczu> zzfep;
    private final zzbtv zzfje;

    private zzbuf(zzbtv zzbtvVar, zzdxp<Context> zzdxpVar, zzdxp<zzczu> zzdxpVar2) {
        this.zzfje = zzbtvVar;
        this.zzejv = zzdxpVar;
        this.zzfep = zzdxpVar2;
    }

    public static zzbuf zza(zzbtv zzbtvVar, zzdxp<Context> zzdxpVar, zzdxp<zzczu> zzdxpVar2) {
        return new zzbuf(zzbtvVar, zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzats) zzdxm.zza(new zzats(this.zzejv.get(), this.zzfep.get().zzgmm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
