package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzctu implements zzdxg<zzcts> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<zzdhd> zzfcv;

    private zzctu(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<zzazb> zzdxpVar3) {
        this.zzfcv = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfav = zzdxpVar3;
    }

    public static zzctu zzq(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<zzazb> zzdxpVar3) {
        return new zzctu(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcts(this.zzfcv.get(), this.zzejv.get(), this.zzfav.get());
    }
}
