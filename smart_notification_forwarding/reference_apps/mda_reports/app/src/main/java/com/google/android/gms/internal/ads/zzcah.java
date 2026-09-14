package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcah implements zzdxg<zzcai> {
    private final zzdxp<String> zzfhl;
    private final zzdxp<zzbws> zzfkx;
    private final zzdxp<zzbwk> zzfqc;

    private zzcah(zzdxp<String> zzdxpVar, zzdxp<zzbwk> zzdxpVar2, zzdxp<zzbws> zzdxpVar3) {
        this.zzfhl = zzdxpVar;
        this.zzfqc = zzdxpVar2;
        this.zzfkx = zzdxpVar3;
    }

    public static zzcah zzk(zzdxp<String> zzdxpVar, zzdxp<zzbwk> zzdxpVar2, zzdxp<zzbws> zzdxpVar3) {
        return new zzcah(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcai(this.zzfhl.get(), this.zzfqc.get(), this.zzfkx.get());
    }
}
