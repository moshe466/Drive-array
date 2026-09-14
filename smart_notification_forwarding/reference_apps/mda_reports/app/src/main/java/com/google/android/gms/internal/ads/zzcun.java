package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcun implements zzdxg<zzcul> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdhd> zzfcv;

    private zzcun(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzejv = zzdxpVar2;
    }

    public static zzcun zzav(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2) {
        return new zzcun(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcul(this.zzfcv.get(), this.zzejv.get());
    }
}
