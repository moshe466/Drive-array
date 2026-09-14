package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcaa implements zzdxg<zzbzv> {
    private final zzdxp<zzbws> zzfkx;
    private final zzdxp<zzbwk> zzfqc;

    private zzcaa(zzdxp<zzbwk> zzdxpVar, zzdxp<zzbws> zzdxpVar2) {
        this.zzfqc = zzdxpVar;
        this.zzfkx = zzdxpVar2;
    }

    public static zzcaa zzl(zzdxp<zzbwk> zzdxpVar, zzdxp<zzbws> zzdxpVar2) {
        return new zzcaa(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbzv(this.zzfqc.get(), this.zzfkx.get());
    }
}
