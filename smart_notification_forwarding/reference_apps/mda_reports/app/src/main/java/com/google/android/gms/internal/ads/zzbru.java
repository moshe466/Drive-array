package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbru implements zzdxg<Set<zzbsu<zzbrb>>> {
    private final zzbrm zzfim;

    private zzbru(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbru zzl(zzbrm zzbrmVar) {
        return new zzbru(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
