package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzcdw implements zzdxg<zzcdu> {
    private final zzdxp<Clock> zzfcz;
    private final zzdxp<zzcds> zzfsx;
    private final zzdxp<Set<zzcdt>> zzfsy;

    private zzcdw(zzdxp<zzcds> zzdxpVar, zzdxp<Set<zzcdt>> zzdxpVar2, zzdxp<Clock> zzdxpVar3) {
        this.zzfsx = zzdxpVar;
        this.zzfsy = zzdxpVar2;
        this.zzfcz = zzdxpVar3;
    }

    public static zzcdw zzl(zzdxp<zzcds> zzdxpVar, zzdxp<Set<zzcdt>> zzdxpVar2, zzdxp<Clock> zzdxpVar3) {
        return new zzcdw(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcdu(this.zzfsx.get(), this.zzfsy.get(), this.zzfcz.get());
    }
}
