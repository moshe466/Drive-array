package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcus implements zzcty<JSONObject> {
    private final String zzghn;

    public zzcus(String str) {
        this.zzghn = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("ms", this.zzghn);
        } catch (JSONException e) {
            zzavs.zza("Failed putting Ad ID.", e);
        }
    }
}
