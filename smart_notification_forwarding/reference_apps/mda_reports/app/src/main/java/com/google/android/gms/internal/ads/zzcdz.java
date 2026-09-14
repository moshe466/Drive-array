package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcdz implements zzdxg<zzcea> {
    private final zzdxp<String> zzfta;
    private final zzdxp<zzcdv> zzftb;

    public zzcdz(zzdxp<String> zzdxpVar, zzdxp<zzcdv> zzdxpVar2) {
        this.zzfta = zzdxpVar;
        this.zzftb = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcea(this.zzfta.get(), this.zzftb.get());
    }
}
