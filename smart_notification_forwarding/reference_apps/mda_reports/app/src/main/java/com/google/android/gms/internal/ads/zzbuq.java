package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbuq implements zzdxg<zzbun> {
    private final zzdxp<zzbqj> zzesu;
    private final zzdxp<zzbsq> zzeys;

    private zzbuq(zzdxp<zzbqj> zzdxpVar, zzdxp<zzbsq> zzdxpVar2) {
        this.zzesu = zzdxpVar;
        this.zzeys = zzdxpVar2;
    }

    public static zzbuq zzj(zzdxp<zzbqj> zzdxpVar, zzdxp<zzbsq> zzdxpVar2) {
        return new zzbuq(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbun(this.zzesu.get(), this.zzeys.get());
    }
}
