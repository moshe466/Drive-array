package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbnl implements zzdxg<zzbsu<zzty>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzbiw> zzfdq;

    private zzbnl(zzdxp<zzbiw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfdq = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzbnl zzc(zzdxp<zzbiw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzbnl(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
