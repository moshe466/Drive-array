package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcme implements zzdxg<zzcma> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzcbi> zzfyl;

    public zzcme(zzdxp<Context> zzdxpVar, zzdxp<zzcbi> zzdxpVar2) {
        this.zzejv = zzdxpVar;
        this.zzfyl = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcma(this.zzejv.get(), this.zzfyl.get());
    }
}
