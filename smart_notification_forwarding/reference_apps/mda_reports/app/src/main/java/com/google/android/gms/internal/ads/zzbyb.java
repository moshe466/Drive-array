package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbyb implements zzdxg<zzbyc> {
    private final zzdxp<zzbww> zzeti;
    private final zzdxp<zzbws> zzfkx;

    public zzbyb(zzdxp<zzbws> zzdxpVar, zzdxp<zzbww> zzdxpVar2) {
        this.zzfkx = zzdxpVar;
        this.zzeti = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbyc(this.zzfkx.get(), this.zzeti.get());
    }
}
