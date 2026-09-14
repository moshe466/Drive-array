package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzccm implements zzdxg<zzbsu<zzty>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzccw> zzfdd;

    private zzccm(zzdxp<zzccw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfdd = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzccm zzn(zzdxp<zzccw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzccm(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdd.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
