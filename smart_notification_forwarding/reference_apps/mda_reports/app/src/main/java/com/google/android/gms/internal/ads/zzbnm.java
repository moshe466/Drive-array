package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbnm implements zzdxg<zzbsu<zzbsz>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzbtc> zzfdq;

    private zzbnm(zzdxp<zzbtc> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfdq = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzbnm zzd(zzdxp<zzbtc> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzbnm(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
