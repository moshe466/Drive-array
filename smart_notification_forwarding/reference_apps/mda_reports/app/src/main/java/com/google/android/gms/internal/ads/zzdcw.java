package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class zzdcw implements zzdxg<zzdcr> {
    private final zzdxp<zzdcq> zzenf;
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<ScheduledExecutorService> zzfdw;

    private zzdcw(zzdxp<zzdhd> zzdxpVar, zzdxp<ScheduledExecutorService> zzdxpVar2, zzdxp<zzdcq> zzdxpVar3) {
        this.zzfcv = zzdxpVar;
        this.zzfdw = zzdxpVar2;
        this.zzenf = zzdxpVar3;
    }

    public static zzdcw zzr(zzdxp<zzdhd> zzdxpVar, zzdxp<ScheduledExecutorService> zzdxpVar2, zzdxp<zzdcq> zzdxpVar3) {
        return new zzdcw(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzdcr(this.zzfcv.get(), this.zzfdw.get(), this.zzenf.get());
    }
}
