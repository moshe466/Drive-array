package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcwh implements zzcty<JSONObject> {
    private final Map<String, Object> zzgik;

    public zzcwh(Map<String, Object> map) {
        this.zzgik = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("video_decoders", com.google.android.gms.ads.internal.zzq.zzkq().zzi(this.zzgik));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzavs.zzed(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
