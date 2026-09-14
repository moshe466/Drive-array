package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbvk implements zzdxg<zzbvi> {
    private final zzbvi zzfjv;

    private zzbvk(zzbvi zzbviVar) {
        this.zzfjv = zzbviVar;
    }

    public static zzbvk zze(zzbvi zzbviVar) {
        return new zzbvk(zzbviVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        zzbvi zzbviVar = this.zzfjv;
        if (zzbviVar != null) {
            return (zzbvi) zzdxm.zza(zzbviVar, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
