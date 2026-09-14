package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
final class zzbvt implements zzafn<Object> {
    private WeakReference<zzbvr> zzfkv;

    private zzbvt(zzbvr zzbvrVar) {
        this.zzfkv = new WeakReference<>(zzbvrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zza(Object obj, Map<String, String> map) {
        zzbvr zzbvrVar = this.zzfkv.get();
        if (zzbvrVar != null && "_ac".equals(map.get("eventName"))) {
            zzbvr.b(zzbvrVar).onAdClicked();
        }
    }
}
