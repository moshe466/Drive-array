package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
public final class zzbkr implements zzdxg<View> {
    private final zzbkn zzfen;

    public zzbkr(zzbkn zzbknVar) {
        this.zzfen = zzbknVar;
    }

    public static View zza(zzbkn zzbknVar) {
        return (View) zzdxm.zza(zzbknVar.zzaga(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzfen);
    }
}
