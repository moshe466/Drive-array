package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbqm implements zzdxg<zzbqj> {
    private final zzdxp<Set<zzbsu<com.google.android.gms.ads.internal.overlay.zzo>>> zzfeo;

    private zzbqm(zzdxp<Set<zzbsu<com.google.android.gms.ads.internal.overlay.zzo>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbqm zzn(zzdxp<Set<zzbsu<com.google.android.gms.ads.internal.overlay.zzo>>> zzdxpVar) {
        return new zzbqm(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbqj(this.zzfeo.get());
    }
}
