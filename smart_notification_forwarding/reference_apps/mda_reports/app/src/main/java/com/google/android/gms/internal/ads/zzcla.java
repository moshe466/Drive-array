package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcla implements zzdxg<zzcku> {
    private final zzdxp<zzbyq> zzeqb;
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<zzbvm> zzfyl;

    public zzcla(zzdxp<zzbvm> zzdxpVar, zzdxp<zzdhd> zzdxpVar2, zzdxp<zzbyq> zzdxpVar3) {
        this.zzfyl = zzdxpVar;
        this.zzfcv = zzdxpVar2;
        this.zzeqb = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcku(this.zzfyl.get(), this.zzfcv.get(), this.zzeqb.get());
    }
}
