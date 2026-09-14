package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcia implements zzdxg<zzchx> {
    private final zzdxp<zzcid> zzfxj;

    private zzcia(zzdxp<zzcid> zzdxpVar) {
        this.zzfxj = zzdxpVar;
    }

    public static zzcia zzad(zzdxp<zzcid> zzdxpVar) {
        return new zzcia(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzchx(this.zzfxj.get());
    }
}
