package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbsf implements zzdxg<zzcxq> {
    private final zzbrm zzfim;

    private zzbsf(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbsf zzw(zzbrm zzbrmVar) {
        return new zzbsf(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfim.zzahv();
    }
}
