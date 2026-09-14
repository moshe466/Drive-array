package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public final class zzbnj implements zzdxg<zzbnk> {
    private final zzdxp<Clock> zzfcz;
    private final zzdxp<zzavd> zzfgu;

    private zzbnj(zzdxp<Clock> zzdxpVar, zzdxp<zzavd> zzdxpVar2) {
        this.zzfcz = zzdxpVar;
        this.zzfgu = zzdxpVar2;
    }

    public static zzbnj zzb(zzdxp<Clock> zzdxpVar, zzdxp<zzavd> zzdxpVar2) {
        return new zzbnj(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbnk(this.zzfcz.get(), this.zzfgu.get());
    }
}
