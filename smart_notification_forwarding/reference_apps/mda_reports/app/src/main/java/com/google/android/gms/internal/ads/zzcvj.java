package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcvj implements zzcty<JSONObject> {
    private String zzghz;
    private String zzgia;

    public zzcvj(String str, String str2) {
        this.zzghz = str;
        this.zzgia = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzaxs.zzb(jSONObject, "pii");
            zzb.put("doritos", this.zzghz);
            zzb.put("doritos_v2", this.zzgia);
        } catch (JSONException unused) {
            zzavs.zzed("Failed putting doritos string.");
        }
    }
}
