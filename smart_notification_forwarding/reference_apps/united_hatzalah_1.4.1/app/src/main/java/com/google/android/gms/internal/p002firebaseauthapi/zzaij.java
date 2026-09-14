package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzaij implements zzaer<zzaij> {
    private static final String zza = "zzaij";

    public String zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public zzaij zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("phoneSessionInfo") != null) {
                return (zzain) ((zzaij) new zzain().zza(str));
            }
            if (jSONObject.optJSONObject("totpSessionInfo") != null) {
                return (zzaip) ((zzaij) new zzaip().zza(str));
            }
            throw new IllegalArgumentException("Missing phoneSessionInfo or totpSessionInfo.");
        } catch (NullPointerException e4) {
            e = e4;
            throw zzajc.zza(e, zza, str);
        } catch (JSONException e5) {
            e = e5;
            throw zzajc.zza(e, zza, str);
        }
    }
}
