package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcbk implements zzdxg<zzcio<zzcbb>> {
    private final zzdxp<zzcna<zzcbb, zzdac, zzcjx>> zzfcx;
    private final zzdxp<zzczu> zzfep;
    private final zzdxp<zzcna<zzcbb, zzdac, zzcjy>> zzfrb;

    public zzcbk(zzdxp<zzcna<zzcbb, zzdac, zzcjx>> zzdxpVar, zzdxp<zzcna<zzcbb, zzdac, zzcjy>> zzdxpVar2, zzdxp<zzczu> zzdxpVar3) {
        this.zzfcx = zzdxpVar;
        this.zzfrb = zzdxpVar2;
        this.zzfep = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzcio) zzdxm.zza(this.zzfep.get().zzgms.contains("new_rewarded") ? this.zzfrb.get() : this.zzfcx.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
