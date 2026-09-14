package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public final class zzcrp implements zzdxg<zzcrk<zzcue>> {
    private final zzdxp<zzcuh> zzeky;
    private final zzdxp<Clock> zzfcz;

    public zzcrp(zzdxp<zzcuh> zzdxpVar, zzdxp<Clock> zzdxpVar2) {
        this.zzeky = zzdxpVar;
        this.zzfcz = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzcrk) zzdxm.zza(new zzcrk(this.zzeky.get(), zzaau.zzcsu.get().longValue(), this.zzfcz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
