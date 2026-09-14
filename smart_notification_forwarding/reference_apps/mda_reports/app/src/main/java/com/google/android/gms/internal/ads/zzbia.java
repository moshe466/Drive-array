package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbia implements zzdxg<com.google.android.gms.gass.zzf> {
    private final zzdxp<Context> zzejv;

    public zzbia(zzdxp<Context> zzdxpVar) {
        this.zzejv = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (com.google.android.gms.gass.zzf) zzdxm.zza(new com.google.android.gms.gass.zzf(this.zzejv.get(), com.google.android.gms.ads.internal.zzq.zzle().zzxb()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
