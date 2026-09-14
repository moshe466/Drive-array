package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbnq implements zzdxg<zzbsu<zzbqb>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<zzbiw> zzfdq;

    private zzbnq(zzdxp<zzbiw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfdq = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    public static zzbsu<zzbqb> zza(zzbiw zzbiwVar, Executor executor) {
        return (zzbsu) zzdxm.zza(new zzbsu(zzbiwVar, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzbnq zzg(zzdxp<zzbiw> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        return new zzbnq(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzfdq.get(), this.zzfcv.get());
    }
}
