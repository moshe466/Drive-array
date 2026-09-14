package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbhy implements zzdxg<zzbht> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzcka> zzeke;
    private final zzdxp<zzceq> zzekp;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<zzcis<zzdac, zzcjx>> zzfaw;
    private final zzdxp<zzcob> zzfax;
    private final zzdxp<zzatv> zzfay;

    public zzbhy(zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<zzcka> zzdxpVar3, zzdxp<zzcis<zzdac, zzcjx>> zzdxpVar4, zzdxp<zzcob> zzdxpVar5, zzdxp<zzceq> zzdxpVar6, zzdxp<zzatv> zzdxpVar7) {
        this.zzejv = zzdxpVar;
        this.zzfav = zzdxpVar2;
        this.zzeke = zzdxpVar3;
        this.zzfaw = zzdxpVar4;
        this.zzfax = zzdxpVar5;
        this.zzekp = zzdxpVar6;
        this.zzfay = zzdxpVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbht(this.zzejv.get(), this.zzfav.get(), this.zzeke.get(), this.zzfaw.get(), this.zzfax.get(), this.zzekp.get(), this.zzfay.get());
    }
}
