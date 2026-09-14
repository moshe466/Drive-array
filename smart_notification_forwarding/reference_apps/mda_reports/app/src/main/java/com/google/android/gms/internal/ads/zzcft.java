package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcft implements zzdxg<String> {
    private final zzdxp<Context> zzejv;

    private zzcft(zzdxp<Context> zzdxpVar) {
        this.zzejv = zzdxpVar;
    }

    public static zzcft zzab(zzdxp<Context> zzdxpVar) {
        return new zzcft(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (String) zzdxm.zza(this.zzejv.get().getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
