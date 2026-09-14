package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcsl implements zzdxg<zzcsj> {
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<zzczj> zzfza;

    private zzcsl(zzdxp<zzdhd> zzdxpVar, zzdxp<zzczj> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzfza = zzdxpVar2;
    }

    public static zzcsl zzaq(zzdxp<zzdhd> zzdxpVar, zzdxp<zzczj> zzdxpVar2) {
        return new zzcsl(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcsj(this.zzfcv.get(), this.zzfza.get());
    }
}
