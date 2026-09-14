package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbok implements zzdxg<zzczu> {
    private final zzbod zzfhi;

    private zzbok(zzbod zzbodVar) {
        this.zzfhi = zzbodVar;
    }

    public static zzbok zzi(zzbod zzbodVar) {
        return new zzbok(zzbodVar);
    }

    public static zzczu zzj(zzbod zzbodVar) {
        return (zzczu) zzdxm.zza(zzbodVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzj(this.zzfhi);
    }
}
