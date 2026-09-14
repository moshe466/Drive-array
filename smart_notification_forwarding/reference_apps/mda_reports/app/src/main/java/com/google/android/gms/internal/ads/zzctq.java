package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzctq implements zzdxg<zzcto> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzatv> zzfay;
    private final zzdxp<zzdhd> zzfcv;

    private zzctq(zzdxp<zzatv> zzdxpVar, zzdxp<zzdhd> zzdxpVar2, zzdxp<Context> zzdxpVar3) {
        this.zzfay = zzdxpVar;
        this.zzfcv = zzdxpVar2;
        this.zzejv = zzdxpVar3;
    }

    public static zzctq zzp(zzdxp<zzatv> zzdxpVar, zzdxp<zzdhd> zzdxpVar2, zzdxp<Context> zzdxpVar3) {
        return new zzctq(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcto(this.zzfay.get(), this.zzfcv.get(), this.zzejv.get());
    }
}
