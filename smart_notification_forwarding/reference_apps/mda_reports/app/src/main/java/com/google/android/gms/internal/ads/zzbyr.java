package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbyr implements zzdxg<zzbyq> {
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<zzbyu> zzfoy;
    private final zzdxp<zzbze> zzfoz;

    public zzbyr(zzdxp<zzdhd> zzdxpVar, zzdxp<zzbyu> zzdxpVar2, zzdxp<zzbze> zzdxpVar3) {
        this.zzfcv = zzdxpVar;
        this.zzfoy = zzdxpVar2;
        this.zzfoz = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbyq(this.zzfcv.get(), this.zzfoy.get(), this.zzfoz.get());
    }
}
