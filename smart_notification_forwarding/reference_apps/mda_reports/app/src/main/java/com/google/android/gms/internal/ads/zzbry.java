package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbry implements zzdxg<Set<zzbsu<zzbpe>>> {
    private final zzbrm zzfim;

    private zzbry(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbry zzo(zzbrm zzbrmVar) {
        return new zzbry(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfim.zzaht(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
