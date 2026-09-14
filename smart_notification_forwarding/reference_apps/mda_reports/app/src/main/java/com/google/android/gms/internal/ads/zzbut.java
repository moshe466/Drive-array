package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbut implements zzdxg<String> {
    private static final zzbut zzfjh = new zzbut();

    public static zzbut zzaih() {
        return zzfjh;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (String) zzdxm.zza("interstitial", "Cannot return null from a non-@Nullable @Provides method");
    }
}
