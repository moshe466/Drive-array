package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcvb implements zzdxg<zzcuz> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzaqr> zzeqj;
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<String> zzfrr;

    public zzcvb(zzdxp<zzaqr> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<String> zzdxpVar3, zzdxp<zzdhd> zzdxpVar4) {
        this.zzeqj = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfrr = zzdxpVar3;
        this.zzfcv = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcuz(this.zzeqj.get(), this.zzejv.get(), this.zzfrr.get(), this.zzfcv.get());
    }
}
