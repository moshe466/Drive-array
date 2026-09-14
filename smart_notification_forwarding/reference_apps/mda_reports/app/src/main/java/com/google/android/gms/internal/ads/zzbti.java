package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbti implements zzdxg<zzbte> {
    private final zzdxp<Set<zzbsu<zzafx>>> zzfeo;

    public zzbti(zzdxp<Set<zzbsu<zzafx>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbte(this.zzfeo.get());
    }
}
