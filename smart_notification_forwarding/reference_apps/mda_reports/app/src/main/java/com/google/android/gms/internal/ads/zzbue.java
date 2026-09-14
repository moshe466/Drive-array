package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbue implements zzdxg<zzbsu<zzbqb>> {
    private final zzdxp<zzbuy> zzfdq;
    private final zzbtv zzfje;

    private zzbue(zzbtv zzbtvVar, zzdxp<zzbuy> zzdxpVar) {
        this.zzfje = zzbtvVar;
        this.zzfdq = zzdxpVar;
    }

    public static zzbue zzc(zzbtv zzbtvVar, zzdxp<zzbuy> zzdxpVar) {
        return new zzbue(zzbtvVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), zzazd.zzdwi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
