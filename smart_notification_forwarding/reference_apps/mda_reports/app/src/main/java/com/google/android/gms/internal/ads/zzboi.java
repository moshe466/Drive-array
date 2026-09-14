package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzboi implements zzdxg<String> {
    private final zzdxp<zzbnk> zzema;
    private final zzbod zzfhi;

    private zzboi(zzbod zzbodVar, zzdxp<zzbnk> zzdxpVar) {
        this.zzfhi = zzbodVar;
        this.zzema = zzdxpVar;
    }

    public static zzboi zzb(zzbod zzbodVar, zzdxp<zzbnk> zzdxpVar) {
        return new zzboi(zzbodVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (String) zzdxm.zza(this.zzema.get().zzuy(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
