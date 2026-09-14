package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbvj implements zzdxg<zzbwz> {
    private final zzbvi zzfjv;

    private zzbvj(zzbvi zzbviVar) {
        this.zzfjv = zzbviVar;
    }

    public static zzbvj zzc(zzbvi zzbviVar) {
        return new zzbvj(zzbviVar);
    }

    public static zzbwz zzd(zzbvi zzbviVar) {
        return (zzbwz) zzdxm.zza(zzbviVar.zzaij(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzd(this.zzfjv);
    }
}
