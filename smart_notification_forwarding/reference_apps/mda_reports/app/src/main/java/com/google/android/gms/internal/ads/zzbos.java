package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbos implements zzdxg<zzboq> {
    private final zzdxp<Set<zzbsu<zzty>>> zzfeo;

    private zzbos(zzdxp<Set<zzbsu<zzty>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbos zzg(zzdxp<Set<zzbsu<zzty>>> zzdxpVar) {
        return new zzbos(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzboq(this.zzfeo.get());
    }
}
