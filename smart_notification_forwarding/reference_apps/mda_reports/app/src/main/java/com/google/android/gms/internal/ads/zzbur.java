package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbur implements zzdxg<zzbsu<zzbov>> {
    private final zzdxp<zzbsl> zzfdd;

    public zzbur(zzdxp<zzbsl> zzdxpVar) {
        this.zzfdd = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdd.get(), zzazd.zzdwj), "Cannot return null from a non-@Nullable @Provides method");
    }
}
