package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzblb implements zzdxg<zzbsu<zzps>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzbmc> zzfdq;
    private final zzbkn zzfen;

    public zzblb(zzbkn zzbknVar, zzdxp<zzbmc> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfen = zzbknVar;
        this.zzfdq = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
