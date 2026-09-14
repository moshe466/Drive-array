package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbkt implements zzdxg<zzbme> {
    private final zzbkn zzfen;

    public zzbkt(zzbkn zzbknVar) {
        this.zzfen = zzbknVar;
    }

    public static zzbme zzb(zzbkn zzbknVar) {
        return (zzbme) zzdxm.zza(zzbknVar.zzagh(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzb(this.zzfen);
    }
}
