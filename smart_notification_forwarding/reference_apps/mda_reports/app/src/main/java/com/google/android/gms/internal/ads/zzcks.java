package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcks implements zzcis<zzdac, zzcjy> {
    private final zzcka zzftq;

    public zzcks(zzcka zzckaVar) {
        this.zzftq = zzckaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcis
    public final zzcip<zzdac, zzcjy> zzd(String str, JSONObject jSONObject) {
        zzdac zze = this.zzftq.zze(str, jSONObject);
        if (zze == null) {
            return null;
        }
        return new zzcip<>(zze, new zzcjy(), str);
    }
}
