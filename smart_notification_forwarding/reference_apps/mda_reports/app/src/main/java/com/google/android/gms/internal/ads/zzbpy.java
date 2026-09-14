package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbpy implements zzdxg<zzbpw> {
    private final zzdxp<Set<zzbsu<zzbqb>>> zzfeo;

    private zzbpy(zzdxp<Set<zzbsu<zzbqb>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbpy zzk(zzdxp<Set<zzbsu<zzbqb>>> zzdxpVar) {
        return new zzbpy(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbpw(this.zzfeo.get());
    }
}
