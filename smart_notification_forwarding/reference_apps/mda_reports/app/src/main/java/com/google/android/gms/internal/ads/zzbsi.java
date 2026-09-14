package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public final class zzbsi implements zzdxg<zzclp> {
    private final zzdxp<Clock> zzfcz;
    private final zzbrm zzfim;

    private zzbsi(zzbrm zzbrmVar, zzdxp<Clock> zzdxpVar) {
        this.zzfim = zzbrmVar;
        this.zzfcz = zzdxpVar;
    }

    public static zzbsi zzb(zzbrm zzbrmVar, zzdxp<Clock> zzdxpVar) {
        return new zzbsi(zzbrmVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzclp) zzdxm.zza(this.zzfim.zza(this.zzfcz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
