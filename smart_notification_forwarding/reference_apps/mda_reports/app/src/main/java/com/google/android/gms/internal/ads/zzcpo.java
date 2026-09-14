package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzcpo implements zzdxg<zzdhe<zzcps>> {
    private final zzdxp<zzdcr> zzfet;
    private final zzdxp<zzdhe<zzaqk>> zzfgk;
    private final zzdxp<zzcpr> zzgee;

    public zzcpo(zzdxp<zzdcr> zzdxpVar, zzdxp<zzcpr> zzdxpVar2, zzdxp<zzdhe<zzaqk>> zzdxpVar3) {
        this.zzfet = zzdxpVar;
        this.zzgee = zzdxpVar2;
        this.zzfgk = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzdhe) zzdxm.zza(this.zzfet.get().zza((zzdcr) zzdco.GENERATE_SIGNALS, (zzdhe) this.zzfgk.get()).zza(this.zzgee.get()).zza(((Integer) zzve.zzoy().zzd(zzzn.zzcox)).intValue(), TimeUnit.SECONDS).zzaqg(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
