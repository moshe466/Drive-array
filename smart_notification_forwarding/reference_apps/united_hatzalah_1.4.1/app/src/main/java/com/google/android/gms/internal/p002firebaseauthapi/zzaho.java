package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzaho {
    private Long zza;
    private Long zzb;

    public static zzaho zza(String str) {
        try {
            zzaho zzahoVar = new zzaho();
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("iss");
            jSONObject.optString("aud");
            jSONObject.optString("sub");
            zzahoVar.zza = Long.valueOf(jSONObject.optLong("iat"));
            zzahoVar.zzb = Long.valueOf(jSONObject.optLong("exp"));
            jSONObject.optBoolean("is_anonymous");
            return zzahoVar;
        } catch (JSONException e4) {
            if (Log.isLoggable("JwtToken", 3)) {
                String.valueOf(e4);
            }
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. ".concat(String.valueOf(e4)));
        }
    }

    public final Long zzb() {
        return this.zza;
    }

    public final Long zza() {
        return this.zzb;
    }
}
