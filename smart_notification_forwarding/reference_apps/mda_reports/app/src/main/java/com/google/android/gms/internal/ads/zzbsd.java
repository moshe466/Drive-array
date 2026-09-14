package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbsd implements zzdxg<Set<zzbsu<zzps>>> {
    private final zzbrm zzfim;

    private zzbsd(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbsd zzu(zzbrm zzbrmVar) {
        return new zzbsd(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
