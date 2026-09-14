package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcxx implements zzdxg<zzcxt<zzcbi, zzcbb>> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdax> zzelm;
    private final zzdxp<zzdbn> zzeln;

    public zzcxx(zzdxp<Context> zzdxpVar, zzdxp<zzdax> zzdxpVar2, zzdxp<zzdbn> zzdxpVar3) {
        this.zzejv = zzdxpVar;
        this.zzelm = zzdxpVar2;
        this.zzeln = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        Context context = this.zzejv.get();
        return (zzcxt) zzdxm.zza(((Integer) zzve.zzoy().zzd(zzzn.zzcql)).intValue() > 0 ? new zzcxg(this.zzeln.get().zzb(zzdbh.Rewarded, context), this.zzelm.get(), new zzcxr(), new zzcxf(), zzazd.zzdwe) : new zzcxr(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
