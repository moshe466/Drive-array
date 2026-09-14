package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
final class zzbvw implements zzafn<Object> {
    private WeakReference<zzbvr> zzfkv;

    private zzbvw(zzbvr zzbvrVar) {
        this.zzfkv = new WeakReference<>(zzbvrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zza(Object obj, Map<String, String> map) {
        zzbvr zzbvrVar = this.zzfkv.get();
        if (zzbvrVar == null) {
            return;
        }
        zzbvr.a(zzbvrVar).onAdImpression();
    }
}
