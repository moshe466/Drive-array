package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbuc implements zzdxg<Set<zzbsu<zzbov>>> {
    private final zzdxp<zzbva> zzfdq;
    private final zzbtv zzfje;

    private zzbuc(zzbtv zzbtvVar, zzdxp<zzbva> zzdxpVar) {
        this.zzfje = zzbtvVar;
        this.zzfdq = zzdxpVar;
    }

    public static zzbuc zza(zzbtv zzbtvVar, zzdxp<zzbva> zzdxpVar) {
        return new zzbuc(zzbtvVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfje.zza(this.zzfdq.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
