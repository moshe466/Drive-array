package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

/* loaded from: classes.dex */
final /* synthetic */ class zzckv implements zzdgf {
    static final zzdgf a = new zzckv();

    private zzckv() {
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final zzdhe zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean(FirebaseAnalytics.Param.SUCCESS)) {
            return zzdgs.zzaj(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzajr("process json failed");
    }
}
