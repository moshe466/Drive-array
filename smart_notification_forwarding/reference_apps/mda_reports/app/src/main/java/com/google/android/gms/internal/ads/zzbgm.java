package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbgm implements zzdxg<zzaqy> {
    private final zzdxp<Context> zzejv;

    public zzbgm(zzdxp<Context> zzdxpVar) {
        this.zzejv = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        Context context = this.zzejv.get();
        return (zzaqy) zzdxm.zza(new zzaqw(context, new zzard(context).zztz()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
