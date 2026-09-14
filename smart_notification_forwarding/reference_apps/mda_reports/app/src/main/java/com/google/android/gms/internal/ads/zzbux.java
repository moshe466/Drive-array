package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbux implements zzdxg<zzbuy> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<Integer> zzfdc;
    private final zzdxp<zzbdi> zzfef;
    private final zzdxp<zzczl> zzffb;

    private zzbux(zzdxp<Context> zzdxpVar, zzdxp<zzbdi> zzdxpVar2, zzdxp<zzczl> zzdxpVar3, zzdxp<zzazb> zzdxpVar4, zzdxp<Integer> zzdxpVar5) {
        this.zzejv = zzdxpVar;
        this.zzfef = zzdxpVar2;
        this.zzffb = zzdxpVar3;
        this.zzfav = zzdxpVar4;
        this.zzfdc = zzdxpVar5;
    }

    public static zzbux zzc(zzdxp<Context> zzdxpVar, zzdxp<zzbdi> zzdxpVar2, zzdxp<zzczl> zzdxpVar3, zzdxp<zzazb> zzdxpVar4, zzdxp<Integer> zzdxpVar5) {
        return new zzbux(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbuy(this.zzejv.get(), this.zzfef.get(), this.zzffb.get(), this.zzfav.get(), this.zzfdc.get().intValue());
    }
}
