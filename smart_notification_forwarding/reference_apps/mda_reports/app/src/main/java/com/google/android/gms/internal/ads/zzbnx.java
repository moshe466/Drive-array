package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbnx implements zzdxg<zzbsu<zzbqx>> {
    private final zzdxp<zzbnw> zzfdd;
    private final zzbny zzfhc;

    private zzbnx(zzbny zzbnyVar, zzdxp<zzbnw> zzdxpVar) {
        this.zzfhc = zzbnyVar;
        this.zzfdd = zzdxpVar;
    }

    public static zzbnx zza(zzbny zzbnyVar, zzdxp<zzbnw> zzdxpVar) {
        return new zzbnx(zzbnyVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdd.get(), zzazd.zzdwj), "Cannot return null from a non-@Nullable @Provides method");
    }
}
