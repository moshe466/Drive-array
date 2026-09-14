package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbmv implements zzdxg<String> {
    private final zzbmt zzfgf;

    private zzbmv(zzbmt zzbmtVar) {
        this.zzfgf = zzbmtVar;
    }

    public static zzbmv zza(zzbmt zzbmtVar) {
        return new zzbmv(zzbmtVar);
    }

    public static String zzb(zzbmt zzbmtVar) {
        return (String) zzdxm.zza(zzbmtVar.zzagy(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzb(this.zzfgf);
    }
}
