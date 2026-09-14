package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzdav implements zzdxg<Context> {
    private final zzdaq zzgne;
    private final zzdxp<zzdao> zzgng;

    private zzdav(zzdaq zzdaqVar, zzdxp<zzdao> zzdxpVar) {
        this.zzgne = zzdaqVar;
        this.zzgng = zzdxpVar;
    }

    public static Context zzb(zzdaq zzdaqVar, zzdao zzdaoVar) {
        return (Context) zzdxm.zza(zzdaoVar.zzyv, "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzdav zzc(zzdaq zzdaqVar, zzdxp<zzdao> zzdxpVar) {
        return new zzdav(zzdaqVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzb(this.zzgne, this.zzgng.get());
    }
}
