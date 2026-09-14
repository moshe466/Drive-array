package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbud implements zzdxg<zzbsu<com.google.android.gms.ads.internal.overlay.zzo>> {
    private final zzdxp<zzbuy> zzfdq;
    private final zzbtv zzfje;

    private zzbud(zzbtv zzbtvVar, zzdxp<zzbuy> zzdxpVar) {
        this.zzfje = zzbtvVar;
        this.zzfdq = zzdxpVar;
    }

    public static zzbud zzb(zzbtv zzbtvVar, zzdxp<zzbuy> zzdxpVar) {
        return new zzbud(zzbtvVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), zzazd.zzdwi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
