package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbqh implements zzdxg<zzbqf> {
    private final zzdxp<Set<zzbsu<zzbqg>>> zzfeo;

    private zzbqh(zzdxp<Set<zzbsu<zzbqg>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbqh zzm(zzdxp<Set<zzbsu<zzbqg>>> zzdxpVar) {
        return new zzbqh(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbqf(this.zzfeo.get());
    }
}
