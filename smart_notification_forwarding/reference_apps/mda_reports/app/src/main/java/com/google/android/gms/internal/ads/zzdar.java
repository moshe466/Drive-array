package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzdar implements zzdxg<zzdam> {
    private final zzdxp<zzazb> zzfdb;
    private final zzdxp<Context> zzfhb;
    private final zzdxp<zzave> zzgev;

    public zzdar(zzdxp<Context> zzdxpVar, zzdxp<zzazb> zzdxpVar2, zzdxp<zzave> zzdxpVar3) {
        this.zzfhb = zzdxpVar;
        this.zzfdb = zzdxpVar2;
        this.zzgev = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzdam(this.zzfhb.get(), this.zzfdb.get(), this.zzgev.get());
    }
}
