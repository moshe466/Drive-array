package com.google.android.gms.internal.ads;

import android.location.Location;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcvo implements zzcty<JSONObject> {
    private final Location zzmi;

    public zzcvo(Location location) {
        this.zzmi = location;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            if (this.zzmi != null) {
                JSONObject jSONObject3 = new JSONObject();
                Float valueOf = Float.valueOf(this.zzmi.getAccuracy() * 1000.0f);
                Long valueOf2 = Long.valueOf(this.zzmi.getTime() * 1000);
                Long valueOf3 = Long.valueOf((long) (this.zzmi.getLatitude() * 1.0E7d));
                Long valueOf4 = Long.valueOf((long) (this.zzmi.getLongitude() * 1.0E7d));
                jSONObject3.put("radius", valueOf);
                jSONObject3.put("lat", valueOf3);
                jSONObject3.put("long", valueOf4);
                jSONObject3.put("time", valueOf2);
                jSONObject2.put("uule", jSONObject3);
            }
        } catch (JSONException e) {
            zzavs.zza("Failed adding location to the request JSON.", e);
        }
    }
}
