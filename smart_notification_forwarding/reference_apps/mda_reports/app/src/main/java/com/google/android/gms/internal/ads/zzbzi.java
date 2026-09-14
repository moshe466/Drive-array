package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbzi implements zzdxg<zzbze> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzbyu> zzfoy;

    public zzbzi(zzdxp<Executor> zzdxpVar, zzdxp<zzbyu> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzfoy = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbze(this.zzfcv.get(), this.zzfoy.get());
    }
}
