package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcqx implements zzdxg<zzcqv> {
    private final zzdxp<zzbnk> zzema;
    private final zzdxp<zzdak> zzenk;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<String> zzgfg;
    private final zzdxp<String> zzgfh;

    private zzcqx(zzdxp<String> zzdxpVar, zzdxp<String> zzdxpVar2, zzdxp<zzbnk> zzdxpVar3, zzdxp<zzdak> zzdxpVar4, zzdxp<zzczu> zzdxpVar5) {
        this.zzgfg = zzdxpVar;
        this.zzgfh = zzdxpVar2;
        this.zzema = zzdxpVar3;
        this.zzenk = zzdxpVar4;
        this.zzfep = zzdxpVar5;
    }

    public static zzcqx zzf(zzdxp<String> zzdxpVar, zzdxp<String> zzdxpVar2, zzdxp<zzbnk> zzdxpVar3, zzdxp<zzdak> zzdxpVar4, zzdxp<zzczu> zzdxpVar5) {
        return new zzcqx(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcqv(this.zzgfg.get(), this.zzgfh.get(), this.zzema.get(), this.zzenk.get(), this.zzfep.get());
    }
}
