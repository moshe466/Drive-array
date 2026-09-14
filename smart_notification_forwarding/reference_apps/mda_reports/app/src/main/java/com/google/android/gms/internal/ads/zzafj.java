package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class zzafj implements zzafn<zzbdi> {
    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(zzbdi zzbdiVar, Map map) {
        zzbdi zzbdiVar2 = zzbdiVar;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbdiVar2.zzjv();
        } else if ("resume".equals(str)) {
            zzbdiVar2.zzjw();
        }
    }
}
