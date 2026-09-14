package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbtp implements zzdxg<zzbtj> {
    private final zzdxp<Set<zzbsu<VideoController.VideoLifecycleCallbacks>>> zzfeo;

    private zzbtp(zzdxp<Set<zzbsu<VideoController.VideoLifecycleCallbacks>>> zzdxpVar) {
        this.zzfeo = zzdxpVar;
    }

    public static zzbtp zzt(zzdxp<Set<zzbsu<VideoController.VideoLifecycleCallbacks>>> zzdxpVar) {
        return new zzbtp(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbtj(this.zzfeo.get());
    }
}
