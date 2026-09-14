package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbwc implements zzdxg<zzbxa> {
    private final zzbvy zzfla;
    private final zzdxp<zzbvr> zzflc;

    public zzbwc(zzbvy zzbvyVar, zzdxp<zzbvr> zzdxpVar) {
        this.zzfla = zzbvyVar;
        this.zzflc = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbxa) zzdxm.zza(this.zzflc.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
