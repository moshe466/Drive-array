package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdau implements zzdxg<zzavp> {
    private final zzdaq zzgne;
    private final zzdxp<zzdao> zzgng;

    private zzdau(zzdaq zzdaqVar, zzdxp<zzdao> zzdxpVar) {
        this.zzgne = zzdaqVar;
        this.zzgng = zzdxpVar;
    }

    public static zzdau zzb(zzdaq zzdaqVar, zzdxp<zzdao> zzdxpVar) {
        return new zzdau(zzdaqVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzavp) zzdxm.zza(this.zzgng.get().zzdpz, "Cannot return null from a non-@Nullable @Provides method");
    }
}
