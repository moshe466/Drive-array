package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzblv implements zzdxg<zzblw> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzazb> zzfav;
    private final zzdxp<zzbdi> zzfef;
    private final zzdxp<zzczl> zzffb;

    public zzblv(zzdxp<Context> zzdxpVar, zzdxp<zzbdi> zzdxpVar2, zzdxp<zzczl> zzdxpVar3, zzdxp<zzazb> zzdxpVar4) {
        this.zzejv = zzdxpVar;
        this.zzfef = zzdxpVar2;
        this.zzffb = zzdxpVar3;
        this.zzfav = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzblw(this.zzejv.get(), this.zzfef.get(), this.zzffb.get(), this.zzfav.get());
    }
}
