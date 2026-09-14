package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcrl implements zzdxg<zzcrj> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdhd> zzfcv;

    public zzcrl(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzejv = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcrj(this.zzfcv.get(), this.zzejv.get());
    }
}
