package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzctc implements zzdxg<zzcta> {
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<Bundle> zzggf;

    private zzctc(zzdxp<zzdhd> zzdxpVar, zzdxp<Bundle> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzggf = zzdxpVar2;
    }

    public static zzctc zzas(zzdxp<zzdhd> zzdxpVar, zzdxp<Bundle> zzdxpVar2) {
        return new zzctc(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcta(this.zzfcv.get(), this.zzggf.get());
    }
}
