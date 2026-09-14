package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbwn implements zzdxg<zzbwk> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzbmg> zzetc;
    private final zzdxp<zzbxa> zzeth;
    private final zzdxp<zzbww> zzeti;
    private final zzdxp<zzbwq> zzetl;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzbwz> zzfeh;
    private final zzdxp<zzats> zzffn;
    private final zzdxp<zzbws> zzfkx;
    private final zzdxp<zzdq> zzfky;
    private final zzdxp<zzbxj> zzfls;
    private final zzdxp<zzcab> zzflt;
    private final zzdxp<zzbzz> zzflu;
    private final zzdxp<zzcai> zzflv;
    private final zzdxp<zzbzv> zzflw;
    private final zzdxp<zzcad> zzflx;

    private zzbwn(zzdxp<zzbmg> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<zzbws> zzdxpVar3, zzdxp<zzbxa> zzdxpVar4, zzdxp<zzbxj> zzdxpVar5, zzdxp<zzbww> zzdxpVar6, zzdxp<zzbwz> zzdxpVar7, zzdxp<zzcab> zzdxpVar8, zzdxp<zzbzz> zzdxpVar9, zzdxp<zzcai> zzdxpVar10, zzdxp<zzbzv> zzdxpVar11, zzdxp<zzcad> zzdxpVar12, zzdxp<zzats> zzdxpVar13, zzdxp<zzdq> zzdxpVar14, zzdxp<zzazb> zzdxpVar15, zzdxp<Context> zzdxpVar16, zzdxp<zzbwq> zzdxpVar17) {
        this.zzetc = zzdxpVar;
        this.zzfcv = zzdxpVar2;
        this.zzfkx = zzdxpVar3;
        this.zzeth = zzdxpVar4;
        this.zzfls = zzdxpVar5;
        this.zzeti = zzdxpVar6;
        this.zzfeh = zzdxpVar7;
        this.zzflt = zzdxpVar8;
        this.zzflu = zzdxpVar9;
        this.zzflv = zzdxpVar10;
        this.zzflw = zzdxpVar11;
        this.zzflx = zzdxpVar12;
        this.zzffn = zzdxpVar13;
        this.zzfky = zzdxpVar14;
        this.zzfav = zzdxpVar15;
        this.zzejv = zzdxpVar16;
        this.zzetl = zzdxpVar17;
    }

    public static zzbwn zza(zzdxp<zzbmg> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<zzbws> zzdxpVar3, zzdxp<zzbxa> zzdxpVar4, zzdxp<zzbxj> zzdxpVar5, zzdxp<zzbww> zzdxpVar6, zzdxp<zzbwz> zzdxpVar7, zzdxp<zzcab> zzdxpVar8, zzdxp<zzbzz> zzdxpVar9, zzdxp<zzcai> zzdxpVar10, zzdxp<zzbzv> zzdxpVar11, zzdxp<zzcad> zzdxpVar12, zzdxp<zzats> zzdxpVar13, zzdxp<zzdq> zzdxpVar14, zzdxp<zzazb> zzdxpVar15, zzdxp<Context> zzdxpVar16, zzdxp<zzbwq> zzdxpVar17) {
        return new zzbwn(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5, zzdxpVar6, zzdxpVar7, zzdxpVar8, zzdxpVar9, zzdxpVar10, zzdxpVar11, zzdxpVar12, zzdxpVar13, zzdxpVar14, zzdxpVar15, zzdxpVar16, zzdxpVar17);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbwk(this.zzetc.get(), this.zzfcv.get(), this.zzfkx.get(), this.zzeth.get(), this.zzfls.get(), this.zzeti.get(), this.zzfeh.get(), zzdxd.zzao(this.zzflt), zzdxd.zzao(this.zzflu), zzdxd.zzao(this.zzflv), zzdxd.zzao(this.zzflw), zzdxd.zzao(this.zzflx), this.zzffn.get(), this.zzfky.get(), this.zzfav.get(), this.zzejv.get(), this.zzetl.get());
    }
}
