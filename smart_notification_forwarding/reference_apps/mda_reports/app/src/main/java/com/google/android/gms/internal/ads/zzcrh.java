package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcrh implements zzdxg<zzcrf> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdhd> zzfcv;

    private zzcrh(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzejv = zzdxpVar2;
    }

    public static zzcrh zzan(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2) {
        return new zzcrh(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcrf(this.zzfcv.get(), this.zzejv.get());
    }
}
