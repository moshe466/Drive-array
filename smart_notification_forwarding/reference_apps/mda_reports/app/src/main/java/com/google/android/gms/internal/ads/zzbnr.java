package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbnr implements zzdxg<com.google.android.gms.ads.internal.zzc> {
    private final zzdxp<Context> zzejv;
    private final zzbns zzfgy;
    private final zzdxp<zzato> zzfgz;

    private zzbnr(zzbns zzbnsVar, zzdxp<Context> zzdxpVar, zzdxp<zzato> zzdxpVar2) {
        this.zzfgy = zzbnsVar;
        this.zzejv = zzdxpVar;
        this.zzfgz = zzdxpVar2;
    }

    public static zzbnr zza(zzbns zzbnsVar, zzdxp<Context> zzdxpVar, zzdxp<zzato> zzdxpVar2) {
        return new zzbnr(zzbnsVar, zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (com.google.android.gms.ads.internal.zzc) zzdxm.zza(new com.google.android.gms.ads.internal.zzc(this.zzejv.get(), this.zzfgz.get(), null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
