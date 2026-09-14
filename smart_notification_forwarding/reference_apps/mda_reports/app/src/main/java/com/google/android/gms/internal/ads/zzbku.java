package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbku implements zzdxg<zzczk> {
    private final zzbkn zzfen;

    public zzbku(zzbkn zzbknVar) {
        this.zzfen = zzbknVar;
    }

    public static zzczk zzc(zzbkn zzbknVar) {
        return (zzczk) zzdxm.zza(zzbknVar.zzagi(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzc(this.zzfen);
    }
}
