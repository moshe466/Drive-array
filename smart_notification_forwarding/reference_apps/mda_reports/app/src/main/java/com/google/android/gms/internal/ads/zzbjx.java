package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbjx implements zzdxg<Set<zzbsu<zzps>>> {
    private final zzbjw zzfdn;
    private final zzdxp<zzbly> zzfdq;

    public zzbjx(zzbjw zzbjwVar, zzdxp<zzbly> zzdxpVar) {
        this.zzfdn = zzbjwVar;
        this.zzfdq = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(Collections.singleton(new zzbsu(this.zzfdq.get(), zzazd.zzdwj)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
