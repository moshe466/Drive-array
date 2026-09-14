package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* loaded from: classes.dex */
public final class zzcfs implements zzdxg<ApplicationInfo> {
    private final zzdxp<Context> zzejv;

    private zzcfs(zzdxp<Context> zzdxpVar) {
        this.zzejv = zzdxpVar;
    }

    public static zzcfs zzaa(zzdxp<Context> zzdxpVar) {
        return new zzcfs(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (ApplicationInfo) zzdxm.zza(this.zzejv.get().getApplicationInfo(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
