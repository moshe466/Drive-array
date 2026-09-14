package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcqj implements zzdxg<zzcqh> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzcrk<zzcue>> zzeky;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzave> zzgev;

    private zzcqj(zzdxp<zzcrk<zzcue>> zzdxpVar, zzdxp<zzczu> zzdxpVar2, zzdxp<Context> zzdxpVar3, zzdxp<zzave> zzdxpVar4) {
        this.zzeky = zzdxpVar;
        this.zzfep = zzdxpVar2;
        this.zzejv = zzdxpVar3;
        this.zzgev = zzdxpVar4;
    }

    public static zzcqj zze(zzdxp<zzcrk<zzcue>> zzdxpVar, zzdxp<zzczu> zzdxpVar2, zzdxp<Context> zzdxpVar3, zzdxp<zzave> zzdxpVar4) {
        return new zzcqj(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcqh(this.zzeky.get(), this.zzfep.get(), this.zzejv.get(), this.zzgev.get());
    }
}
