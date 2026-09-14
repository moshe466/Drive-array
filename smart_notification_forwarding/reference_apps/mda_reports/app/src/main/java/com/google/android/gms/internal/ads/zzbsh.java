package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbsh implements zzdxg<Set<zzbsu<VideoController.VideoLifecycleCallbacks>>> {
    private final zzbrm zzfim;

    private zzbsh(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbsh zzy(zzbrm zzbrmVar) {
        return new zzbsh(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Set) zzdxm.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
