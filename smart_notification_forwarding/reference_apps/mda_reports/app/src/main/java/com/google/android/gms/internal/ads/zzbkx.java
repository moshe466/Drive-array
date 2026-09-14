package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbkx implements zzdxg<zzbsu<zzbpe>> {
    private final zzdxp<zzblw> zzfdq;
    private final zzbkn zzfen;

    public zzbkx(zzbkn zzbknVar, zzdxp<zzblw> zzdxpVar) {
        this.zzfen = zzbknVar;
        this.zzfdq = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), zzazd.zzdwi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
