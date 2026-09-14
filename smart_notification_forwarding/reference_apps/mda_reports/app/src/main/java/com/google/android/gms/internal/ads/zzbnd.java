package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbnd implements zzdxg<zzbsu<zzbov>> {
    private final zzbnb zzfgs;
    private final zzdxp<zzbnk> zzfgt;

    private zzbnd(zzbnb zzbnbVar, zzdxp<zzbnk> zzdxpVar) {
        this.zzfgs = zzbnbVar;
        this.zzfgt = zzdxpVar;
    }

    public static zzbnd zza(zzbnb zzbnbVar, zzdxp<zzbnk> zzdxpVar) {
        return new zzbnd(zzbnbVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfgt.get(), zzazd.zzdwj), "Cannot return null from a non-@Nullable @Provides method");
    }
}
