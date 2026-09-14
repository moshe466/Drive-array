package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbul implements zzdxg<zzbdi> {
    private final zzbtv zzfje;

    private zzbul(zzbtv zzbtvVar) {
        this.zzfje = zzbtvVar;
    }

    public static zzbul zzc(zzbtv zzbtvVar) {
        return new zzbul(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfje.zzaft();
    }
}
