package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzctm implements zzdxg<zzctj> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzcob> zzeki;
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<String> zzfdc;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<ScheduledExecutorService> zzfpr;
    private final zzdxp<zzcnz> zzgbd;

    private zzctm(zzdxp<zzdhd> zzdxpVar, zzdxp<ScheduledExecutorService> zzdxpVar2, zzdxp<String> zzdxpVar3, zzdxp<zzcob> zzdxpVar4, zzdxp<Context> zzdxpVar5, zzdxp<zzczu> zzdxpVar6, zzdxp<zzcnz> zzdxpVar7) {
        this.zzfcv = zzdxpVar;
        this.zzfpr = zzdxpVar2;
        this.zzfdc = zzdxpVar3;
        this.zzeki = zzdxpVar4;
        this.zzejv = zzdxpVar5;
        this.zzfep = zzdxpVar6;
        this.zzgbd = zzdxpVar7;
    }

    public static zzctm zza(zzdxp<zzdhd> zzdxpVar, zzdxp<ScheduledExecutorService> zzdxpVar2, zzdxp<String> zzdxpVar3, zzdxp<zzcob> zzdxpVar4, zzdxp<Context> zzdxpVar5, zzdxp<zzczu> zzdxpVar6, zzdxp<zzcnz> zzdxpVar7) {
        return new zzctm(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5, zzdxpVar6, zzdxpVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzctj(this.zzfcv.get(), this.zzfpr.get(), this.zzfdc.get(), this.zzeki.get(), this.zzejv.get(), this.zzfep.get(), this.zzgbd.get());
    }
}
