package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcuw implements zzcty<JSONObject> {
    private final JSONObject zzghp;

    public zzcuw(JSONObject jSONObject) {
        this.zzghp = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzaxs.zzb(jSONObject, "content_info");
            JSONObject jSONObject2 = this.zzghp;
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzb.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
            zzavs.zzed("Failed putting app indexing json.");
        }
    }
}
