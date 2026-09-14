package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbla implements zzdxg<zzbsu<zzbqb>> {
    private final zzdxp<zzblw> zzfdq;
    private final zzbkn zzfen;

    public zzbla(zzbkn zzbknVar, zzdxp<zzblw> zzdxpVar) {
        this.zzfen = zzbknVar;
        this.zzfdq = zzdxpVar;
    }

    public static zzbsu<zzbqb> zza(zzbkn zzbknVar, zzblw zzblwVar) {
        return (zzbsu) zzdxm.zza(new zzbsu(zzblwVar, zzazd.zzdwi), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzfen, this.zzfdq.get());
    }
}
