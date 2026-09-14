package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbua implements zzdxg<View> {
    private final zzbtv zzfje;

    private zzbua(zzbtv zzbtvVar) {
        this.zzfje = zzbtvVar;
    }

    public static zzbua zza(zzbtv zzbtvVar) {
        return new zzbua(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfje.zzaig();
    }
}
