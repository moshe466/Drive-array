package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbuk implements zzdxg<Set<zzbsu<zzbsn>>> {
    private final zzdxp<zzbvc> zzfdq;

    private zzbuk(zzdxp<zzbvc> zzdxpVar) {
        this.zzfdq = zzdxpVar;
    }

    public static zzbuk zzu(zzdxp<zzbvc> zzdxpVar) {
        return new zzbuk(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(Collections.singleton(zzbsu.zzb(this.zzfdq.get(), zzazd.zzdwj)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
