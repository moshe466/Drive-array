package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbvz implements zzdxg<zzbww> {
    private final zzdxp<zzbwv> zzetz;
    private final zzbvy zzfla;

    public zzbvz(zzbvy zzbvyVar, zzdxp<zzbwv> zzdxpVar) {
        this.zzfla = zzbvyVar;
        this.zzetz = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbww) zzdxm.zza(this.zzetz.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
