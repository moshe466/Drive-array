package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
public final class zzbio implements zzbil {
    private zzavu zzdrk;

    public zzbio(zzavu zzavuVar) {
        this.zzdrk = zzavuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbil
    public final void zzk(Map<String, String> map) {
        this.zzdrk.zzao(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
