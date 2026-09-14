package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
final /* synthetic */ class zzcfg implements zzdgf {
    static final zzdgf a = new zzcfg();

    private zzcfg() {
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final zzdhe zzf(Object obj) {
        return zzdgs.zzk(((ExecutionException) obj).getCause());
    }
}
