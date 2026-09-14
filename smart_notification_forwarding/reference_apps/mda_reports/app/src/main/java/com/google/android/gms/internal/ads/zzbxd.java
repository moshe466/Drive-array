package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbxd implements zzdxg<zzats> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzczu> zzfep;
    private final zzbxe zzfmy;

    private zzbxd(zzbxe zzbxeVar, zzdxp<Context> zzdxpVar, zzdxp<zzczu> zzdxpVar2) {
        this.zzfmy = zzbxeVar;
        this.zzejv = zzdxpVar;
        this.zzfep = zzdxpVar2;
    }

    public static zzbxd zza(zzbxe zzbxeVar, zzdxp<Context> zzdxpVar, zzdxp<zzczu> zzdxpVar2) {
        return new zzbxd(zzbxeVar, zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzats) zzdxm.zza(new zzats(this.zzejv.get(), this.zzfep.get().zzgmm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
