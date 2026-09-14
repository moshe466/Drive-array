package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcnu implements zzdxg<zzcns> {
    private final zzcns zzgbz;

    private zzcnu(zzcns zzcnsVar) {
        this.zzgbz = zzcnsVar;
    }

    public static zzcnu zzd(zzcns zzcnsVar) {
        return new zzcnu(zzcnsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        zzcns zzcnsVar = this.zzgbz;
        if (zzcnsVar != null) {
            return (zzcns) zzdxm.zza(zzcnsVar, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
