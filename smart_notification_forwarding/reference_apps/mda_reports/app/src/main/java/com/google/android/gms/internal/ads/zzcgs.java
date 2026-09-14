package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcgs implements zzdxg<zzcgp> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzatv> zzfay;

    private zzcgs(zzdxp<Context> zzdxpVar, zzdxp<zzatv> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzfay = zzdxpVar2;
    }

    public static zzcgs zzaf(zzdxp<Context> zzdxpVar, zzdxp<zzatv> zzdxpVar2) {
        return new zzcgs(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcgp(this.zzejv.get(), this.zzfay.get());
    }
}
