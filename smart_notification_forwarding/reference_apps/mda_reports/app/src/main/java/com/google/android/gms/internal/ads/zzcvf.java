package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcvf implements zzdxg<zzcvd> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzsa> zzeqj;
    private final zzdxp<zzdhd> zzfcv;

    public zzcvf(zzdxp<zzsa> zzdxpVar, zzdxp<zzdhd> zzdxpVar2, zzdxp<Context> zzdxpVar3) {
        this.zzeqj = zzdxpVar;
        this.zzfcv = zzdxpVar2;
        this.zzejv = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcvd(this.zzeqj.get(), this.zzfcv.get(), this.zzejv.get());
    }
}
