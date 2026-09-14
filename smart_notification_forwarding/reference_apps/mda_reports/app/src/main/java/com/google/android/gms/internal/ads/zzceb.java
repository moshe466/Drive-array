package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public final class zzceb implements zzdxg<zzcec> {
    private final zzdxp<Clock> zzfcz;

    public zzceb(zzdxp<Clock> zzdxpVar) {
        this.zzfcz = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcec(this.zzfcz.get());
    }
}
