package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
public final class zzbir implements zzbil {
    private final zzavu zzdrk;

    public zzbir(zzavu zzavuVar) {
        this.zzdrk = zzavuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbil
    public final void zzk(Map<String, String> map) {
        String str = map.get("key");
        String str2 = map.get("value");
        if ("auto_collect_location".equals(str)) {
            this.zzdrk.zzaq(Boolean.parseBoolean(str2));
        }
    }
}
