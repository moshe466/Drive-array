package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbxf implements zzdxg<zzbws> {
    private final zzbxe zzfmy;

    private zzbxf(zzbxe zzbxeVar) {
        this.zzfmy = zzbxeVar;
    }

    public static zzbxf zza(zzbxe zzbxeVar) {
        return new zzbxf(zzbxeVar);
    }

    public static zzbws zzb(zzbxe zzbxeVar) {
        return (zzbws) zzdxm.zza(zzbxeVar.zzajx(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzb(this.zzfmy);
    }
}
