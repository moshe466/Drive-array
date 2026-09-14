package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final /* synthetic */ class zzcwc implements zzcty {
    static final zzcty a = new zzcwc();

    private zzcwc() {
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final void zzr(Object obj) {
        try {
            ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451009);
        } catch (JSONException unused) {
        }
    }
}
