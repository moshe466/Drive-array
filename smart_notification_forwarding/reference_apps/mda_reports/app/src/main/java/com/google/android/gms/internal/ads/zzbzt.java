package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbzt implements zzdxg<zzbzq> {
    private final zzdxp<Executor> zzfei;
    private final zzdxp<zzbjq> zzfoh;
    private final zzdxp<zzbst> zzfpz;

    public zzbzt(zzdxp<Executor> zzdxpVar, zzdxp<zzbjq> zzdxpVar2, zzdxp<zzbst> zzdxpVar3) {
        this.zzfei = zzdxpVar;
        this.zzfoh = zzdxpVar2;
        this.zzfpz = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbzq(this.zzfei.get(), this.zzfoh.get(), this.zzfpz.get());
    }
}
