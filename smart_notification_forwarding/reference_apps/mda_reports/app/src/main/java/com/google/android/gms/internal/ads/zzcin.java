package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzcin<DelegateT, AdapterT> implements zzcio<AdapterT> {

    @VisibleForTesting
    private final zzcio<DelegateT> zzfyd;
    private final zzded<DelegateT, AdapterT> zzfye;

    public zzcin(zzcio<DelegateT> zzcioVar, zzded<DelegateT, AdapterT> zzdedVar) {
        this.zzfyd = zzcioVar;
        this.zzfye = zzdedVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final boolean zza(zzczt zzcztVar, zzczl zzczlVar) {
        return this.zzfyd.zza(zzcztVar, zzczlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcio
    public final zzdhe<AdapterT> zzb(zzczt zzcztVar, zzczl zzczlVar) {
        return zzdgs.zzb(this.zzfyd.zzb(zzcztVar, zzczlVar), this.zzfye, zzazd.zzdwe);
    }
}
