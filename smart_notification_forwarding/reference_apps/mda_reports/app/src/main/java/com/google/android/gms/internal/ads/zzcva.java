package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcva implements zzcty<JSONObject> {
    private JSONObject zzght;

    public zzcva(JSONObject jSONObject) {
        this.zzght = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("cache_state", this.zzght);
        } catch (JSONException unused) {
            zzavs.zzed("Unable to get cache_state");
        }
    }
}
