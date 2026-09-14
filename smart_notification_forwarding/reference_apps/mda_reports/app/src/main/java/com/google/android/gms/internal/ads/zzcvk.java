package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcvk implements zzdxg<zzcvi> {
    private final zzdxp<zzauw> zzeqj;
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<String> zzfrr;

    public zzcvk(zzdxp<zzauw> zzdxpVar, zzdxp<zzdhd> zzdxpVar2, zzdxp<String> zzdxpVar3) {
        this.zzeqj = zzdxpVar;
        this.zzfcv = zzdxpVar2;
        this.zzfrr = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcvi(this.zzeqj.get(), this.zzfcv.get(), this.zzfrr.get());
    }
}
