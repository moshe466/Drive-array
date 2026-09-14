package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
public final class zzbjv implements zzdxg<View> {
    private final zzbjw zzfdn;

    public zzbjv(zzbjw zzbjwVar) {
        this.zzfdn = zzbjwVar;
    }

    public static View zza(zzbjw zzbjwVar) {
        return (View) zzdxm.zza(zzbjwVar.zzafu(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzfdn);
    }
}
