package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcnp<AdT> implements zzdxg<zzcnl<AdT>> {
    private final zzdxp<zzdhd> zzfei;
    private final zzdxp<zzdcr> zzfet;
    private final zzdxp<zzaak> zzgbt;
    private final zzdxp<zzcnq<AdT>> zzgby;

    public zzcnp(zzdxp<zzdcr> zzdxpVar, zzdxp<zzdhd> zzdxpVar2, zzdxp<zzaak> zzdxpVar3, zzdxp<zzcnq<AdT>> zzdxpVar4) {
        this.zzfet = zzdxpVar;
        this.zzfei = zzdxpVar2;
        this.zzgbt = zzdxpVar3;
        this.zzgby = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcnl(this.zzfet.get(), this.zzfei.get(), this.zzgbt.get(), this.zzgby.get());
    }
}
