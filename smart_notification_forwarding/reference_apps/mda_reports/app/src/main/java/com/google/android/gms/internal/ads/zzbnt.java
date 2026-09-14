package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbnt implements zzdxg<zzbsu<com.google.android.gms.ads.internal.overlay.zzo>> {
    private final zzdxp<zzbmx> zzfdq;
    private final zzbnu zzfha;

    private zzbnt(zzbnu zzbnuVar, zzdxp<zzbmx> zzdxpVar) {
        this.zzfha = zzbnuVar;
        this.zzfdq = zzdxpVar;
    }

    public static zzbnt zza(zzbnu zzbnuVar, zzdxp<zzbmx> zzdxpVar) {
        return new zzbnt(zzbnuVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), zzazd.zzdwj), "Cannot return null from a non-@Nullable @Provides method");
    }
}
