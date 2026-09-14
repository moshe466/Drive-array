package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public final class zzbxs implements zzdxg<zzbxq> {
    private final zzdxp<zzcaj> zzeuj;
    private final zzdxp<Clock> zzfcz;

    public zzbxs(zzdxp<zzcaj> zzdxpVar, zzdxp<Clock> zzdxpVar2) {
        this.zzeuj = zzdxpVar;
        this.zzfcz = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbxq(this.zzeuj.get(), this.zzfcz.get());
    }
}
