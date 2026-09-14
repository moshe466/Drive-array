package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbkz implements zzdxg<Set<zzbsu<zzps>>> {
    private final zzdxp<zzbly> zzfdq;
    private final zzbkn zzfen;

    public zzbkz(zzbkn zzbknVar, zzdxp<zzbly> zzdxpVar) {
        this.zzfen = zzbknVar;
        this.zzfdq = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(Collections.singleton(new zzbsu(this.zzfdq.get(), zzazd.zzdwj)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
