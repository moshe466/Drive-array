package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdbu implements zzdxg<zzdhd> {
    private static final zzdbu zzgps = new zzdbu();

    public static zzdbu zzapy() {
        return zzgps;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzdhd) zzdxm.zza(zzazd.zzdwi, "Cannot return null from a non-@Nullable @Provides method");
    }
}
