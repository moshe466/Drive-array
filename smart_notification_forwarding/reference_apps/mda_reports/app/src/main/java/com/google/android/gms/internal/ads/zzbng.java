package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbng implements zzdxg<zzbsu<zzbpe>> {
    private final zzbnb zzfgs;
    private final zzdxp<zzbnk> zzfgt;

    private zzbng(zzbnb zzbnbVar, zzdxp<zzbnk> zzdxpVar) {
        this.zzfgs = zzbnbVar;
        this.zzfgt = zzdxpVar;
    }

    public static zzbng zzd(zzbnb zzbnbVar, zzdxp<zzbnk> zzdxpVar) {
        return new zzbng(zzbnbVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfgt.get(), zzazd.zzdwj), "Cannot return null from a non-@Nullable @Provides method");
    }
}
