package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcth implements zzdxg<zzctf> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<String> zzelv;

    private zzcth(zzdxp<Context> zzdxpVar, zzdxp<String> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzelv = zzdxpVar2;
    }

    public static zzcth zzat(zzdxp<Context> zzdxpVar, zzdxp<String> zzdxpVar2) {
        return new zzcth(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzctf(this.zzejv.get(), this.zzelv.get());
    }
}
