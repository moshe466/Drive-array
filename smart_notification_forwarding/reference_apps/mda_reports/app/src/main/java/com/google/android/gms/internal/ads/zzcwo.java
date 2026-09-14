package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcwo implements zzdxg<zzcwl> {
    private final zzdxp<zzbfx> zzejt;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<Context> zzgiq;
    private final zzdxp<zzcxt<zzbka, zzbke>> zzgir;
    private final zzdxp<zzcwz> zzgis;
    private final zzdxp<zzczw> zzgit;

    public zzcwo(zzdxp<Context> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<zzbfx> zzdxpVar3, zzdxp<zzcxt<zzbka, zzbke>> zzdxpVar4, zzdxp<zzcwz> zzdxpVar5, zzdxp<zzczw> zzdxpVar6) {
        this.zzgiq = zzdxpVar;
        this.zzfei = zzdxpVar2;
        this.zzejt = zzdxpVar3;
        this.zzgir = zzdxpVar4;
        this.zzgis = zzdxpVar5;
        this.zzgit = zzdxpVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcwl(this.zzgiq.get(), this.zzfei.get(), this.zzejt.get(), this.zzgir.get(), this.zzgis.get(), this.zzgit.get());
    }
}
