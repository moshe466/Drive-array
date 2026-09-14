package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbkw implements zzdxg<zzbkk> {
    private final zzdxp<zzbkm> zzexx;
    private final zzbkn zzfen;

    public zzbkw(zzbkn zzbknVar, zzdxp<zzbkm> zzdxpVar) {
        this.zzfen = zzbknVar;
        this.zzexx = zzdxpVar;
    }

    public static zzbkk zza(zzbkn zzbknVar, Object obj) {
        return (zzbkk) zzdxm.zza((zzbkm) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzfen, this.zzexx.get());
    }
}
