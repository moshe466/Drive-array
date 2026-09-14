package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcqf implements zzdxg<zzcqa> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzdhe<String>> zzger;

    private zzcqf(zzdxp<zzdhe<String>> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzger = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzcqf zzak(zzdxp<zzdhe<String>> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzcqf(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcqa(this.zzger.get(), this.zzfcv.get());
    }
}
