package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbxn implements zzdxg<zzbxj> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzavu> zzemi;
    private final zzdxp<zzbww> zzeti;
    private final zzdxp<zzbxr> zzetj;
    private final zzdxp<zzbwq> zzetl;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzbws> zzfkx;

    private zzbxn(zzdxp<Context> zzdxpVar, zzdxp<zzavu> zzdxpVar2, zzdxp<zzczu> zzdxpVar3, zzdxp<zzbww> zzdxpVar4, zzdxp<zzbws> zzdxpVar5, zzdxp<zzbxr> zzdxpVar6, zzdxp<Executor> zzdxpVar7, zzdxp<Executor> zzdxpVar8, zzdxp<zzbwq> zzdxpVar9) {
        this.zzejv = zzdxpVar;
        this.zzemi = zzdxpVar2;
        this.zzfep = zzdxpVar3;
        this.zzeti = zzdxpVar4;
        this.zzfkx = zzdxpVar5;
        this.zzetj = zzdxpVar6;
        this.zzfei = zzdxpVar7;
        this.zzfcv = zzdxpVar8;
        this.zzetl = zzdxpVar9;
    }

    public static zzbxn zza(zzdxp<Context> zzdxpVar, zzdxp<zzavu> zzdxpVar2, zzdxp<zzczu> zzdxpVar3, zzdxp<zzbww> zzdxpVar4, zzdxp<zzbws> zzdxpVar5, zzdxp<zzbxr> zzdxpVar6, zzdxp<Executor> zzdxpVar7, zzdxp<Executor> zzdxpVar8, zzdxp<zzbwq> zzdxpVar9) {
        return new zzbxn(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5, zzdxpVar6, zzdxpVar7, zzdxpVar8, zzdxpVar9);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbxj(this.zzejv.get(), this.zzemi.get(), this.zzfep.get(), this.zzeti.get(), this.zzfkx.get(), this.zzetj.get(), this.zzfei.get(), this.zzfcv.get(), this.zzetl.get());
    }
}
