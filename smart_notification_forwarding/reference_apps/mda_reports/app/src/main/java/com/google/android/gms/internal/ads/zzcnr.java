package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcnr implements zzdxg<zzaak> {
    private final zzcns zzgbz;

    private zzcnr(zzcns zzcnsVar) {
        this.zzgbz = zzcnsVar;
    }

    public static zzcnr zzc(zzcns zzcnsVar) {
        return new zzcnr(zzcnsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzgbz.a();
    }
}
