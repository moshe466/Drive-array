package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcfo implements zzdxg<zzdhe<Bundle>> {
    private final zzdxp<zzcua<Bundle>> zzeop;
    private final zzdxp<zzdcr> zzfet;

    private zzcfo(zzdxp<zzdcr> zzdxpVar, zzdxp<zzcua<Bundle>> zzdxpVar2) {
        this.zzfet = zzdxpVar;
        this.zzeop = zzdxpVar2;
    }

    public static zzcfo zzab(zzdxp<zzdcr> zzdxpVar, zzdxp<zzcua<Bundle>> zzdxpVar2) {
        return new zzcfo(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzdhe) zzdxm.zza(this.zzfet.get().zzu(zzdco.SIGNALS).zzc(this.zzeop.get().zzs(new Bundle())).zzaqg(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
