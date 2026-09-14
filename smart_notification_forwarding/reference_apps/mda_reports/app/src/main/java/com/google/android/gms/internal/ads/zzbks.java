package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbks implements zzdxg<zzbpw> {
    private final zzbkn zzfen;
    private final zzdxp<Set<zzbsu<zzbqb>>> zzfeo;

    public zzbks(zzbkn zzbknVar, zzdxp<Set<zzbsu<zzbqb>>> zzdxpVar) {
        this.zzfen = zzbknVar;
        this.zzfeo = zzdxpVar;
    }

    public static zzbpw zza(zzbkn zzbknVar, Set<zzbsu<zzbqb>> set) {
        return (zzbpw) zzdxm.zza(zzbknVar.zza(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzfen, this.zzfeo.get());
    }
}
