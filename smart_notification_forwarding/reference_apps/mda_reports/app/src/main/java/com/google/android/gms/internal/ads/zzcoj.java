package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcoj implements zzdxg<zzcok> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzvh> zzgcn;
    private final zzdxp<zzbkk> zzgco;

    public zzcoj(zzdxp<Context> zzdxpVar, zzdxp<zzvh> zzdxpVar2, zzdxp<zzczu> zzdxpVar3, zzdxp<zzbkk> zzdxpVar4) {
        this.zzejv = zzdxpVar;
        this.zzgcn = zzdxpVar2;
        this.zzfep = zzdxpVar3;
        this.zzgco = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcok(this.zzejv.get(), this.zzgcn.get(), this.zzfep.get(), this.zzgco.get());
    }
}
