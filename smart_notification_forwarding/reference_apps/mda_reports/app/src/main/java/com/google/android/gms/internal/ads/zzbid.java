package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbid implements zzdxg<zzsf> {
    private static final zzbid zzfbb = new zzbid();

    public static zzbid zzafb() {
        return zzfbb;
    }

    public static zzsf zzafc() {
        return (zzsf) zzdxm.zza(new zzsf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzafc();
    }
}
