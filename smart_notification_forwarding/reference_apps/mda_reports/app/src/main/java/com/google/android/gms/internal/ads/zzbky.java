package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbky implements zzdxg<Set<zzbsu<zzbqb>>> {
    private final zzdxp<zzbly> zzfdq;
    private final zzbkn zzfen;

    public zzbky(zzbkn zzbknVar, zzdxp<zzbly> zzdxpVar) {
        this.zzfen = zzbknVar;
        this.zzfdq = zzdxpVar;
    }

    public static Set<zzbsu<zzbqb>> zza(zzbkn zzbknVar, zzbly zzblyVar) {
        return (Set) zzdxm.zza(Collections.singleton(new zzbsu(zzblyVar, zzazd.zzdwj)), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzfen, this.zzfdq.get());
    }
}
