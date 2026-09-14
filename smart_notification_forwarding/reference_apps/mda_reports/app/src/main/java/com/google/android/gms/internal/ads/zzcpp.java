package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzcpp implements zzdxg<Set<String>> {
    private final zzcpj zzged;

    public zzcpp(zzcpj zzcpjVar) {
        this.zzged = zzcpjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(this.zzged.zzamz(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
