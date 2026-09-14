package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbod;

/* loaded from: classes.dex */
public final class zzclq implements zzdxg<zzcln> {
    private final zzdxp<zzbfx> zzfkr;
    private final zzdxp<zzbod.zza> zzfks;
    private final zzdxp<zzbrm> zzfkt;

    public zzclq(zzdxp<zzbfx> zzdxpVar, zzdxp<zzbod.zza> zzdxpVar2, zzdxp<zzbrm> zzdxpVar3) {
        this.zzfkr = zzdxpVar;
        this.zzfks = zzdxpVar2;
        this.zzfkt = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcln(this.zzfkr.get(), this.zzfks.get(), this.zzfkt.get());
    }
}
