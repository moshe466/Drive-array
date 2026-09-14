package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbmy implements zzdxg<zzczt> {
    private final zzbmt zzfgf;

    private zzbmy(zzbmt zzbmtVar) {
        this.zzfgf = zzbmtVar;
    }

    public static zzbmy zze(zzbmt zzbmtVar) {
        return new zzbmy(zzbmtVar);
    }

    public static zzczt zzf(zzbmt zzbmtVar) {
        return (zzczt) zzdxm.zza(zzbmtVar.zzagw(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzf(this.zzfgf);
    }
}
