package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcsd implements zzdxg<zzcsb> {
    private final zzdxp<zzdhd> zzfcv;

    private zzcsd(zzdxp<zzdhd> zzdxpVar) {
        this.zzfcv = zzdxpVar;
    }

    public static zzcsd zzaj(zzdxp<zzdhd> zzdxpVar) {
        return new zzcsd(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcsb(this.zzfcv.get());
    }
}
