package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbsr implements zzdxg<zzbsq> {
    private final zzdxp<Set<zzbsu<zzbsn>>> zzfeo;

    private zzbsr(zzdxp<Set<zzbsu<zzbsn>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbsr zzr(zzdxp<Set<zzbsu<zzbsn>>> zzdxpVar) {
        return new zzbsr(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbsq(this.zzfeo.get());
    }
}
