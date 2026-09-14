package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbrr implements zzdxg<Set<zzbsu<com.google.android.gms.ads.internal.overlay.zzo>>> {
    private final zzbrm zzfim;

    private zzbrr(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbrr zzh(zzbrm zzbrmVar) {
        return new zzbrr(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
