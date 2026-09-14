package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcct implements zzdxg<Set<zzbsu<zzdcx>>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzcdf> zzfdd;

    private zzcct(zzdxp<Executor> zzdxpVar, zzdxp<zzcdf> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzfdd = zzdxpVar2;
    }

    public static zzcct zzs(zzdxp<Executor> zzdxpVar, zzdxp<zzcdf> zzdxpVar2) {
        return new zzcct(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        Executor executor = this.zzfcv.get();
        return (Set) zzdxm.zza(((Boolean) zzve.zzoy().zzd(zzzn.zzcnw)).booleanValue() ? Collections.singleton(new zzbsu(this.zzfdd.get(), executor)) : Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
