package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzboh implements zzdxg<String> {
    private final zzbod zzfhi;

    private zzboh(zzbod zzbodVar) {
        this.zzfhi = zzbodVar;
    }

    public static zzboh zzg(zzbod zzbodVar) {
        return new zzboh(zzbodVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfhi.e();
    }
}
