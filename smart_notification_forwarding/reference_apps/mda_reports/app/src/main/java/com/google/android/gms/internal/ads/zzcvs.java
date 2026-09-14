package com.google.android.gms.internal.ads;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcvs implements zzcty<JSONObject> {
    private Bundle zzgie;

    public zzcvs(Bundle bundle) {
        this.zzgie = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (this.zzgie != null) {
            try {
                zzaxs.zzb(zzaxs.zzb(jSONObject2, "device"), "play_store").put("parental_controls", com.google.android.gms.ads.internal.zzq.zzkq().zzd(this.zzgie));
            } catch (JSONException unused) {
                zzavs.zzed("Failed putting parental controls bundle.");
            }
        }
    }
}
