package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbnv implements zzdxg<zzbnw> {
    private final zzdxp<zzceq> zzekp;
    private final zzdxp<zzavu> zzemi;
    private final zzdxp<zzazb> zzfdb;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<Context> zzfhb;

    private zzbnv(zzdxp<Context> zzdxpVar, zzdxp<zzczu> zzdxpVar2, zzdxp<zzazb> zzdxpVar3, zzdxp<zzavu> zzdxpVar4, zzdxp<zzceq> zzdxpVar5) {
        this.zzfhb = zzdxpVar;
        this.zzfep = zzdxpVar2;
        this.zzfdb = zzdxpVar3;
        this.zzemi = zzdxpVar4;
        this.zzekp = zzdxpVar5;
    }

    public static zzbnv zzb(zzdxp<Context> zzdxpVar, zzdxp<zzczu> zzdxpVar2, zzdxp<zzazb> zzdxpVar3, zzdxp<zzavu> zzdxpVar4, zzdxp<zzceq> zzdxpVar5) {
        return new zzbnv(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbnw(this.zzfhb.get(), this.zzfep.get(), this.zzfdb.get(), this.zzemi.get(), this.zzekp.get());
    }
}
