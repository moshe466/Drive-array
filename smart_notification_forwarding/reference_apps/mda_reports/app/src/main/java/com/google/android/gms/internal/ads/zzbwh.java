package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbwh implements zzdxg<zzbwi> {
    private final zzdxp<zzbws> zzfkx;

    private zzbwh(zzdxp<zzbws> zzdxpVar) {
        this.zzfkx = zzdxpVar;
    }

    public static zzbwh zzw(zzdxp<zzbws> zzdxpVar) {
        return new zzbwh(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbwi(this.zzfkx.get());
    }
}
