package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbwg implements zzdxg<zzbsu<zzbpe>> {
    private final zzdxp<zzbyc> zzfdq;
    private final zzbvy zzfla;

    public zzbwg(zzbvy zzbvyVar, zzdxp<zzbyc> zzdxpVar) {
        this.zzfla = zzbvyVar;
        this.zzfdq = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), zzazd.zzdwj), "Cannot return null from a non-@Nullable @Provides method");
    }
}
