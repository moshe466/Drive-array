package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcyw implements zzdxg<zzcyt> {
    private final zzdxp<zzbfx> zzejt;
    private final zzdxp<zzczs> zzezj;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<Context> zzgiq;
    private final zzdxp<zzcxt<zzcbi, zzcbb>> zzgir;
    private final zzdxp<zzcxz> zzgis;
    private final zzdxp<zzczw> zzgit;

    public zzcyw(zzdxp<Context> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<zzbfx> zzdxpVar3, zzdxp<zzcxt<zzcbi, zzcbb>> zzdxpVar4, zzdxp<zzcxz> zzdxpVar5, zzdxp<zzczw> zzdxpVar6, zzdxp<zzczs> zzdxpVar7) {
        this.zzgiq = zzdxpVar;
        this.zzfei = zzdxpVar2;
        this.zzejt = zzdxpVar3;
        this.zzgir = zzdxpVar4;
        this.zzgis = zzdxpVar5;
        this.zzgit = zzdxpVar6;
        this.zzezj = zzdxpVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcyt(this.zzgiq.get(), this.zzfei.get(), this.zzejt.get(), this.zzgir.get(), this.zzgis.get(), this.zzgit.get(), this.zzezj.get());
    }
}
