package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbya implements zzdxg<zzbxr> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzbxa> zzeth;
    private final zzdxp<zzcaj> zzeuj;
    private final zzdxp<zzcbn> zzfog;
    private final zzdxp<zzbjq> zzfoh;

    public zzbya(zzdxp<Context> zzdxpVar, zzdxp<zzcbn> zzdxpVar2, zzdxp<zzcaj> zzdxpVar3, zzdxp<zzbjq> zzdxpVar4, zzdxp<zzbxa> zzdxpVar5) {
        this.zzejv = zzdxpVar;
        this.zzfog = zzdxpVar2;
        this.zzeuj = zzdxpVar3;
        this.zzfoh = zzdxpVar4;
        this.zzeth = zzdxpVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbxr(this.zzejv.get(), this.zzfog.get(), this.zzeuj.get(), this.zzfoh.get(), this.zzeth.get());
    }
}
