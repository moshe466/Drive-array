package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdat implements zzdxg<zzavu> {
    private final zzdaq zzgne;
    private final zzdxp<zzdao> zzgng;

    private zzdat(zzdaq zzdaqVar, zzdxp<zzdao> zzdxpVar) {
        this.zzgne = zzdaqVar;
        this.zzgng = zzdxpVar;
    }

    public static zzavu zza(zzdaq zzdaqVar, zzdao zzdaoVar) {
        return (zzavu) zzdxm.zza(zzdaoVar.zzdrk, "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzdat zza(zzdaq zzdaqVar, zzdxp<zzdao> zzdxpVar) {
        return new zzdat(zzdaqVar, zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzgne, this.zzgng.get());
    }
}
