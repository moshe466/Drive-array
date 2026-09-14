package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcei implements zzdxg<Set<zzbsu<zzbqb>>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzceo> zzfsb;
    private final zzcee zzfth;

    private zzcei(zzcee zzceeVar, zzdxp<zzceo> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfth = zzceeVar;
        this.zzfsb = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static Set<zzbsu<zzbqb>> zzb(zzcee zzceeVar, zzceo zzceoVar, Executor executor) {
        return (Set) zzdxm.zza(zzcee.zzc(zzceoVar, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzcei zzd(zzcee zzceeVar, zzdxp<zzceo> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzcei(zzceeVar, zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzb(this.zzfth, this.zzfsb.get(), this.zzfcv.get());
    }
}
