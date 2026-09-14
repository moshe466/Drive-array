package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzddc implements zzdxg<zzdda> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzayy> zzekm;
    private final zzdxp<zzczs> zzezj;
    private final zzdxp<zzdq> zzfbr;
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<Clock> zzfcz;
    private final zzdxp<zzazb> zzfdb;
    private final zzdxp<String> zzgfg;
    private final zzdxp<String> zzgfh;
    private final zzdxp<zzclp> zzgro;

    private zzddc(zzdxp<Executor> zzdxpVar, zzdxp<zzayy> zzdxpVar2, zzdxp<zzclp> zzdxpVar3, zzdxp<zzazb> zzdxpVar4, zzdxp<String> zzdxpVar5, zzdxp<String> zzdxpVar6, zzdxp<Context> zzdxpVar7, zzdxp<zzczs> zzdxpVar8, zzdxp<Clock> zzdxpVar9, zzdxp<zzdq> zzdxpVar10) {
        this.zzfcv = zzdxpVar;
        this.zzekm = zzdxpVar2;
        this.zzgro = zzdxpVar3;
        this.zzfdb = zzdxpVar4;
        this.zzgfg = zzdxpVar5;
        this.zzgfh = zzdxpVar6;
        this.zzejv = zzdxpVar7;
        this.zzezj = zzdxpVar8;
        this.zzfcz = zzdxpVar9;
        this.zzfbr = zzdxpVar10;
    }

    public static zzddc zzb(zzdxp<Executor> zzdxpVar, zzdxp<zzayy> zzdxpVar2, zzdxp<zzclp> zzdxpVar3, zzdxp<zzazb> zzdxpVar4, zzdxp<String> zzdxpVar5, zzdxp<String> zzdxpVar6, zzdxp<Context> zzdxpVar7, zzdxp<zzczs> zzdxpVar8, zzdxp<Clock> zzdxpVar9, zzdxp<zzdq> zzdxpVar10) {
        return new zzddc(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5, zzdxpVar6, zzdxpVar7, zzdxpVar8, zzdxpVar9, zzdxpVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzdda(this.zzfcv.get(), this.zzekm.get(), this.zzgro.get(), this.zzfdb.get(), this.zzgfg.get(), this.zzgfh.get(), this.zzejv.get(), this.zzezj.get(), this.zzfcz.get(), this.zzfbr.get());
    }
}
