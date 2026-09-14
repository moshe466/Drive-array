package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzchy implements zzdxg<zzcht> {
    private final zzdxp<zzchr> zzepa;
    private final zzdxp<zzdhd> zzfxb;

    private zzchy(zzdxp<zzchr> zzdxpVar, zzdxp<zzdhd> zzdxpVar2) {
        this.zzepa = zzdxpVar;
        this.zzfxb = zzdxpVar2;
    }

    public static zzchy zzaj(zzdxp<zzchr> zzdxpVar, zzdxp<zzdhd> zzdxpVar2) {
        return new zzchy(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcht(this.zzepa.get(), this.zzfxb.get());
    }
}
