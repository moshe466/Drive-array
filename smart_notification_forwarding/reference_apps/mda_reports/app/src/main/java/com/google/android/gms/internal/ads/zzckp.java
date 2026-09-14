package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzckp implements zzdxg<zzckl> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzbup> zzfyl;

    public zzckp(zzdxp<Context> zzdxpVar, zzdxp<zzbup> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzfyl = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzckl(this.zzejv.get(), this.zzfyl.get());
    }
}
