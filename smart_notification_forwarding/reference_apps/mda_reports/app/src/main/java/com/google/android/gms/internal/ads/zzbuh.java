package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbuh implements zzdxg<zzbsu<zzbov>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzbve> zzfdq;
    private final zzbtv zzfje;

    private zzbuh(zzbtv zzbtvVar, zzdxp<zzbve> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfje = zzbtvVar;
        this.zzfdq = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzbuh zzb(zzbtv zzbtvVar, zzdxp<zzbve> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzbuh(zzbtvVar, zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
