package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcgo implements zzdxg<zzcgm> {
    private final zzdxp<Context> zzejv;

    public zzcgo(zzdxp<Context> zzdxpVar) {
        this.zzejv = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcgm(this.zzejv.get());
    }
}
