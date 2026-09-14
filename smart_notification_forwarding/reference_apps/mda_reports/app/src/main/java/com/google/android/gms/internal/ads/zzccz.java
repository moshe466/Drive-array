package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzccz implements zzdxg<zzccw> {
    private final zzdxp<zzcxw> zzemf;
    private final zzdxp<zzsm> zzfsb;

    private zzccz(zzdxp<zzsm> zzdxpVar, zzdxp<zzcxw> zzdxpVar2) {
        this.zzfsb = zzdxpVar;
        this.zzemf = zzdxpVar2;
    }

    public static zzccz zzt(zzdxp<zzsm> zzdxpVar, zzdxp<zzcxw> zzdxpVar2) {
        return new zzccz(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzccw(this.zzfsb.get(), this.zzemf.get());
    }
}
