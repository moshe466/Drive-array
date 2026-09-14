package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbll implements zzdxg<Boolean> {
    private final zzdxp<zzczu> zzfep;

    public zzbll(zzdxp<zzczu> zzdxpVar) {
        this.zzfep = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return Boolean.valueOf(((Boolean) zzve.zzoy().zzd(this.zzfep.get().zzaoo() != null ? zzzn.zzcjp : zzzn.zzcoy)).booleanValue());
    }
}
