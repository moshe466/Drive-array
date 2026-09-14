package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbno implements zzdxg<zzbsu<zzbov>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzbiw> zzfdq;

    private zzbno(zzdxp<zzbiw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfdq = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzbno zzf(zzdxp<zzbiw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzbno(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
