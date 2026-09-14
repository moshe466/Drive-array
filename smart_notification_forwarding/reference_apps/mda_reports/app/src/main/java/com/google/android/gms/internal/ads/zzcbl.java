package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcbl implements zzdxg<String> {
    private static final zzcbl zzfrc = new zzcbl();

    public static zzcbl zzakt() {
        return zzfrc;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (String) zzdxm.zza("rewarded", "Cannot return null from a non-@Nullable @Provides method");
    }
}
