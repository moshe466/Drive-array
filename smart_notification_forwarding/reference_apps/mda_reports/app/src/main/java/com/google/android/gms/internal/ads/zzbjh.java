package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbjh implements zzdxg<zzbiy> {
    private final zzdxp<zzpn> zzfct;
    private final zzdxp<zzakh> zzfcu;
    private final zzdxp<Executor> zzfcv;

    private zzbjh(zzdxp<zzpn> zzdxpVar, zzdxp<zzakh> zzdxpVar2, zzdxp<Executor> zzdxpVar3) {
        this.zzfct = zzdxpVar;
        this.zzfcu = zzdxpVar2;
        this.zzfcv = zzdxpVar3;
    }

    public static zzbjh zza(zzdxp<zzpn> zzdxpVar, zzdxp<zzakh> zzdxpVar2, zzdxp<Executor> zzdxpVar3) {
        return new zzbjh(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        zzpn zzpnVar = this.zzfct.get();
        return (zzbiy) zzdxm.zza(new zzbiy(zzpnVar.zzkm(), this.zzfcu.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
