package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbpv implements zzdxg<zzbpm> {
    private final zzdxp<Set<zzbsu<zzbov>>> zzfeo;

    private zzbpv(zzdxp<Set<zzbsu<zzbov>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbpv zzj(zzdxp<Set<zzbsu<zzbov>>> zzdxpVar) {
        return new zzbpv(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbpm(this.zzfeo.get());
    }
}
