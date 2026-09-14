package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class zzcpw implements zzdxg<zzcpu> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<ViewGroup> zzgac;
    private final zzdxp<zzdhd> zzgem;

    public zzcpw(zzdxp<zzdhd> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<zzczu> zzdxpVar3, zzdxp<ViewGroup> zzdxpVar4) {
        this.zzgem = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfep = zzdxpVar3;
        this.zzgac = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcpu(this.zzgem.get(), this.zzejv.get(), this.zzfep.get(), this.zzgac.get());
    }
}
