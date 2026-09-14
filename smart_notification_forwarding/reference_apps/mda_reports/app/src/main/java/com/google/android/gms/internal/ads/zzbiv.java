package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public final class zzbiv implements zzdxg<zzbiw> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdda> zzepi;
    private final zzdxp<zzczt> zzfbo;
    private final zzdxp<zzczl> zzfbp;
    private final zzdxp<View> zzfbq;
    private final zzdxp<zzdq> zzfbr;

    private zzbiv(zzdxp<Context> zzdxpVar, zzdxp<zzczt> zzdxpVar2, zzdxp<zzczl> zzdxpVar3, zzdxp<zzdda> zzdxpVar4, zzdxp<View> zzdxpVar5, zzdxp<zzdq> zzdxpVar6) {
        this.zzejv = zzdxpVar;
        this.zzfbo = zzdxpVar2;
        this.zzfbp = zzdxpVar3;
        this.zzepi = zzdxpVar4;
        this.zzfbq = zzdxpVar5;
        this.zzfbr = zzdxpVar6;
    }

    public static zzbiv zza(zzdxp<Context> zzdxpVar, zzdxp<zzczt> zzdxpVar2, zzdxp<zzczl> zzdxpVar3, zzdxp<zzdda> zzdxpVar4, zzdxp<View> zzdxpVar5, zzdxp<zzdq> zzdxpVar6) {
        return new zzbiv(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5, zzdxpVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbiw(this.zzejv.get(), this.zzfbo.get(), this.zzfbp.get(), this.zzepi.get(), this.zzfbq.get(), this.zzfbr.get());
    }
}
