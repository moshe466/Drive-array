package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbnn implements zzdxg<zzbsu<zzbpe>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzbiw> zzfdq;

    private zzbnn(zzdxp<zzbiw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfdq = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzbnn zze(zzdxp<zzbiw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzbnn(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
