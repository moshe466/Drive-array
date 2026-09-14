package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbrx implements zzdxg<Set<zzbsu<zzbov>>> {
    private final zzbrm zzfim;

    private zzbrx(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbrx zzn(zzbrm zzbrmVar) {
        return new zzbrx(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfim.zzahm(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
