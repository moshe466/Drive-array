package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbum implements zzdxg<View> {
    private final zzbtv zzfje;

    private zzbum(zzbtv zzbtvVar) {
        this.zzfje = zzbtvVar;
    }

    public static zzbum zzd(zzbtv zzbtvVar) {
        return new zzbum(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfje.zzaif();
    }
}
