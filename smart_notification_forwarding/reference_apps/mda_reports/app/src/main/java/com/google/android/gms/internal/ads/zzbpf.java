package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbpf implements zzdxg<zzbpd> {
    private final zzdxp<Set<zzbsu<zzbpe>>> zzfeo;

    private zzbpf(zzdxp<Set<zzbsu<zzbpe>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbpf zzh(zzdxp<Set<zzbsu<zzbpe>>> zzdxpVar) {
        return new zzbpf(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbpd(this.zzfeo.get());
    }
}
