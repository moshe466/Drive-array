package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbsg implements zzdxg<Set<zzbsu<zzbsz>>> {
    private final zzbrm zzfim;

    private zzbsg(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbsg zzx(zzbrm zzbrmVar) {
        return new zzbsg(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
