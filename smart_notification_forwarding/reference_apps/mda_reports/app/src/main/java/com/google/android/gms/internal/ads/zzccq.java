package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzccq implements zzdxg<zzbsu<zzbqb>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzccw> zzfdd;

    private zzccq(zzdxp<zzccw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfdd = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzccq zzr(zzdxp<zzccw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzccq(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdd.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
