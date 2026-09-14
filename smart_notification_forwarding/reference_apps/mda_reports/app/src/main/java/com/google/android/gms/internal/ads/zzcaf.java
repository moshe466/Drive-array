package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcaf implements zzdxg<zzcad> {
    private final zzdxp<zzbxj> zzetm;
    private final zzdxp<Context> zzfhb;
    private final zzdxp<zzbws> zzfkx;
    private final zzdxp<zzbwk> zzfqc;

    private zzcaf(zzdxp<Context> zzdxpVar, zzdxp<zzbws> zzdxpVar2, zzdxp<zzbxj> zzdxpVar3, zzdxp<zzbwk> zzdxpVar4) {
        this.zzfhb = zzdxpVar;
        this.zzfkx = zzdxpVar2;
        this.zzetm = zzdxpVar3;
        this.zzfqc = zzdxpVar4;
    }

    public static zzcaf zzb(zzdxp<Context> zzdxpVar, zzdxp<zzbws> zzdxpVar2, zzdxp<zzbxj> zzdxpVar3, zzdxp<zzbwk> zzdxpVar4) {
        return new zzcaf(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcad(this.zzfhb.get(), this.zzfkx.get(), this.zzetm.get(), this.zzfqc.get());
    }
}
