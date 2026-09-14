package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbug implements zzdxg<zzbsu<zzafx>> {
    private final zzdxp<zzcaz> zzfdq;
    private final zzbtv zzfje;

    public zzbug(zzbtv zzbtvVar, zzdxp<zzcaz> zzdxpVar) {
        this.zzfje = zzbtvVar;
        this.zzfdq = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbsu) zzdxm.zza(new zzbsu(this.zzfdq.get(), zzazd.zzdwj), "Cannot return null from a non-@Nullable @Provides method");
    }
}
