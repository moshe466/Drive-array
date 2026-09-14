package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbym implements zzdxg<zzbsu<VideoController.VideoLifecycleCallbacks>> {
    private final zzdxp<zzcax> zzfdd;
    private final zzdxp<Executor> zzfei;
    private final zzbyg zzfon;

    public zzbym(zzbyg zzbygVar, zzdxp<zzcax> zzdxpVar, zzdxp<Executor> zzdxpVar2) {
        this.zzfon = zzbygVar;
        this.zzfdd = zzdxpVar;
        this.zzfei = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdd.get(), this.zzfei.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
