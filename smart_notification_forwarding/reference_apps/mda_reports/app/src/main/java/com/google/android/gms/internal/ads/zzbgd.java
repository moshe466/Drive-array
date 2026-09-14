package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbgd implements zzdxg<Context> {
    private final zzbga zzejr;

    public zzbgd(zzbga zzbgaVar) {
        this.zzejr = zzbgaVar;
    }

    public static Context zza(zzbga zzbgaVar) {
        return (Context) zzdxm.zza(zzbgaVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzejr);
    }
}
