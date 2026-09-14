package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcen implements zzdxg<zzceo> {
    private final zzdxp<zzbfx> zzejt;
    private final zzdxp<zzcec> zzfsb;

    private zzcen(zzdxp<zzcec> zzdxpVar, zzdxp<zzbfx> zzdxpVar2) {
        this.zzfsb = zzdxpVar;
        this.zzejt = zzdxpVar2;
    }

    public static zzcen zzaa(zzdxp<zzcec> zzdxpVar, zzdxp<zzbfx> zzdxpVar2) {
        return new zzcen(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzceo(this.zzfsb.get(), this.zzejt.get());
    }
}
