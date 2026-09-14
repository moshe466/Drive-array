package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbrs implements zzdxg<Set<zzbsu<zzbqb>>> {
    private final zzbrm zzfim;

    private zzbrs(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbrs zzi(zzbrm zzbrmVar) {
        return new zzbrs(zzbrmVar);
    }

    public static Set<zzbsu<zzbqb>> zzj(zzbrm zzbrmVar) {
        return (Set) zzdxm.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzj(this.zzfim);
    }
}
