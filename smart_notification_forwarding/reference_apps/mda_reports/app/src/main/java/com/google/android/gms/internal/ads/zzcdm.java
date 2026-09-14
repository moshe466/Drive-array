package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcdm implements zzdxg<zzcdj> {
    private final zzdxp<zzcdv> zzekn;
    private final zzdxp<zzcds> zzeml;

    private zzcdm(zzdxp<zzcds> zzdxpVar, zzdxp<zzcdv> zzdxpVar2) {
        this.zzeml = zzdxpVar;
        this.zzekn = zzdxpVar2;
    }

    public static zzcdm zzw(zzdxp<zzcds> zzdxpVar, zzdxp<zzcdv> zzdxpVar2) {
        return new zzcdm(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcdj(this.zzeml.get(), this.zzekn.get());
    }
}
