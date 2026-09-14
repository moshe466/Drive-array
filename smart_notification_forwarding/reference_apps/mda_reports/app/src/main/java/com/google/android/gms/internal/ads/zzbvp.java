package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbvp implements zzdxg<zzdaf<zzcaj>> {
    private final zzdxp<zzdhd> zzfcv;
    private final zzdxp<zzcat> zzfjy;

    public zzbvp(zzdxp<zzcat> zzdxpVar, zzdxp<zzdhd> zzdxpVar2) {
        this.zzfjy = zzdxpVar;
        this.zzfcv = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzdaf) zzdxm.zza(new zzdaf(this.zzfjy.get(), this.zzfcv.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
