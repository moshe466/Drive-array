package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzccb implements zzdxg<zzcbn> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzbqp> zzfeq;
    private final zzdxp<zzdq> zzfky;
    private final zzdxp<zzsm> zzfpq;
    private final zzdxp<zzbdr> zzfqw;
    private final zzdxp<com.google.android.gms.ads.internal.zza> zzfrl;
    private final zzdxp<zzbts> zzfrm;

    private zzccb(zzdxp<zzbdr> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<zzczu> zzdxpVar3, zzdxp<zzdq> zzdxpVar4, zzdxp<zzazb> zzdxpVar5, zzdxp<com.google.android.gms.ads.internal.zza> zzdxpVar6, zzdxp<zzsm> zzdxpVar7, zzdxp<zzbqp> zzdxpVar8, zzdxp<zzbts> zzdxpVar9) {
        this.zzfqw = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfep = zzdxpVar3;
        this.zzfky = zzdxpVar4;
        this.zzfav = zzdxpVar5;
        this.zzfrl = zzdxpVar6;
        this.zzfpq = zzdxpVar7;
        this.zzfeq = zzdxpVar8;
        this.zzfrm = zzdxpVar9;
    }

    public static zzccb zzb(zzdxp<zzbdr> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<zzczu> zzdxpVar3, zzdxp<zzdq> zzdxpVar4, zzdxp<zzazb> zzdxpVar5, zzdxp<com.google.android.gms.ads.internal.zza> zzdxpVar6, zzdxp<zzsm> zzdxpVar7, zzdxp<zzbqp> zzdxpVar8, zzdxp<zzbts> zzdxpVar9) {
        return new zzccb(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5, zzdxpVar6, zzdxpVar7, zzdxpVar8, zzdxpVar9);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcbn(this.zzfqw.get(), this.zzejv.get(), this.zzfep.get(), this.zzfky.get(), this.zzfav.get(), this.zzfrl.get(), this.zzfpq.get(), this.zzfeq.get(), this.zzfrm.get());
    }
}
