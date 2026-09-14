package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbkb implements zzdxg<String> {
    private static final zzbkb zzfdr = new zzbkb();

    public static zzbkb zzafx() {
        return zzfdr;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (String) zzdxm.zza("app_open_ad", "Cannot return null from a non-@Nullable @Provides method");
    }
}
