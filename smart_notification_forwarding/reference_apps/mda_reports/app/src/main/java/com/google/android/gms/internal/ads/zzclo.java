package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbod;

/* loaded from: classes.dex */
public final class zzclo implements zzdxg<zzcll> {
    private final zzdxp<zzbfx> zzfkr;
    private final zzdxp<zzbod.zza> zzfks;
    private final zzdxp<zzbrm> zzfkt;
    private final zzdxp<zzcns> zzgab;

    public zzclo(zzdxp<zzbfx> zzdxpVar, zzdxp<zzbod.zza> zzdxpVar2, zzdxp<zzcns> zzdxpVar3, zzdxp<zzbrm> zzdxpVar4) {
        this.zzfkr = zzdxpVar;
        this.zzfks = zzdxpVar2;
        this.zzgab = zzdxpVar3;
        this.zzfkt = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcll(this.zzfkr.get(), this.zzfks.get(), this.zzgab.get(), this.zzfkt.get());
    }
}
