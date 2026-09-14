package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class zzafl implements zzafn<zzbdi> {
    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(zzbdi zzbdiVar, Map map) {
        zzbdi zzbdiVar2 = zzbdiVar;
        if (map.keySet().contains("start")) {
            zzbdiVar2.zzaz(true);
        }
        if (map.keySet().contains("stop")) {
            zzbdiVar2.zzaz(false);
        }
    }
}
