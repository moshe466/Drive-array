package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbsa implements zzdxg<Set<zzbsu<zzbqb>>> {
    private final zzbrm zzfim;

    private zzbsa(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbsa zzq(zzbrm zzbrmVar) {
        return new zzbsa(zzbrmVar);
    }

    public static Set<zzbsu<zzbqb>> zzr(zzbrm zzbrmVar) {
        return (Set) zzdxm.zza(zzbrmVar.zzahn(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzr(this.zzfim);
    }
}
