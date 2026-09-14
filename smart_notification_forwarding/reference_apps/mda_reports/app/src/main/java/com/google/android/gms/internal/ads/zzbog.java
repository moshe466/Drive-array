package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbog implements zzdxg<Context> {
    private final zzdxp<Context> zzfhb;
    private final zzbod zzfhi;

    private zzbog(zzbod zzbodVar, zzdxp<Context> zzdxpVar) {
        this.zzfhi = zzbodVar;
        this.zzfhb = zzdxpVar;
    }

    public static zzbog zza(zzbod zzbodVar, zzdxp<Context> zzdxpVar) {
        return new zzbog(zzbodVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Context) zzdxm.zza(this.zzfhi.a(this.zzfhb.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
