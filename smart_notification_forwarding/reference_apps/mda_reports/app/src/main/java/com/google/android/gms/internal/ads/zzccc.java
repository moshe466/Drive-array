package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzccc implements zzdxg<zzcbp> {
    private final zzdxp<zzbra> zzerj;
    private final zzdxp<zzbqa> zzerq;
    private final zzdxp<zzbpm> zzesd;
    private final zzdxp<zzboq> zzesg;
    private final zzdxp<zzbqj> zzesu;
    private final zzdxp<zzbjd> zzeue;
    private final zzdxp<zzbst> zzeun;
    private final zzdxp<zzbqw> zzevv;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzato> zzfgz;
    private final zzdxp<zzdq> zzfky;
    private final zzdxp<com.google.android.gms.ads.internal.zzc> zzfrn;
    private final zzdxp<zzbpg> zzfro;

    private zzccc(zzdxp<zzboq> zzdxpVar, zzdxp<zzbpm> zzdxpVar2, zzdxp<zzbqa> zzdxpVar3, zzdxp<zzbqj> zzdxpVar4, zzdxp<zzbra> zzdxpVar5, zzdxp<Executor> zzdxpVar6, zzdxp<zzbst> zzdxpVar7, zzdxp<zzbjd> zzdxpVar8, zzdxp<com.google.android.gms.ads.internal.zzc> zzdxpVar9, zzdxp<zzbpg> zzdxpVar10, zzdxp<zzato> zzdxpVar11, zzdxp<zzdq> zzdxpVar12, zzdxp<zzbqw> zzdxpVar13) {
        this.zzesg = zzdxpVar;
        this.zzesd = zzdxpVar2;
        this.zzerq = zzdxpVar3;
        this.zzesu = zzdxpVar4;
        this.zzerj = zzdxpVar5;
        this.zzfcv = zzdxpVar6;
        this.zzeun = zzdxpVar7;
        this.zzeue = zzdxpVar8;
        this.zzfrn = zzdxpVar9;
        this.zzfro = zzdxpVar10;
        this.zzfgz = zzdxpVar11;
        this.zzfky = zzdxpVar12;
        this.zzevv = zzdxpVar13;
    }

    public static zzccc zza(zzdxp<zzboq> zzdxpVar, zzdxp<zzbpm> zzdxpVar2, zzdxp<zzbqa> zzdxpVar3, zzdxp<zzbqj> zzdxpVar4, zzdxp<zzbra> zzdxpVar5, zzdxp<Executor> zzdxpVar6, zzdxp<zzbst> zzdxpVar7, zzdxp<zzbjd> zzdxpVar8, zzdxp<com.google.android.gms.ads.internal.zzc> zzdxpVar9, zzdxp<zzbpg> zzdxpVar10, zzdxp<zzato> zzdxpVar11, zzdxp<zzdq> zzdxpVar12, zzdxp<zzbqw> zzdxpVar13) {
        return new zzccc(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5, zzdxpVar6, zzdxpVar7, zzdxpVar8, zzdxpVar9, zzdxpVar10, zzdxpVar11, zzdxpVar12, zzdxpVar13);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcbp(this.zzesg.get(), this.zzesd.get(), this.zzerq.get(), this.zzesu.get(), this.zzerj.get(), this.zzfcv.get(), this.zzeun.get(), this.zzeue.get(), this.zzfrn.get(), this.zzfro.get(), this.zzfgz.get(), this.zzfky.get(), this.zzevv.get());
    }
}
