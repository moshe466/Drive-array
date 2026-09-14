package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbji implements zzdxg<zzbjd> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzakh> zzfcw;
    private final zzdxp<zzbjb> zzfcx;
    private final zzdxp<zzbiy> zzfcy;
    private final zzdxp<Clock> zzfcz;

    private zzbji(zzdxp<zzakh> zzdxpVar, zzdxp<zzbjb> zzdxpVar2, zzdxp<Executor> zzdxpVar3, zzdxp<zzbiy> zzdxpVar4, zzdxp<Clock> zzdxpVar5) {
        this.zzfcw = zzdxpVar;
        this.zzfcx = zzdxpVar2;
        this.zzfcv = zzdxpVar3;
        this.zzfcy = zzdxpVar4;
        this.zzfcz = zzdxpVar5;
    }

    public static zzbji zza(zzdxp<zzakh> zzdxpVar, zzdxp<zzbjb> zzdxpVar2, zzdxp<Executor> zzdxpVar3, zzdxp<zzbiy> zzdxpVar4, zzdxp<Clock> zzdxpVar5) {
        return new zzbji(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbjd(this.zzfcw.get(), this.zzfcx.get(), this.zzfcv.get(), this.zzfcy.get(), this.zzfcz.get());
    }
}
