package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
public final class zzbvf implements zzdxg<zzbvg> {
    private final zzdxp<zzbwz> zzfeh;
    private final zzdxp<Map<String, zzcio<zzbmj>>> zzffv;
    private final zzdxp<Map<String, zzcio<zzbwk>>> zzfjq;
    private final zzdxp<Map<String, zzckr<zzbwk>>> zzfjr;
    private final zzdxp<zzbmi<zzbkk>> zzfjs;

    public zzbvf(zzdxp<Map<String, zzcio<zzbmj>>> zzdxpVar, zzdxp<Map<String, zzcio<zzbwk>>> zzdxpVar2, zzdxp<Map<String, zzckr<zzbwk>>> zzdxpVar3, zzdxp<zzbmi<zzbkk>> zzdxpVar4, zzdxp<zzbwz> zzdxpVar5) {
        this.zzffv = zzdxpVar;
        this.zzfjq = zzdxpVar2;
        this.zzfjr = zzdxpVar3;
        this.zzfjs = zzdxpVar4;
        this.zzfeh = zzdxpVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbvg(this.zzffv.get(), this.zzfjq.get(), this.zzfjr.get(), this.zzfjs, this.zzfeh.get());
    }
}
