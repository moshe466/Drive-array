package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbqy implements zzdxg<zzbqw> {
    private final zzdxp<Set<zzbsu<zzbrb>>> zzfeo;

    private zzbqy(zzdxp<Set<zzbsu<zzbrb>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbqy zzo(zzdxp<Set<zzbsu<zzbrb>>> zzdxpVar) {
        return new zzbqy(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbqw(this.zzfeo.get());
    }
}
