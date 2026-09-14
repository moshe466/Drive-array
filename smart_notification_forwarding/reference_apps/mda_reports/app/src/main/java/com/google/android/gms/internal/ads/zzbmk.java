package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
public final class zzbmk<AdT> implements zzdxg<zzbmh<AdT>> {
    private final zzdxp<Map<String, zzcio<AdT>>> zzffv;

    private zzbmk(zzdxp<Map<String, zzcio<AdT>>> zzdxpVar) {
        this.zzffv = zzdxpVar;
    }

    public static <AdT> zzbmk<AdT> zzd(zzdxp<Map<String, zzcio<AdT>>> zzdxpVar) {
        return new zzbmk<>(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbmh(this.zzffv.get());
    }
}
