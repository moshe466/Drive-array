package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcnm implements zzdxg<zzcng> {
    private final zzdxp<zzdhd> zzfei;
    private final zzdxp<zzdcr> zzfet;
    private final zzdxp<zzblg> zzfyl;
    private final zzdxp<Context> zzgbs;
    private final zzdxp<zzaak> zzgbt;

    public zzcnm(zzdxp<Context> zzdxpVar, zzdxp<zzblg> zzdxpVar2, zzdxp<zzdcr> zzdxpVar3, zzdxp<zzdhd> zzdxpVar4, zzdxp<zzaak> zzdxpVar5) {
        this.zzgbs = zzdxpVar;
        this.zzfyl = zzdxpVar2;
        this.zzfet = zzdxpVar3;
        this.zzfei = zzdxpVar4;
        this.zzgbt = zzdxpVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcng(this.zzgbs.get(), this.zzfyl.get(), this.zzfet.get(), this.zzfei.get(), this.zzgbt.get());
    }
}
