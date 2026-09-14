package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcjo implements zzdxg<zzcjk> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzblg> zzfyl;

    public zzcjo(zzdxp<Context> zzdxpVar, zzdxp<zzblg> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzfyl = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcjk(this.zzejv.get(), this.zzfyl.get());
    }
}
