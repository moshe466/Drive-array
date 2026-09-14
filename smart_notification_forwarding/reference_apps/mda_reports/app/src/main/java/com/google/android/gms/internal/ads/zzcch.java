package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcch implements zzdxg<zzbsu<zzbph>> {
    private final zzdxp<zzccg> zzfdq;
    private final zzcci zzfrq;

    private zzcch(zzcci zzcciVar, zzdxp<zzccg> zzdxpVar) {
        this.zzfrq = zzcciVar;
        this.zzfdq = zzdxpVar;
    }

    public static zzcch zza(zzcci zzcciVar, zzdxp<zzccg> zzdxpVar) {
        return new zzcch(zzcciVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), zzazd.zzdwi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
