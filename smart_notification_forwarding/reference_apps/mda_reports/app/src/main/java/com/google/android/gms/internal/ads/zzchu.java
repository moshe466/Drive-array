package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzchu implements zzdxg<zzchr> {
    private final zzdxp<Context> zzejv;

    private zzchu(zzdxp<Context> zzdxpVar) {
        this.zzejv = zzdxpVar;
    }

    public static zzchu zzac(zzdxp<Context> zzdxpVar) {
        return new zzchu(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzchr(this.zzejv.get());
    }
}
