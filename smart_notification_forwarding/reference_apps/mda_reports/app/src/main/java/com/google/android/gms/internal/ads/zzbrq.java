package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbrq implements zzdxg<zzbou> {
    private final zzbrm zzfim;
    private final zzdxp<Set<zzbsu<zzbow>>> zzfin;

    private zzbrq(zzbrm zzbrmVar, zzdxp<Set<zzbsu<zzbow>>> zzdxpVar) {
        this.zzfim = zzbrmVar;
        this.zzfin = zzdxpVar;
    }

    public static zzbrq zza(zzbrm zzbrmVar, zzdxp<Set<zzbsu<zzbow>>> zzdxpVar) {
        return new zzbrq(zzbrmVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbou) zzdxm.zza(this.zzfim.zzc(this.zzfin.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
