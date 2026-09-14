package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcdo implements zzdxg<zzbsu<zzbow>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzcdj> zzfdd;

    private zzcdo(zzdxp<zzcdj> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfdd = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzcdo zzy(zzdxp<zzcdj> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzcdo(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdd.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
