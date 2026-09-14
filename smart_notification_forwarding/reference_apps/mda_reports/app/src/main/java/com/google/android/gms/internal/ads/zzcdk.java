package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
public final class zzcdk implements zzdxg<zzcdf> {
    private final zzdxp<zzsm> zzfsb;
    private final zzdxp<Map<zzdco, zzcdh>> zzfso;

    private zzcdk(zzdxp<zzsm> zzdxpVar, zzdxp<Map<zzdco, zzcdh>> zzdxpVar2) {
        this.zzfsb = zzdxpVar;
        this.zzfso = zzdxpVar2;
    }

    public static zzcdk zzu(zzdxp<zzsm> zzdxpVar, zzdxp<Map<zzdco, zzcdh>> zzdxpVar2) {
        return new zzcdk(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcdf(this.zzfsb.get(), this.zzfso.get());
    }
}
