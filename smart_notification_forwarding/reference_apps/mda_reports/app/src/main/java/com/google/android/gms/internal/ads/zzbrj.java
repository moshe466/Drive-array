package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbrj implements zzdxg<zzbrf> {
    private final zzdxp<Set<zzbsu<zzbri>>> zzfeo;

    private zzbrj(zzdxp<Set<zzbsu<zzbri>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbrj zzq(zzdxp<Set<zzbsu<zzbri>>> zzdxpVar) {
        return new zzbrj(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbrf(this.zzfeo.get());
    }
}
