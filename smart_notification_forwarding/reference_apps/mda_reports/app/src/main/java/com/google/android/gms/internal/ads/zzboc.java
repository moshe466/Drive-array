package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzboc implements zzdxg<zzbqp> {
    private final zzdxp<zzbqp> zzfhe;

    private zzboc(zzdxp<zzbqp> zzdxpVar) {
        this.zzfhe = zzdxpVar;
    }

    public static zzboc zzf(zzdxp<zzbqp> zzdxpVar) {
        return new zzboc(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbqp) zzdxm.zza(this.zzfhe.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
