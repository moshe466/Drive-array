package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public final class zzbvd implements zzdxg<zzbve> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzatv> zzfay;
    private final zzdxp<View> zzfbq;
    private final zzdxp<Integer> zzfdc;
    private final zzdxp<zzats> zzffn;

    private zzbvd(zzdxp<zzats> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<zzatv> zzdxpVar3, zzdxp<View> zzdxpVar4, zzdxp<Integer> zzdxpVar5) {
        this.zzffn = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfay = zzdxpVar3;
        this.zzfbq = zzdxpVar4;
        this.zzfdc = zzdxpVar5;
    }

    public static zzbvd zzd(zzdxp<zzats> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<zzatv> zzdxpVar3, zzdxp<View> zzdxpVar4, zzdxp<Integer> zzdxpVar5) {
        return new zzbvd(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbve(this.zzffn.get(), this.zzejv.get(), this.zzfay.get(), this.zzfbq.get(), this.zzfdc.get().intValue());
    }
}
