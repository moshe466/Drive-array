package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbod;

/* loaded from: classes.dex */
public final class zzclh implements zzdxg<zzcli> {
    private final zzdxp<zzbfx> zzfkr;
    private final zzdxp<zzbod.zza> zzfks;
    private final zzdxp<zzbrm> zzfkt;
    private final zzdxp<zzbvi> zzfku;

    public zzclh(zzdxp<zzbfx> zzdxpVar, zzdxp<zzbvi> zzdxpVar2, zzdxp<zzbod.zza> zzdxpVar3, zzdxp<zzbrm> zzdxpVar4) {
        this.zzfkr = zzdxpVar;
        this.zzfku = zzdxpVar2;
        this.zzfks = zzdxpVar3;
        this.zzfkt = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcli(this.zzfkr.get(), this.zzfku.get(), this.zzfks.get(), this.zzfkt.get());
    }
}
