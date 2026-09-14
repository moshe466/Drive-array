package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbrv implements zzdxg<Set<zzbsu<zzbpa>>> {
    private final zzbrm zzfim;

    public zzbrv(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfim.zzahp(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
