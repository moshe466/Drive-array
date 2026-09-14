package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbse implements zzdxg<zzbrm> {
    private final zzbrm zzfim;

    private zzbse(zzbrm zzbrmVar) {
        this.zzfim = zzbrmVar;
    }

    public static zzbse zzv(zzbrm zzbrmVar) {
        return new zzbse(zzbrmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        zzbrm zzbrmVar = this.zzfim;
        if (zzbrmVar != null) {
            return (zzbrm) zzdxm.zza(zzbrmVar, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
