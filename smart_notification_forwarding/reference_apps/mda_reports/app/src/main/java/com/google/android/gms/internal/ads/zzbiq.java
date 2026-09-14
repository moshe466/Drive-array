package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
public final class zzbiq implements zzbil {
    private zzavu zzdrk;

    public zzbiq(zzavu zzavuVar) {
        this.zzdrk = zzavuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbil
    public final void zzk(Map<String, String> map) {
        this.zzdrk.zzap(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
