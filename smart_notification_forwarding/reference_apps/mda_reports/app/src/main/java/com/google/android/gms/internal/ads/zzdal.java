package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdal implements zzdxg<zzbsu<zzbow>> {
    private final zzdxp<zzdak> zzfgt;
    private final zzdai zzgnc;

    private zzdal(zzdai zzdaiVar, zzdxp<zzdak> zzdxpVar) {
        this.zzgnc = zzdaiVar;
        this.zzfgt = zzdxpVar;
    }

    public static zzdal zza(zzdai zzdaiVar, zzdxp<zzdak> zzdxpVar) {
        return new zzdal(zzdaiVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfgt.get(), zzazd.zzdwj), "Cannot return null from a non-@Nullable @Provides method");
    }
}
