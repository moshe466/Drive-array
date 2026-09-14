package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzblj implements zzdxg<String> {
    private static final zzblj zzfer = new zzblj();

    public static zzblj zzagk() {
        return zzfer;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (String) zzdxm.zza("banner", "Cannot return null from a non-@Nullable @Provides method");
    }
}
