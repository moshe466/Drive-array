package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcqo implements zzdxg<zzcqm> {
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<zzczu> zzfep;

    private zzcqo(zzdxp<zzdhd> zzdxpVar, zzdxp<zzczu> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzfep = zzdxpVar2;
    }

    public static zzcqo zzal(zzdxp<zzdhd> zzdxpVar, zzdxp<zzczu> zzdxpVar2) {
        return new zzcqo(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcqm(this.zzfcv.get(), this.zzfep.get());
    }
}
