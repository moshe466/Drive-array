package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbpb implements zzdxg<zzboz> {
    private final zzdxp<Set<zzbsu<zzbpa>>> zzfeo;

    public zzbpb(zzdxp<Set<zzbsu<zzbpa>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzboz(this.zzfeo.get());
    }
}
