package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbtb implements zzdxg<zzbtc> {
    private final zzdxp<zzdda> zzepi;
    private final zzdxp<zzczl> zzfbp;

    private zzbtb(zzdxp<zzczl> zzdxpVar, zzdxp<zzdda> zzdxpVar2) {
        this.zzfbp = zzdxpVar;
        this.zzepi = zzdxpVar2;
    }

    public static zzbtb zzi(zzdxp<zzczl> zzdxpVar, zzdxp<zzdda> zzdxpVar2) {
        return new zzbtb(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbtc(this.zzfbp.get(), this.zzepi.get());
    }
}
