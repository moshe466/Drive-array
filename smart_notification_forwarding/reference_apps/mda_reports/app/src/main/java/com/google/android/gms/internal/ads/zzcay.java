package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcay implements zzdxg<zzcat> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzazb> zzfhn;
    private final zzdxp<zzdq> zzfky;
    private final zzdxp<com.google.android.gms.ads.internal.zza> zzfpp;
    private final zzdxp<zzbdr> zzfqw;

    public zzcay(zzdxp<Context> zzdxpVar, zzdxp<Executor> zzdxpVar2, zzdxp<zzdq> zzdxpVar3, zzdxp<zzazb> zzdxpVar4, zzdxp<com.google.android.gms.ads.internal.zza> zzdxpVar5, zzdxp<zzbdr> zzdxpVar6) {
        this.zzejv = zzdxpVar;
        this.zzfei = zzdxpVar2;
        this.zzfky = zzdxpVar3;
        this.zzfhn = zzdxpVar4;
        this.zzfpp = zzdxpVar5;
        this.zzfqw = zzdxpVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcat(this.zzejv.get(), this.zzfei.get(), this.zzfky.get(), this.zzfhn.get(), this.zzfpp.get(), this.zzfqw.get());
    }
}
