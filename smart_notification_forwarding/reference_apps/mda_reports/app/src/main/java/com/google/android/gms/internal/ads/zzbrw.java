package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbrw implements zzdxg<Set<zzbsu<zzbow>>> {
    private final zzbrm zzfim;

    private zzbrw(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbrw zzm(zzbrm zzbrmVar) {
        return new zzbrw(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfim.zzaho(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
