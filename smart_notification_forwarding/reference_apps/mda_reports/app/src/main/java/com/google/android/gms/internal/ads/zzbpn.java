package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbpn implements zzdxg<zzbpg> {
    private final zzdxp<Set<zzbsu<zzbph>>> zzfeo;

    private zzbpn(zzdxp<Set<zzbsu<zzbph>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbpn zzi(zzdxp<Set<zzbsu<zzbph>>> zzdxpVar) {
        return new zzbpn(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbpg(this.zzfeo.get());
    }
}
