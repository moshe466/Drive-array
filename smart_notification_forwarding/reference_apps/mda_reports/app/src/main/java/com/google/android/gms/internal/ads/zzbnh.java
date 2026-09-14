package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public final class zzbnh implements zzdxg<zzavd> {
    private final zzdxp<zzavp> zzelx;
    private final zzdxp<Clock> zzfcz;
    private final zzdxp<zzczu> zzfep;

    private zzbnh(zzdxp<Clock> zzdxpVar, zzdxp<zzavp> zzdxpVar2, zzdxp<zzczu> zzdxpVar3) {
        this.zzfcz = zzdxpVar;
        this.zzelx = zzdxpVar2;
        this.zzfep = zzdxpVar3;
    }

    public static zzbnh zzg(zzdxp<Clock> zzdxpVar, zzdxp<zzavp> zzdxpVar2, zzdxp<zzczu> zzdxpVar3) {
        return new zzbnh(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzavd) zzdxm.zza(this.zzelx.get().zza(this.zzfcz.get(), this.zzfep.get().zzgmm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
