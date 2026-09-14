package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbwb implements zzdxg<zzcaj> {
    private final zzbvy zzfla;

    public zzbwb(zzbvy zzbvyVar) {
        this.zzfla = zzbvyVar;
    }

    public static zzcaj zza(zzbvy zzbvyVar) {
        return (zzcaj) zzdxm.zza(zzbvyVar.zzait(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zza(this.zzfla);
    }
}
