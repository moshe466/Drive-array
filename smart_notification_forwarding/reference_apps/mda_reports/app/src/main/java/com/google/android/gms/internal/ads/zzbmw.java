package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbmw implements zzdxg<zzczl> {
    private final zzbmt zzfgf;

    private zzbmw(zzbmt zzbmtVar) {
        this.zzfgf = zzbmtVar;
    }

    public static zzbmw zzc(zzbmt zzbmtVar) {
        return new zzbmw(zzbmtVar);
    }

    public static zzczl zzd(zzbmt zzbmtVar) {
        return (zzczl) zzdxm.zza(zzbmtVar.zzagx(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzd(this.zzfgf);
    }
}
