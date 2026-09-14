package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbta implements zzdxg<zzbsy> {
    private final zzdxp<Set<zzbsu<zzbsz>>> zzfeo;

    private zzbta(zzdxp<Set<zzbsu<zzbsz>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbta zzs(zzdxp<Set<zzbsu<zzbsz>>> zzdxpVar) {
        return new zzbta(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbsy(this.zzfeo.get());
    }
}
