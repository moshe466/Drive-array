package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbko implements zzdxg<zzbkm> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzbsy> zzesn;
    private final zzdxp<zzbmg> zzetc;
    private final zzdxp<zzcok> zzexw;
    private final zzdxp<View> zzfbq;
    private final zzdxp<zzczk> zzfee;
    private final zzdxp<zzbdi> zzfef;
    private final zzdxp<zzbme> zzfeg;
    private final zzdxp<zzbwz> zzfeh;
    private final zzdxp<Executor> zzfei;

    public zzbko(zzdxp<zzbmg> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<zzczk> zzdxpVar3, zzdxp<View> zzdxpVar4, zzdxp<zzbdi> zzdxpVar5, zzdxp<zzbme> zzdxpVar6, zzdxp<zzbwz> zzdxpVar7, zzdxp<zzbsy> zzdxpVar8, zzdxp<zzcok> zzdxpVar9, zzdxp<Executor> zzdxpVar10) {
        this.zzetc = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfee = zzdxpVar3;
        this.zzfbq = zzdxpVar4;
        this.zzfef = zzdxpVar5;
        this.zzfeg = zzdxpVar6;
        this.zzfeh = zzdxpVar7;
        this.zzesn = zzdxpVar8;
        this.zzexw = zzdxpVar9;
        this.zzfei = zzdxpVar10;
    }

    public static zzbkm zza(zzbmg zzbmgVar, Context context, zzczk zzczkVar, View view, zzbdi zzbdiVar, zzbme zzbmeVar, zzbwz zzbwzVar, zzbsy zzbsyVar, zzdxa<zzcok> zzdxaVar, Executor executor) {
        return new zzbkm(zzbmgVar, context, zzczkVar, view, zzbdiVar, zzbmeVar, zzbwzVar, zzbsyVar, zzdxaVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbkm(this.zzetc.get(), this.zzejv.get(), this.zzfee.get(), this.zzfbq.get(), this.zzfef.get(), this.zzfeg.get(), this.zzfeh.get(), this.zzesn.get(), zzdxd.zzao(this.zzexw), this.zzfei.get());
    }
}
