package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcrz implements zzdxg<zzcrx> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdhd> zzfcv;

    private zzcrz(zzdxp<Context> zzdxpVar, zzdxp<zzdhd> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzcrz zzap(zzdxp<Context> zzdxpVar, zzdxp<zzdhd> zzdxpVar2) {
        return new zzcrz(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcrx(this.zzejv.get(), this.zzfcv.get());
    }
}
