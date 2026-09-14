package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbuj implements zzdxg<zzbsu<zzbrb>> {
    private final zzdxp<Executor> zzfcv;
    private final zzbtv zzfje;

    private zzbuj(zzbtv zzbtvVar, zzdxp<Executor> zzdxpVar) {
        this.zzfje = zzbtvVar;
        this.zzfcv = zzdxpVar;
    }

    public static zzbuj zzd(zzbtv zzbtvVar, zzdxp<Executor> zzdxpVar) {
        return new zzbuj(zzbtvVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(this.zzfje.zzb(this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
