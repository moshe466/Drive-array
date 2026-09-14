package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* loaded from: classes.dex */
public final class zzcsq implements zzdxg<zzcsn> {
    private final zzdxp<zzavu> zzemi;
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<PackageInfo> zzfur;

    public zzcsq(zzdxp<zzdhd> zzdxpVar, zzdxp<zzczu> zzdxpVar2, zzdxp<PackageInfo> zzdxpVar3, zzdxp<zzavu> zzdxpVar4) {
        this.zzfcv = zzdxpVar;
        this.zzfep = zzdxpVar2;
        this.zzfur = zzdxpVar3;
        this.zzemi = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcsn(this.zzfcv.get(), this.zzfep.get(), this.zzfur.get(), this.zzemi.get());
    }
}
