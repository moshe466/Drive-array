package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcmy implements zzcis<zzani, zzcjy> {
    private final zzcnz zzgbe;

    public zzcmy(zzcnz zzcnzVar) {
        this.zzgbe = zzcnzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcis
    public final zzcip<zzani, zzcjy> zzd(String str, JSONObject jSONObject) {
        zzani zzgh = this.zzgbe.zzgh(str);
        if (zzgh == null) {
            return null;
        }
        return new zzcip<>(zzgh, new zzcjy(), str);
    }
}
