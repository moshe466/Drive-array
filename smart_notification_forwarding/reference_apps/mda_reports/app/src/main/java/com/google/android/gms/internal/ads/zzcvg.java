package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcvg implements zzdxg<zzcve> {
    private final zzdxp<Context> zzfhb;

    public zzcvg(zzdxp<Context> zzdxpVar) {
        this.zzfhb = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcve(this.zzfhb.get());
    }
}
