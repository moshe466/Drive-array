package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzchs implements zzdxg<zzbsu<zzdcx>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzcib> zzfdd;

    private zzchs(zzdxp<zzcib> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfdd = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzchs zzai(zzdxp<zzcib> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzchs(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdd.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
