package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbsc implements zzdxg<Set<zzbsu<zzbqg>>> {
    private final zzbrm zzfim;

    private zzbsc(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbsc zzt(zzbrm zzbrmVar) {
        return new zzbsc(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzfim.zzahu(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
