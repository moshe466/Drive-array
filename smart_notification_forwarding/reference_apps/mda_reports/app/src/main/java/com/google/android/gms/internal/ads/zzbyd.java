package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbyd implements zzdxg<zzbye> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzboq> zzesg;
    private final zzdxp<zzbpd> zzesj;
    private final zzdxp<zzalr> zzetf;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzczl> zzffb;
    private final zzdxp<zzall> zzfoi;
    private final zzdxp<zzalq> zzfoj;

    public zzbyd(zzdxp<zzall> zzdxpVar, zzdxp<zzalq> zzdxpVar2, zzdxp<zzalr> zzdxpVar3, zzdxp<zzbpd> zzdxpVar4, zzdxp<zzboq> zzdxpVar5, zzdxp<Context> zzdxpVar6, zzdxp<zzczl> zzdxpVar7, zzdxp<zzazb> zzdxpVar8, zzdxp<zzczu> zzdxpVar9) {
        this.zzfoi = zzdxpVar;
        this.zzfoj = zzdxpVar2;
        this.zzetf = zzdxpVar3;
        this.zzesj = zzdxpVar4;
        this.zzesg = zzdxpVar5;
        this.zzejv = zzdxpVar6;
        this.zzffb = zzdxpVar7;
        this.zzfav = zzdxpVar8;
        this.zzfep = zzdxpVar9;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbye(this.zzfoi.get(), this.zzfoj.get(), this.zzetf.get(), this.zzesj.get(), this.zzesg.get(), this.zzejv.get(), this.zzffb.get(), this.zzfav.get(), this.zzfep.get());
    }
}
