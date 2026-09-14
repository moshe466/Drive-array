package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcwf implements zzdxg<zzcub<? extends zzcty<JSONObject>>> {
    private static final zzcwf zzgij = new zzcwf();

    public static zzcub<? extends zzcty<JSONObject>> zzaoa() {
        return (zzcub) zzdxm.zza(zzcwd.a, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzaoa();
    }
}
