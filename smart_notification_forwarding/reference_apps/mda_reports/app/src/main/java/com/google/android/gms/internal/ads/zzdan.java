package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzdan implements zzdxg<zzdak> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzavp> zzelx;

    private zzdan(zzdxp<Context> zzdxpVar, zzdxp<zzavp> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzelx = zzdxpVar2;
    }

    public static zzdan zzaw(zzdxp<Context> zzdxpVar, zzdxp<zzavp> zzdxpVar2) {
        return new zzdan(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzdak(this.zzejv.get(), this.zzelx.get());
    }
}
