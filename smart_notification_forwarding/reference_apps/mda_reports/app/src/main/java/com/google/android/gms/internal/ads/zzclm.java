package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbod;

/* loaded from: classes.dex */
public final class zzclm implements zzdxg<zzclj> {
    private final zzdxp<zzbqp> zzfhe;
    private final zzdxp<zzbfx> zzfkr;
    private final zzdxp<zzbod.zza> zzfks;
    private final zzdxp<zzbrm> zzfkt;
    private final zzdxp<zzbvi> zzfku;
    private final zzdxp<zzcns> zzgab;
    private final zzdxp<ViewGroup> zzgac;

    public zzclm(zzdxp<zzbfx> zzdxpVar, zzdxp<zzbod.zza> zzdxpVar2, zzdxp<zzcns> zzdxpVar3, zzdxp<zzbrm> zzdxpVar4, zzdxp<zzbvi> zzdxpVar5, zzdxp<zzbqp> zzdxpVar6, zzdxp<ViewGroup> zzdxpVar7) {
        this.zzfkr = zzdxpVar;
        this.zzfks = zzdxpVar2;
        this.zzgab = zzdxpVar3;
        this.zzfkt = zzdxpVar4;
        this.zzfku = zzdxpVar5;
        this.zzfhe = zzdxpVar6;
        this.zzgac = zzdxpVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzclj(this.zzfkr.get(), this.zzfks.get(), this.zzgab.get(), this.zzfkt.get(), this.zzfku.get(), this.zzfhe.get(), this.zzgac.get());
    }
}
