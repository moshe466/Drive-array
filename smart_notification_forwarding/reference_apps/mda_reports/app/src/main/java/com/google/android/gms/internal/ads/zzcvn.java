package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcvn implements zzcty<JSONObject> {
    private List<String> zzdiz;

    public zzcvn(List<String> list) {
        this.zzdiz = list;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("eid", TextUtils.join(",", this.zzdiz));
        } catch (JSONException unused) {
            zzavs.zzed("Failed putting experiment ids.");
        }
    }
}
