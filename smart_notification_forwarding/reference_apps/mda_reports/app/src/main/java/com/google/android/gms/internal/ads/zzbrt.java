package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbrt implements zzdxg<Set<zzbsu<zzty>>> {
    private final zzbrm zzfim;

    private zzbrt(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbrt zzk(zzbrm zzbrmVar) {
        return new zzbrt(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfim.zzahs(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
