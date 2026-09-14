package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzcqk implements zzdxg<zzcqi> {
    private final zzdxp<Set<String>> zzgew;

    private zzcqk(zzdxp<Set<String>> zzdxpVar) {
        this.zzgew = zzdxpVar;
    }

    public static zzcqk zzai(zzdxp<Set<String>> zzdxpVar) {
        return new zzcqk(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcqi(this.zzgew.get());
    }
}
