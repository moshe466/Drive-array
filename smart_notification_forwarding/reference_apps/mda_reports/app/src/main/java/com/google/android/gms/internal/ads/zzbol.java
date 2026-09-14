package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbol implements zzdxg<zzczs> {
    private final zzbod zzfhi;

    private zzbol(zzbod zzbodVar) {
        this.zzfhi = zzbodVar;
    }

    public static zzbol zzk(zzbod zzbodVar) {
        return new zzbol(zzbodVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfhi.c();
    }
}
