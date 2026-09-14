package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzbgn implements zzdxg<HashMap<String, zzchh>> {
    private static final zzbgn zzejw = new zzbgn();

    public static zzbgn zzacv() {
        return zzejw;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (HashMap) zzdxm.zza(new HashMap(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
