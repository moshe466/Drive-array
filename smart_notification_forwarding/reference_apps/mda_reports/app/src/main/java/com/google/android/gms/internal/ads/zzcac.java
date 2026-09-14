package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcac implements zzdxg<zzbzz> {
    private final zzdxp<String> zzfhl;
    private final zzdxp<zzbws> zzfkx;
    private final zzdxp<zzbwk> zzfqc;

    private zzcac(zzdxp<String> zzdxpVar, zzdxp<zzbwk> zzdxpVar2, zzdxp<zzbws> zzdxpVar3) {
        this.zzfhl = zzdxpVar;
        this.zzfqc = zzdxpVar2;
        this.zzfkx = zzdxpVar3;
    }

    public static zzcac zzi(zzdxp<String> zzdxpVar, zzdxp<zzbwk> zzdxpVar2, zzdxp<zzbws> zzdxpVar3) {
        return new zzcac(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbzz(this.zzfhl.get(), this.zzfqc.get(), this.zzfkx.get());
    }
}
