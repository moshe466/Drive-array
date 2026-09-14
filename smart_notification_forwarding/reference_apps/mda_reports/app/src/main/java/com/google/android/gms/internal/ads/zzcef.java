package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcef implements zzdxg<Set<zzbsu<zzbph>>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzceo> zzfsb;
    private final zzcee zzfth;

    private zzcef(zzcee zzceeVar, zzdxp<zzceo> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfth = zzceeVar;
        this.zzfsb = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzcef zzb(zzcee zzceeVar, zzdxp<zzceo> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzcef(zzceeVar, zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(zzcee.zza(this.zzfsb.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
