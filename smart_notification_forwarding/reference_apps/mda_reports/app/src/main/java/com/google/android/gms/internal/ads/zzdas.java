package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdas implements zzdxg<zzdao> {
    private final zzdxp<zzdam> zzfcw;
    private final zzdaq zzgne;
    private final zzdxp<String> zzgnf;

    private zzdas(zzdaq zzdaqVar, zzdxp<zzdam> zzdxpVar, zzdxp<String> zzdxpVar2) {
        this.zzgne = zzdaqVar;
        this.zzfcw = zzdxpVar;
        this.zzgnf = zzdxpVar2;
    }

    public static zzdas zza(zzdaq zzdaqVar, zzdxp<zzdam> zzdxpVar, zzdxp<String> zzdxpVar2) {
        return new zzdas(zzdaqVar, zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzdao) zzdxm.zza(this.zzfcw.get().zzgl(this.zzgnf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
