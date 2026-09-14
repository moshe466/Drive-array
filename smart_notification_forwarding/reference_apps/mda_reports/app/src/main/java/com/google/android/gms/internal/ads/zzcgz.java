package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
final /* synthetic */ class zzcgz implements zzdby {
    static final zzdby a = new zzcgz();

    private zzcgz() {
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzavs.zzed("Ad request signals:");
        zzavs.zzed(jSONObject.toString(2));
        return jSONObject;
    }
}
