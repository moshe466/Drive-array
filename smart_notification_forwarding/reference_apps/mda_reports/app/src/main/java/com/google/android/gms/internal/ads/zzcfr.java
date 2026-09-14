package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
public final class zzcfr implements zzdxg<List<String>> {
    private static final zzcfr zzfvb = new zzcfr();

    public static zzcfr zzalr() {
        return zzfvb;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (List) zzdxm.zza(zzzn.zzqg(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
