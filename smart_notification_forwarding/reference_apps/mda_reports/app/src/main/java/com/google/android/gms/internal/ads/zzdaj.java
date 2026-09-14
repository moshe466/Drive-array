package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* loaded from: classes.dex */
public final class zzdaj implements zzdxg<Clock> {
    private final zzdag zzgna;

    public zzdaj(zzdag zzdagVar) {
        this.zzgna = zzdagVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Clock) zzdxm.zza(DefaultClock.getInstance(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
