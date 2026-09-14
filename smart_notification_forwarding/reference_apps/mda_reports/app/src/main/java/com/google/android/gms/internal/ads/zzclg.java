package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzclg implements zzdxg<zzclb> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzbvm> zzfyl;

    public zzclg(zzdxp<Context> zzdxpVar, zzdxp<zzbvm> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzfyl = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzclb(this.zzejv.get(), this.zzfyl.get());
    }
}
