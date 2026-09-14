package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcrv implements zzdxg<zzcrr> {
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<Context> zzfhb;

    private zzcrv(zzdxp<Context> zzdxpVar, zzdxp<zzdhd> zzdxpVar2) {
        this.zzfhb = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzcrv zzao(zzdxp<Context> zzdxpVar, zzdxp<zzdhd> zzdxpVar2) {
        return new zzcrv(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcrr(this.zzfhb.get(), this.zzfcv.get());
    }
}
